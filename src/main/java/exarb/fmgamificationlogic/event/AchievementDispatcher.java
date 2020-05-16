package exarb.fmgamificationlogic.event;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AchievementDispatcher {
    private RabbitTemplate rabbitTemplate;
    private String achievementExchange;
    private String newAchievementRoutingKey;

    @Autowired
    AchievementDispatcher(final RabbitTemplate rabbitTemplate,
                          @Value("achievement_exchange") final String achievementExchange,
                          @Value("achievement.new") final String newAchievementRoutingKey) {
        this.rabbitTemplate = rabbitTemplate;
        this.achievementExchange = achievementExchange;
        this.newAchievementRoutingKey = newAchievementRoutingKey;
    }

    /**
     * Converts and sends achievementEvent
     * @param achievementEvent an achievement event object
     */
    public void sendAchievementEvent(final AchievementEvent achievementEvent) {
        rabbitTemplate.convertAndSend(achievementExchange, newAchievementRoutingKey, achievementEvent);
    }
}
