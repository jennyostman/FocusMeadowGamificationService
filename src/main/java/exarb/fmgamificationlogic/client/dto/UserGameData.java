package exarb.fmgamificationlogic.client.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import exarb.fmgamificationlogic.client.UserGameDataDeserializer;
import lombok.Data;

@Data
@JsonDeserialize(using = UserGameDataDeserializer.class)
public class UserGameData {

    private String userId;
    private int coins;

    public UserGameData() {
    }

    public UserGameData(String userId, int coins) {
        this.userId = userId;
        this.coins = coins;
    }
}
