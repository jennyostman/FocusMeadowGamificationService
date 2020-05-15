package exarb.fmgamificationlogic.model;

import exarb.fmgamificationlogic.enums.AchievementType;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;


@Data
@Document("allAvailableAchievements")
public class AllAvailableAchievements {

    private String id;
    private Map<AchievementType, Achievement> achievements;

}
