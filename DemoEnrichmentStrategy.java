import org.apache.camel.AggregationStrategy;
import org.apache.camel.Exchange;

import javax.inject.Named;
import javax.inject.Singleton;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
@Named("DemoEnrichmentStrategy")
public class DemoEnrichmentStrategy implements AggregationStrategy {
    
    private static Logger LOGGER = LoggerFactory.getLogger(DemoEnrichmentStrategy.class);

    @Override
    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {

        if (oldExchange == null) {
            LOGGER.info("no body found in oldExchange");
            return newExchange;
        }
        String oldBody = oldExchange.getIn().getBody(String.class);
       
        LOGGER.info(oldBody);
        JSONObject oldJson = parsePayload(oldBody);
        JSONObject result = new JSONObject();
        result.put("id", oldJson.get("id"));
        result.put("firstName", oldJson.get("firstname"));
        result.put("lastName", oldJson.get("lastname"));
        String newBody = newExchange.getIn().getBody(String.class);
        JSONObject newJson = parsePayload(newBody);
        result.put("licenceStatus", newJson.get("licenceStatus"));
        oldExchange.getIn().setBody(result.toString());
  
        return oldExchange;
    }

    private JSONObject parsePayload(String payload){
        JSONParser parser = new JSONParser();  
        JSONObject result = new JSONObject();
        try{
            result = (JSONObject) parser.parse(payload);  
            LOGGER.info(result.toString());
            result = (JSONObject) result.get("args");
            LOGGER.info(result.toString());
        } catch (Exception e){
            LOGGER.error("JSON Parsing ", e);
        }
        return result;
    }
}