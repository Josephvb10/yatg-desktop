package cr.tec.yatg.desktop.structures;

import java.util.Random;

public class Item implements Comparable<Item> {
	/**
	 * 
	 */
	private ItemType type;
	private int indexI;
	private int indexJ;
	private int value;
	private boolean first;
	private Player owner;

	public Item() {
		super();
	}

	public Item(ItemType type) {
		super();
		setType(type);
	}

	public Item(ItemType type, int indexI, int indexJ) {
		super();
		setType(type);
		this.setIndexI(indexI);
		this.setIndexJ(indexJ);
	}

	public Item(ItemType type, int indexI, int indexJ, boolean first, Player owner) {
		super();
		this.type = type;
		this.indexI = indexI;
		this.indexJ = indexJ;
		this.first = first;
		this.owner = owner;
	}

	private static int randInt(int min, int max) {
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
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
		if (type == ItemType.fuel) {
			setValue(randInt(10, 100));
		} else if (type == ItemType.increaseTail) {
			setValue(randInt(1, 10));
		} else if (type == ItemType.shield) {
			setValue(randInt(5, 20));
		} else if (type == ItemType.turbo) {
			setValue(randInt(1, 10));
		}
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

	public boolean getFirst() {
		return first;
	}

	public void setFirst(boolean first) {
		this.first = first;
	}

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}

}
