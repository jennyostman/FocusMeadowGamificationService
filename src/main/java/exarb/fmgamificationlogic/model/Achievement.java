package exarb.fmgamificationlogic.model;

import exarb.fmgamificationlogic.enums.AchievementType;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
public class Achievement {

    private String image;
    private String name;
    private AchievementType achievementType;
    private String description;


}
