package exarb.fmgamificationlogic.client;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import exarb.fmgamificationlogic.client.dto.TimerResult;

import java.io.IOException;


public class TimerResultDeserializer extends JsonDeserializer<TimerResult> {

    /**
     * Deserializes a TimerResult object, and allows to create a new object
     * containing only the necessary variables.
     * @param jsonParser
     * @param deserializationContext
     * @return
     * @throws IOException
     */
    @Override
    public TimerResult deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException {

        ObjectCodec oc = jsonParser.getCodec();
        JsonNode node = oc.readTree(jsonParser);

        return new TimerResult(node.get("userId").asText(),
                node.get("time").asInt());
    }
}
