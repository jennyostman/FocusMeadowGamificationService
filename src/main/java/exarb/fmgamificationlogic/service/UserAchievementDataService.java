package exarb.fmgamificationlogic.service;

import exarb.fmgamificationlogic.client.TimerResultClient;
import exarb.fmgamificationlogic.client.UserGameDataClient;
import exarb.fmgamificationlogic.client.dto.TimerResult;
import exarb.fmgamificationlogic.client.dto.UserGameData;
import exarb.fmgamificationlogic.event.AchievementDispatcher;
import exarb.fmgamificationlogic.event.AchievementEvent;
import exarb.fmgamificationlogic.exceptions.AchievementException;
import exarb.fmgamificationlogic.model.UserAchievementData;
import exarb.fmgamificationlogic.repository.UserAchievementDataRepository;
import exarb.fmgamificationlogic.utility.AchievementsUtility;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Slf4j
@AllArgsConstructor
@Service
public class UserAchievementDataService {

    private final UserAchievementDataRepository userAchievementDataRepository;
    private final AchievementsUtility achievementsUtility;
    private final TimerResultClient timerResultClient;
    private final UserGameDataClient userGameDataClient;
    private final AchievementDispatcher achievementDispatcher;


    public UserAchievementData getAchievementsForUser(String userId){
        Optional<UserAchievementData> savedUserAchievementData = userAchievementDataRepository.findByUserId(userId);
        if (savedUserAchievementData.isPresent()){
            return savedUserAchievementData.get();
        }
        else {
            log.info("Could not retrieve users achievement data for id {}", userId);
            throw new AchievementException("Could not find achievement info");
        }
    }

    /**
     * Method that checks if a user will get an achievement.
     * @param timerCountSessionId an id for a timer session
     */
    public void checkIfAchievement(String timerCountSessionId, String userId){
        TimerResult timerResult = timerResultClient.retrieveTimerResultById(timerCountSessionId);
        System.out.println("timerResult: " + timerResult.toString());

        UserGameData userGameData = userGameDataClient.retrieveUserGameData(userId);
        System.out.println("userGameData: " + userGameData.toString());

        if (!userAchievementDataRepository.existsByUserId(userId)){
            createUserAchievementDataForNewUser(timerResult);
        }
        else {
            updateUserAchievementDataForUser(timerResult, userGameData);
        }
    }


    private void createUserAchievementDataForNewUser(TimerResult timerResult){
        UserAchievementData userAchievementData = achievementsUtility.createUserAchievementDataForNewUser(timerResult);
        log.info("New UserAchievementData object is saved for user {}", timerResult.getUserId());
        userAchievementDataRepository.save(userAchievementData);

        // TODO: rensa!

        AchievementEvent achievementEvent = new AchievementEvent();
        achievementEvent.setUserAchievementDataId(userAchievementData.getId());
        System.out.println("userAchievementData.getId(): " + userAchievementData.getId());

        // Skicka event message
        achievementDispatcher.sendAchievementEvent(achievementEvent);


    }

    private void updateUserAchievementDataForUser(TimerResult timerResult, UserGameData userGameData){
        Optional<UserAchievementData> savedUserAchievementData = userAchievementDataRepository.findByUserId(timerResult.getUserId());
        if (savedUserAchievementData.isPresent()){
            UserAchievementData updatedUserAchievementData = achievementsUtility.updateUserAchievementDataForUser(timerResult, userGameData, savedUserAchievementData.get());
            userAchievementDataRepository.save(updatedUserAchievementData);
        }
        else {
            log.info("UserAchievementData was not found for user {}", timerResult.getUserId());
            throw new AchievementException("User achievement data was not found");
        }
    }

}
