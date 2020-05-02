package exarb.fmgamificationlogic.event;

import java.io.Serializable;

/**
 * This is a model for an event that is sent when a user has used the timer.
 */
public class TimerCountWorkEvent implements Serializable {

    private String timerCountSessionId;
    private String userId;

    public TimerCountWorkEvent(String timerCountSessionId, String userId) {
        this.timerCountSessionId = timerCountSessionId;
        this.userId = userId;
    }

    public TimerCountWorkEvent() {
    }

    public String getTimerCountSessionId() {
        return timerCountSessionId;
    }

    public String getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "TimerCountWorkEvent{" +
                "timerCountSessionId='" + timerCountSessionId + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
