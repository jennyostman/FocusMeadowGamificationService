package exarb.fmgamificationlogic.client;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import exarb.fmgamificationlogic.client.dto.UserGameData;

import java.io.IOException;


public class UserGameDataDeserializer extends JsonDeserializer<UserGameData> {

    /**
     * Deserializes a UserGameData object coming from the Gamelogics service into
     * Gamifications version of UserGameData, and allows to create a new object
     * containing only the necessary variables.
     * @param jsonParser provides access to JSON data
     * @param deserializationContext context for deserialization
     * @return UserGameData
     * @throws IOException
     */
    @Override
    public UserGameData deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException {

        ObjectCodec oc = jsonParser.getCodec();
        JsonNode node = oc.readTree(jsonParser);

        return new UserGameData(node.get("userId").asText(),
                node.get("coins").asInt());
    }
}
