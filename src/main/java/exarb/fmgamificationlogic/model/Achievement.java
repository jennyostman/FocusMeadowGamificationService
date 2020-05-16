package exarb.fmgamificationlogic.model;

import exarb.fmgamificationlogic.enums.AchievementType;
import lombok.Data;

/**
 * This is a model that holds all values of an achievement
 */
@Data
public class Achievement {

    private String image;
    private String name;
    private AchievementType achievementType;
    private String description;


}
