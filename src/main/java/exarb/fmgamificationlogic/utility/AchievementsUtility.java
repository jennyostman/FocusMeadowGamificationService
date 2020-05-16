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


@Slf4j
@Component
public class AchievementsUtility {

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


    public UserAchievementData updateUserAchievementDataForUser(TimerResult timerResult, UserGameData userGameData,
                                                                UserAchievementData userAchievementData){

        long totalTime = userAchievementData.getFocusedMinutesTotal() + timerResult.getTime();
        userAchievementData.setFocusedMinutesTotal(totalTime);
        userAchievementData.getTimerSessionResults().put(LocalDate.now(), timerResult.getTime());

        if (checkForCoinAchievements(userGameData.getCoins()) != null){
            userAchievementData.getAchievedAchievements().add(checkForCoinAchievements(userGameData.getCoins()));
        }
        if (checkForTotalTimeAchievements(userAchievementData.getFocusedMinutesTotal()) != null){
            userAchievementData.getAchievedAchievements().add(checkForTotalTimeAchievements(userAchievementData.getFocusedMinutesTotal()));
        }
        log.info("UserAchievementData object is updated for user {}", timerResult.getUserId());
        return userAchievementData;
    }

    private AchievementType checkForCoinAchievements(int coins){
        if (coins >= 500){
            System.out.println("CHEST_OF_SEEDS");
            return AchievementType.CHEST_OF_SEEDS;
        }
        return null;
    }

    private AchievementType checkForTotalTimeAchievements(long focusedMinutesTotal){
        if (focusedMinutesTotal >= 360){
            System.out.println("SPROUT");
            return AchievementType.SPROUT;
        }
        return null;
    }
}
