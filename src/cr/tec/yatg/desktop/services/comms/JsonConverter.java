package cr.tec.yatg.desktop.services.comms;

import com.fasterxml.jackson.databind.ObjectMapper;
import cr.tec.yatg.desktop.structures.Item;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by joseph on 10/2/16.
 */
public class JsonConverter {
	private static JsonConverter ourInstance = new JsonConverter();

	public String json;

	public OutputMessage matrixObject = null;
	public ArrayList<Item> items = null;

	private JsonConverter() {
	}

	public static JsonConverter getInstance() {
		return ourInstance;
	}

	public void setJson(String json) {
		this.json = json;
		ObjectMapper mapper = new ObjectMapper();
		OutputMessage newMessage = new OutputMessage();
		try {
			newMessage = mapper.readValue(json, OutputMessage.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}

		this.matrixObject = newMessage;
		this.items = newMessage.getItemList();

	}
}
