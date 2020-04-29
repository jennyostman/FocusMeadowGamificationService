package exarb.fmgamificationlogic.client.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import exarb.fmgamificationlogic.client.TimerResultDeserializer;

@JsonDeserialize(using = TimerResultDeserializer.class)
public class TimerResult {

    private String userId;
    private Long timeInMillis;

    public TimerResult(String userId, Long timeInMillis) {
        this.userId = userId;
        this.timeInMillis = timeInMillis;
    }

    public TimerResult() {
        this.userId = null;
        this.timeInMillis = -1L;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getTimeInMillis() {
        return timeInMillis;
    }

    public void setTimeInMillis(Long timeInMillis) {
        this.timeInMillis = timeInMillis;
    }

    @Override
    public String toString() {
        return "TimerResult{" +
                "userId='" + userId + '\'' +
                ", timeInMillis=" + timeInMillis +
                '}';
    }
}
