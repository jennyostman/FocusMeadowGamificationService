package exarb.fmgamificationlogic.client;

import exarb.fmgamificationlogic.client.dto.TimerResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TimerResultClient {

    private final RestTemplate restTemplate;
    private final String gameLogicHost;

    @Autowired
    public TimerResultClient(RestTemplate restTemplate, @Value("${gamelogicHost}") final String gameLogicHost) {
        this.restTemplate = restTemplate;
        this.gameLogicHost = gameLogicHost;
    }

    /**
     * Makes a GET call to the gamelogic-service to fetch TimerResult data for a specific id
     * @param id an id for a timer session
     * @return TimerResult
     */
    public TimerResult retrieveTimerResultById(final String id) {
        return restTemplate.getForObject(
                gameLogicHost + "/result/" + id,
                TimerResult.class);
    }


}
