package Comunication;
import Structures.*;

public class OutputMessage {
	private int id;
	private static int nextid = 0;
	private Troncycle player;
	private GenericLinkedList<Item> itemList;
	
	

	public OutputMessage() {
		super();
	}

	public OutputMessage(GenericLinkedList<Item> itemList, Troncycle player) {
		super();
		this.id = getNextid();
		this.player = player;
		this.itemList = itemList;
	}
	


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private static int getNextid() {
		return ++nextid;
	}

	public static void setNextid(int nextid) {
		OutputMessage.nextid = nextid;
	}

	public Troncycle getPlayer() {
		return player;
	}

	public void setPlayer(Troncycle player) {
		this.player = player;
	}

	public GenericLinkedList<Item> getItemList() {
		return itemList;
	}

	public void setItemList(GenericLinkedList<Item> itemList) {
		this.itemList = itemList;
	}

	public String toJson() {
		String messageJson = JsonConverter.objectToJson(this);
		return messageJson;
	}

}




