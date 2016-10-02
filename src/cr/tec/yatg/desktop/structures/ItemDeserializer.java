package Structures;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.*;

public class ItemDeserializer extends StdDeserializer<Item> { 
	 
    public ItemDeserializer() { 
        this(null); 
    } 
 
    public ItemDeserializer(Class<?> vc) { 
        super(vc); 
    }
    
    @Override
    public Item deserialize(JsonParser jp, DeserializationContext ctxt) 
      throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);
        int indexI = (Integer) ((IntNode) node.get("indexI")).numberValue();
        int indexJ = (Integer) ((IntNode) node.get("indexJ")).numberValue();
        int value = (Integer) ((IntNode) node.get("value")).numberValue();
        Boolean isHead = (Boolean) ((BooleanNode) node.get("isHead")).booleanValue();
        
        String itemName = node.get("itemName").asText();
        int userId = (Integer) ((IntNode) node.get("createdBy")).numberValue();
 
        return new Item(id, itemName, new User(userId, null));
    }
 
    
    public Item deserilalize(JsonParser jp, DeserializationContext ctxt) 
      throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);
        int id = (Integer) ((IntNode) node.get("id")).numberValue();
        String itemName = node.get("itemName").asText();
        int userId = (Integer) ((IntNode) node.get("createdBy")).numberValue();
 
        return new Item(id, itemName, new User(userId, null));
    }
}