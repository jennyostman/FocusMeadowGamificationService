package exarb.fmgamificationlogic.model;

import exarb.fmgamificationlogic.enums.AchievementType;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;


/**
 * This is a model that holds a users achievement data
 */
@Data
@Document("userAchievementData")
public class UserAchievementData {

    private String id;
    private String userId;
    private List<AchievementType> achievedAchievements;
    private long focusedMinutesTotal;
    private Map<LocalDate, Integer> timerSessionResults;

    public UserAchievementData(String userId, List<AchievementType> achievedAchievements,
                               long focusedMinutesTotal, Map<LocalDate, Integer> timerSessionResults) {
        this.userId = userId;
        this.achievedAchievements = achievedAchievements;
        this.focusedMinutesTotal = focusedMinutesTotal;
        this.timerSessionResults = timerSessionResults;
    }
}
