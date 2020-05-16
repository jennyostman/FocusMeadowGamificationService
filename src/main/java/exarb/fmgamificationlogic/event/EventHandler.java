package exarb.fmgamificationlogic.event;

import exarb.fmgamificationlogic.service.UserAchievementDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class EventHandler {

    private static final Logger log = LoggerFactory.getLogger(EventHandler.class);

    private final UserAchievementDataService userAchievementDataService;

    public EventHandler(UserAchievementDataService userAchievementDataService) {
        this.userAchievementDataService = userAchievementDataService;
    }


    /**
     * Listens to the timerCount queue, and calls a method in achievementService,
     * with the event data as arguments.
     * @param event, of TimerCountWorkEvent class.
     */
    @RabbitListener(queues = "${timerCount.queue}")
    void handleAchievementWork(final TimerCountWorkEvent event) {
        log.info("TimerCount Work Event received: {}", event.getTimerCountSessionId());
        try {
            userAchievementDataService.checkIfAchievement(event.getTimerCountSessionId(), event.getUserId());
        } catch (final Exception e) {
            log.error("Error when trying to process TimerCountWorkEvent", e);
            throw new AmqpRejectAndDontRequeueException(e);
        }
    }
}
