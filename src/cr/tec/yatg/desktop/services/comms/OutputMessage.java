package cr.tec.yatg.desktop.services.comms;

import cr.tec.yatg.desktop.services.JsonConverter;
import cr.tec.yatg.desktop.structures.*;

import java.util.ArrayList;

public class OutputMessage {
	private static int nextid = 0;
	/**
	 *
	 */
	private int id;
	private SimplePlayer player;
	private ArrayList<Item> itemList;
	
	

	public OutputMessage() {
		super();
	}


	public OutputMessage(SimplePlayer player, ArrayList<Item> itemList) {
		super();
		this.player = player;
		this.itemList = itemList;
	}


	public OutputMessage(Troncycle player, GenericLinkedList<Item> itemList) {
		super();
		id = getNextid();
		importPlayer(player);
		importItemList(itemList);
	}

	private static int getNextid() {
		return ++nextid;
	}

	public static void setNextid(int nextid) {
		OutputMessage.nextid = nextid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public SimplePlayer getPlayer() {
		return player;
	}

	public void setPlayer(SimplePlayer player) {
		this.player = player;
	}

	public void importPlayer(Troncycle player) {
		SimplePlayer simplePlayer = new SimplePlayer(player.getOwner(), player.getSpeed(), player.getFuel(), player.getCurrentDirection(), player.getExtraTrail(), player.getPowerUpSteps(), player.getIsDead(), player.getPowerUpActivated());
		setPlayer(simplePlayer);

	}


	public ArrayList<Item> getItemList() {
		return itemList;
	}

	public void setItemList(ArrayList<Item> itemList) {
		this.itemList = itemList;

	}

	public void importItemList(GenericLinkedList<Item> itemList) {
		GenericNode<Item> current = itemList.getHead();
		ArrayList<Item> newItemList = new ArrayList<>();
		while (current != null) {
			newItemList.add(current.getData());

			current = current.getNext();

		}
		this.itemList = newItemList;
	}

	public String toJson() {
		String messageJson = JsonConverter.objectToJson(this);
		return messageJson;
	}


}




