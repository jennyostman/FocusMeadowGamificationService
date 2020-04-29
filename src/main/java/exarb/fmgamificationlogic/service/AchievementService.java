package exarb.fmgamificationlogic.service;

import exarb.fmgamificationlogic.client.TimerResultClient;
import exarb.fmgamificationlogic.client.dto.TimerResult;
import exarb.fmgamificationlogic.model.Achievement;
import exarb.fmgamificationlogic.repository.AchievementRepository;
import org.springframework.stereotype.Service;


@Service
public class AchievementService {

    private final AchievementRepository achievementRepository;
    private final TimerResultClient timerResultClient;

    public AchievementService(AchievementRepository achievementRepository, TimerResultClient timerResultClient) {
        this.achievementRepository = achievementRepository;
        this.timerResultClient = timerResultClient;
    }


    // Använt för att testa db
    public Achievement addAchievement(Achievement achievement){
        return achievementRepository.save(achievement);
    }


    /**
     * Method that checks if a user will get an achievement.
     * @param timerCountSessionId
     */
    // TODO: Hur mycket ska stå i javadocs här egentligen?
    public void checkIfAchievement(String timerCountSessionId){
        TimerResult timerResult = timerResultClient.retrieveTimerResultById(timerCountSessionId);
        System.out.println("timerResult: " + timerResult);

        // Acheivement-logik här

    }


}
