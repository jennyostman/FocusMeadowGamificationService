package exarb.fmgamificationlogic.utility;

import exarb.fmgamificationlogic.client.dto.TimerResult;
import exarb.fmgamificationlogic.client.dto.UserGameData;
import exarb.fmgamificationlogic.enums.AchievementType;
import exarb.fmgamificationlogic.model.UserAchievementData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Slf4j
@Component
public class AchievementsUtility {

    /**
     * Creates an object to hold a new users achievement data
     * @param timerResult holds the result from a timerSession
     * @return UserAchievementData
     */
    public UserAchievementData createUserAchievementDataForNewUser(TimerResult timerResult){
        UserAchievementData userAchievementData = new UserAchievementData(
                timerResult.getUserId(),
                new ArrayList<>(),
                timerResult.getTime(),
                new HashMap<>());
        userAchievementData.getAchievedAchievements().add(AchievementType.ROOKIE_SOWER);
        userAchievementData.getTimerSessionResults().put(LocalDate.now(), timerResult.getTime());
        return userAchievementData;
    }

    /**
     * Checks if a user has earned a new achievement, and updates the user achievement data
     * @param timerResult holds the result from a timerSession
     * @param userGameData a users game data
     * @param userAchievementData a users achievement data
     * @return UserAchievementData
     */
    public UserAchievementData updateUserAchievementDataForUser(TimerResult timerResult, UserGameData userGameData,
                                                                UserAchievementData userAchievementData){

        long totalTime = userAchievementData.getFocusedMinutesTotal() + timerResult.getTime();
        userAchievementData.setFocusedMinutesTotal(totalTime);
        userAchievementData.getTimerSessionResults().put(LocalDate.now(), timerResult.getTime());

        if (checkForCoinAchievements(userGameData.getCoins(), userAchievementData.getAchievedAchievements()) != null){
            userAchievementData.getAchievedAchievements().add(checkForCoinAchievements(userGameData.getCoins(), userAchievementData.getAchievedAchievements()));
        }
        if (checkForTotalTimeAchievements(userAchievementData.getFocusedMinutesTotal(), userAchievementData.getAchievedAchievements()) != null){
            userAchievementData.getAchievedAchievements().add(checkForTotalTimeAchievements(userAchievementData.getFocusedMinutesTotal(), userAchievementData.getAchievedAchievements()));
        }
        log.info("UserAchievementData object is updated for user {}", timerResult.getUserId());
        return userAchievementData;
    }

    /**
     * Checks if user has earned a achievement based on coins
     * @param coins a users earned coins
     * @return AchievementType
     */
    private AchievementType checkForCoinAchievements(int coins, List<AchievementType> achievements){
        if (!achievements.contains(AchievementType.CHEST_OF_SEEDS)){
            if (coins >= 500){
                System.out.println("CHEST_OF_SEEDS");
                return AchievementType.CHEST_OF_SEEDS;
            }
        }
        return null;
    }

    /**
     * Checks if user has earned a achievement based on focused time
     * @param focusedMinutesTotal a total of focused minutes
     * @return AchievementType
     */
    private AchievementType checkForTotalTimeAchievements(long focusedMinutesTotal, List<AchievementType> achievements){
        if (!achievements.contains(AchievementType.SPROUT)){
            if (focusedMinutesTotal >= 360){
                System.out.println("SPROUT");
                return AchievementType.SPROUT;
            }
        }
        return null;
    }
}
