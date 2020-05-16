package exarb.fmgamificationlogic.client.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import exarb.fmgamificationlogic.client.TimerResultDeserializer;

/**
 * This dto holds information from a users timerSession
 */
@JsonDeserialize(using = TimerResultDeserializer.class)
public class TimerResult {

    private String userId;
    private int time;

    public TimerResult(String userId, int time) {
        this.userId = userId;
        this.time = time;
    }

    public TimerResult() {
        this.userId = null;
        this.time = -1;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "TimerResult{" +
                "userId='" + userId + '\'' +
                ", time=" + time +
                '}';
    }
}
