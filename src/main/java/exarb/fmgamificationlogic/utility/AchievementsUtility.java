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

        // Skicka event message

        return userAchievementData;

    }


    public UserAchievementData updateUserAchievementDataForUser(TimerResult timerResult, UserGameData userGameData,
                                                                UserAchievementData oldUserAchievementData){





        // Om användaren tilldelas ett nytt achievement - skicka event message

        log.info("UserAchievementData object is updated for user {}", timerResult.getUserId());

        return oldUserAchievementData;

    }


}
