package cr.tec.yatg.desktop.services.comms;

import com.fasterxml.jackson.databind.ObjectMapper;
import cr.tec.yatg.desktop.services.ControllerFacade;
import cr.tec.yatg.desktop.structures.Item;
import cr.tec.yatg.desktop.structures.ItemType;
import javafx.application.Platform;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by joseph on 10/2/16.
 */
public class JsonConverter {
	private static JsonConverter ourInstance = new JsonConverter();

	private JsonConverter() {
	}

	public static JsonConverter getInstance() {
		return ourInstance;
	}

	public void doJson(String json) {
		ObjectMapper mapper = new ObjectMapper();
		OutputMessage newMessage = new OutputMessage();
		try {
			newMessage = mapper.readValue(json, OutputMessage.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}

		final OutputMessage msg = newMessage;
		Platform.runLater(() -> {
					ArrayList<Item> items = msg.getItemList();
					for (Item data : items) {
						System.out.println("(" + data.getType() + ")");
						if (data.getType() == ItemType.tronTrail) {
							System.out.println("(" + data.getIndexI() + ", " + data.getIndexJ() + ")");
							if (data.getFirst()) {
								ControllerFacade.getInstance().getMatrix().setMoto(data.getOwner().value, data.getIndexI(), data.getIndexJ());
							} else {
								ControllerFacade.getInstance().getMatrix().setEstela(data.getOwner().value, data.getIndexI(), data.getIndexJ());

							}
						}
					}
				}
		);
	}
}
