package exarb.fmgamificationlogic.client;

import exarb.fmgamificationlogic.client.dto.UserGameData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class UserGameDataClient {

    private final RestTemplate restTemplate;
    private final String gameLogicHost;

    @Autowired
    public UserGameDataClient(RestTemplate restTemplate, @Value("${gamelogicHost}") final String gameLogicHost) {
        this.restTemplate = restTemplate;
        this.gameLogicHost = gameLogicHost;
    }


    public UserGameData retrieveUserGameData(final String id){
        return restTemplate.getForObject(
                gameLogicHost + "/game/" + id,
                UserGameData.class);
    }


}
