package exarb.fmgamificationlogic.model;

import exarb.fmgamificationlogic.enums.AchievementType;
import lombok.Data;

import java.util.Map;


@Data
public class AllAvailableAchievements {

    private String id;
    private Map<AchievementType, Achievement> achievements;

}
