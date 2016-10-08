package cr.tec.yatg.desktop.services.comms;

import com.fasterxml.jackson.databind.ObjectMapper;
import cr.tec.yatg.desktop.structures.Item;
import cr.tec.yatg.desktop.structures.SimplePlayer;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by joseph on 10/2/16.
 */
public class JsonParser {
	private static JsonParser ourInstance = new JsonParser();
	private String json;
	private OutputMessage parsedJson = null;
	private ArrayList<Item> items = null;

	private JsonParser() {
	}

	public static JsonParser getInstance() {
		return ourInstance;
	}

	public void parseJson(String newJson) {
		if (this.json == newJson) {
			return;
		}
		ObjectMapper mapper = new ObjectMapper();
		OutputMessage newMessage = new OutputMessage();
		try {
			newMessage = mapper.readValue(newJson, OutputMessage.class);
			this.json = newJson;
		} catch (IOException e) {
			System.out.println("No se pudo procesar el JSON");
			//System.out.println(e.getMessage());
		}

		this.parsedJson = newMessage;
		this.items = newMessage.getItemList();

	}

	public SimplePlayer getPlayerData() {
		return null != parsedJson ? parsedJson.getPlayer() : null;
	}

	public ArrayList<Item> getPowerUps() {
		return null != parsedJson ? parsedJson.getpowerupsList() : null;
	}

	public ArrayList<Item> getPlayerItems() {
		return null != items ? items : null;
	}


}
