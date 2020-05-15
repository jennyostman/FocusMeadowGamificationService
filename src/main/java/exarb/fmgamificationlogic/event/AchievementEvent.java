package exarb.fmgamificationlogic.event;

import java.io.Serializable;

/**
 * This is a model for an event that is sent when a user has used the timer for work.
 */
public class AchievementEvent implements Serializable {

    private String userAchievementDataId;

    public AchievementEvent() {
    }

    public AchievementEvent(String userAchievementDataId) {
        this.userAchievementDataId = userAchievementDataId;
    }

    public String getUserAchievementDataId() {
        return userAchievementDataId;
    }

    public void setUserAchievementDataId(String userAchievementDataId) {
        this.userAchievementDataId = userAchievementDataId;
    }

    @Override
    public String toString() {
        return "AchievementEvent{" +
                "userAchievementDataId='" + userAchievementDataId + '\'' +
                '}';
    }
}
