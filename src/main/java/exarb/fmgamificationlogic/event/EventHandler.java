package exarb.fmgamificationlogic.event;

import exarb.fmgamificationlogic.service.AchievementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class EventHandler {

    private static final Logger log = LoggerFactory.getLogger(EventHandler.class);


    private final AchievementService achievementService;

    public EventHandler(AchievementService achievementService) {
        this.achievementService = achievementService;
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
            achievementService.checkIfAchievement(event.getUserId(),
                    event.getTimerCountSessionId());
        } catch (final Exception e) {
            log.error("Error when trying to process TimerCountWorkEvent", e);
            // The event will not be re-queued and reprocessed repeatedly if
            // something goes wrong.
            // TODO: Since we don’t have anything in place to handle rejected events,
            //  they will be simply discarded. If you want to get deeper into good practices
            //  with RabbitMQ, you can look at how to configure a dead letter exchange and put our
            //  failing messages there for further processing (like retrying, logging, or raising alerts).
            throw new AmqpRejectAndDontRequeueException(e);
        }
    }

}
