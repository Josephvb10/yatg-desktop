package cr.tec.yatg.desktop.services;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import cr.tec.yatg.desktop.services.Structures.*;
import cr.tec.yatg.desktop.services.Structures.Malla.LinkedMatrix;
import cr.tec.yatg.desktop.services.comms.OutputMessage;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class testMalla {

	public static GenericLinkedList<Item> main() {
		// TODO Auto-generated method stub		
		LinkedMatrix malla = new LinkedMatrix(10,10);
		Item item1 = new Item(ItemType.bomb, 1, 0);
		Item item2 = new Item(ItemType.shield, 2, 1 );
		Item item3 = new Item(ItemType.turbo, 3, 2);
		Item item4 = new Item(ItemType.bomb, 1, 1);
		Item item5 = new Item(ItemType.increaseTail, 1, 2);
		Item item6 = new Item(ItemType.fuel, 5, 3);
		Item item7 = new Item(ItemType.increaseTail, 1, 3);
		
		
		malla.setNodeItem(item1);
		malla.setNodeItem(item2);
		malla.setNodeItem(item3);
		malla.setNodeItem(item4);
		malla.setNodeItem(item5);
		malla.setNodeItem(item6);
		malla.setNodeItem(item7);

		
		//malla.resetNodeItem(item6);
		//System.out.println(malla.getNodo(0, 3).getItem());
		Troncycle player1 = new	Troncycle(Player.player1, 0, 0);
		player1.setCurrentDirection(Direction.up);
		malla.updatePlayer(player1);
		
		malla.updatePlayer(player1);
		player1.setCurrentDirection(Direction.right);

		malla.updatePlayer(player1);
		
		malla.updatePlayer(player1);
		
		malla.updatePlayer(player1);
		
		malla.updatePlayer(player1);
		//System.out.println("hola");

		//String Jsonlist = JsonConverter.objectToJson(malla.getSimpleItemList());
		//System.out.println(Jsonlist);
		//System.out.println(malla.getSimpleItemList());
		//System.out.println("hola");
		OutputMessage mensaje = new OutputMessage(malla.getSimpleItemList(), player1);
		String jsonMens = mensaje.toJson();
		//System.out.println(jsonMens);


		try {
			Socket misocket = new Socket("192.168.1.11", 1313);
			DataOutputStream flujo_salida = new DataOutputStream(misocket.getOutputStream());
			flujo_salida.writeUTF(jsonMens);
			flujo_salida.close();


		} catch (IOException e1) {
			//System.out.println(e1.getMessage());
		}


		String inputMessage = "{\"id\":9999,\"player\":{\"owner\":\"player1\",\"speed\":1,\"fuel\":97.0,\"currentDirection\":\"right\",\"extraTrail\":4,\"powerUpSteps\":0,\"trail\":{\"head\":{\"data\":{\"type\":\"tronTrail\",\"indexI\":8,\"indexJ\":4,\"value\":0,\"owner\":\"player1\",\"head\":true},\"next\":{\"data\":{\"type\":\"tronTrail\",\"indexI\":8,\"indexJ\":3,\"value\":0,\"owner\":\"player1\",\"head\":false},\"next\":{\"data\":{\"type\":\"tronTrail\",\"indexI\":8,\"indexJ\":2,\"value\":0,\"owner\":\"player1\",\"head\":false},\"next\":{\"data\":{\"type\":\"tronTrail\",\"indexI\":8,\"indexJ\":1,\"value\":0,\"owner\":\"player1\",\"head\":false},\"next\":{\"data\":{\"type\":\"tronTrail\",\"indexI\":8,\"indexJ\":0,\"value\":0,\"owner\":\"player1\",\"head\":false},\"next\":{\"data\":{\"type\":\"tronTrail\",\"indexI\":9,\"indexJ\":0,\"value\":0,\"owner\":\"player1\",\"head\":false},\"next\":{\"data\":{\"type\":\"tronTrail\",\"indexI\":0,\"indexJ\":0,\"value\":0,\"owner\":\"player1\",\"head\":false},\"next\":null}}}}}}},\"empty\":false,\"size\":7},\"isDead\":false,\"powerUpActivated\":false},\"itemList\":{\"head\":{\"data\":{\"type\":\"bomb\",\"indexI\":1,\"indexJ\":0,\"value\":0,\"owner\":null,\"head\":false},\"next\":{\"data\":{\"type\":\"bomb\",\"indexI\":1,\"indexJ\":1,\"value\":0,\"owner\":null,\"head\":false},\"next\":{\"data\":{\"type\":\"increaseTail\",\"indexI\":1,\"indexJ\":2,\"value\":6,\"owner\":null,\"head\":false},\"next\":{\"data\":{\"type\":\"increaseTail\",\"indexI\":1,\"indexJ\":3,\"value\":1,\"owner\":null,\"head\":false},\"next\":{\"data\":{\"type\":\"shield\",\"indexI\":2,\"indexJ\":1,\"value\":7,\"owner\":null,\"head\":false},\"next\":{\"data\":{\"type\":\"turbo\",\"indexI\":3,\"indexJ\":2,\"value\":10,\"owner\":null,\"head\":false},\"next\":{\"data\":{\"type\":\"fuel\",\"indexI\":5,\"indexJ\":3,\"value\":57,\"owner\":null,\"head\":false},\"next\":{\"data\":{\"type\":\"tronTrail\",\"indexI\":8,\"indexJ\":0,\"value\":0,\"owner\":\"player1\",\"head\":false},\"next\":{\"data\":{\"type\":\"tronTrail\",\"indexI\":8,\"indexJ\":1,\"value\":0,\"owner\":\"player1\",\"head\":false},\"next\":{\"data\":{\"type\":\"tronTrail\",\"indexI\":8,\"indexJ\":2,\"value\":0,\"owner\":\"player1\",\"head\":false},\"next\":{\"data\":{\"type\":\"tronTrail\",\"indexI\":8,\"indexJ\":3,\"value\":0,\"owner\":\"player1\",\"head\":false},\"next\":{\"data\":{\"type\":\"tronTrail\",\"indexI\":8,\"indexJ\":4,\"value\":0,\"owner\":\"player1\",\"head\":true},\"next\":{\"data\":{\"type\":\"tronTrail\",\"indexI\":9,\"indexJ\":0,\"value\":0,\"owner\":\"player1\",\"head\":false},\"next\":null}}}}}}}}}}}}},\"empty\":false,\"size\":13}}";
		//System.out.println(inputMessage);
		ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
		OutputMessage newMessage = new OutputMessage();
		// IMPORTANT
		// without this option set adding new fields breaks old code
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		try {
			newMessage = mapper.readValue(inputMessage, OutputMessage.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//System.out.println(e.getMessage());
			//e.printStackTrace();
		}
		newMessage.getId();
		return newMessage.getItemList();

	}

}
