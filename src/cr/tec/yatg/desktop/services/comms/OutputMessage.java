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
	private ArrayList<Item> itemList, powerupsList;

	public OutputMessage() {
		super();
	}

	public OutputMessage(SimplePlayer player, ArrayList<Item> itemList, ArrayList<Item> powerupsList) {
		super();
		this.player = player;
		this.itemList = itemList;
		this.powerupsList = powerupsList;
	}

	public OutputMessage(Troncycle player, GenericLinkedList<Item> itemList) {
		super();
		id = getNextid();
		importPlayer(player);
		importItemList(itemList);
		importPowerupsList(player.getPowerUpStack());
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



	public ArrayList<Item> getPowerupsList() {
		return powerupsList;
	}

	public void setPowerupsList(ArrayList<Item> powerupsList) {
		this.powerupsList = powerupsList;
	}

	public void importPlayer(Troncycle player) {
		SimplePlayer simplePlayer = new SimplePlayer(player.getOwner(), player.getSpeed(), player.getFuel(),
				player.getCurrentDirection(), player.getExtraTrail(), player.getPowerUpSteps(), player.getIsDead(),
				player.getPowerUpActivated());
		importItemsPriorityQueue(player.getItemsQueue());
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

	public void importPowerupsList(GenericStack<Item> genericStack) {
		GenericNode<Item> current = genericStack.getHead();
		ArrayList<Item> newPowerupsList = new ArrayList<>();
		while (current != null) {
			newPowerupsList.add(current.getData());
			current = current.getNext();
		}
		this.powerupsList = newPowerupsList;
	}

	public void importItemsPriorityQueue(ItemsPriorityQueue itemsPriorityQueue) {
		GenericNode<Item> current = itemsPriorityQueue.getHead();
		ArrayList<Item> newItemsPriorityQueue = new ArrayList<>();
		while (current != null) {
			newItemsPriorityQueue.add(current.getData());

			current = current.getNext();

		}
		this.itemList = newItemsPriorityQueue;
	}

	public String toJson() {
		String messageJson = JsonConverter.objectToJson(this);
		return messageJson;
	}

}
