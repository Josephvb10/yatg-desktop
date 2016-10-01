package cr.tec.yatg.desktop.services;

import cr.tec.yatg.desktop.services.Structures.*;
import cr.tec.yatg.desktop.services.Structures.Malla.LinkedMatrix;
import cr.tec.yatg.desktop.services.comms.OutputMessage;

public class testMalla {

	public static void main(String[] args) {
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
		//System.out.println("hola")
		OutputMessage mensaje = new OutputMessage(malla.getSimpleItemList(), player1);
		String jsonMens = mensaje.toJson();
		System.out.println(jsonMens);
	}

}
