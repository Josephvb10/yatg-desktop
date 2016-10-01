package cr.tec.yatg.desktop.services.Structures;

import java.util.Random;

//import Structures.TronTail.Player;

public class Item implements Comparable<Item>{
	private ItemType type;
	private int indexI;
	private int indexJ;
	private int value;
	private boolean isHead;
	private Player owner;
	

	
	public Item() {
		super();
	}
	public Item(ItemType type) {
		super();
		setType(type);
	}
	public Item(ItemType type,int indexI, int indexJ) {
		super();
		setType(type);
		this.setIndexI(indexI);
		this.setIndexJ(indexJ);
	}

	
	public Item(ItemType type, int indexI, int indexJ, boolean isHead, Player owner) {
		super();
		this.type = type;
		this.indexI = indexI;
		this.indexJ = indexJ;
		this.isHead = isHead;
		this.owner = owner;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public ItemType getType() {
		return type;
	}
	
	public void setType(ItemType type) {
		this.type = type;
		if (type == ItemType.fuel){
			setValue(randInt(10,100));
		}
		else if (type == ItemType.increaseTail){
			setValue(randInt(1,10));
		}
		else if (type == ItemType.shield){
			setValue(randInt(5,20));
		}
		else if(type == ItemType.turbo){
			setValue(randInt(1,10));
		}
	}
	
	
	private static int randInt(int min, int max) {
	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    return randomNum;
	}
	@Override
	public int compareTo(Item o) {
		// TODO Auto-generated method stub
		return this.type.compareTo(o.getType());
	}
	

	public int getIndexI() {
		return indexI;
	}

	public void setIndexI(int indexI) {
		this.indexI = indexI;
	}

	public int getIndexJ() {
		return indexJ;
	}

	public void setIndexJ(int indexJ) {
		this.indexJ = indexJ;
	}

	public boolean isHead() {
		return isHead;
	}

	public void setIsHead(boolean isHead) {
		this.isHead = isHead;
	}

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}
	
}
