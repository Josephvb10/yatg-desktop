package cr.tec.yatg.desktop.structures;

import java.util.Random;


public class Troncycle {
	/**
	 *
	 */
	private Player owner;
	private int speed;
	private double fuel;
	private Direction currentDirection;
	private int extraTrail, powerUpSteps;
	private GenericLinkedList<Item> trail;
	private ItemsPriorityQueue itemsQueue = new ItemsPriorityQueue();
	private boolean isDead, powerUpActivated;


	public Troncycle() {
		super();
	}


	public Troncycle(Player owner, int indexI, int indexJ) {
		this.isDead = false;
		this.powerUpActivated = false;
		this.owner = owner;
		this.fuel = 100;
		this.speed = generateSpeed();
		this.trail = new GenericLinkedList<>();
		this.extraTrail = 2;
		this.powerUpSteps = 0;
		this.addHead(indexI, indexJ);

	}

	public int getPowerUpSteps() {
		return this.powerUpSteps;
	}

	public void setPowerUpSteps(int value) {
		this.powerUpSteps = value;
	}

	public boolean getPowerUpActivated() {
		return this.powerUpActivated;
	}

	public void setPowerUpActivated(boolean value) {
		this.powerUpActivated = value;
	}

	public boolean getIsDead() {
		return this.isDead;
	}

	public void setIsDead(boolean value) {
		this.isDead = value;
	}


	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}

	public double getFuel() {
		return fuel;
	}

	public void setFuel(double fuel) {
		this.fuel = fuel;
	}

	public void addFuel(int fuel) {
		if ((this.fuel + fuel) > 100) {
			this.fuel = 100;
		} else {
			this.fuel += fuel;
		}
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int generateSpeed() {
		Random rand = new Random();
		int newSpeed = rand.nextInt(9) + 1;
		return newSpeed;
	}

	public Direction getCurrentDirection() {
		return currentDirection;
	}

	public void setCurrentDirection(Direction currentDirection) {
		this.currentDirection = currentDirection;
	}

	public GenericLinkedList<Item> getTrail() {
		return trail;
	}

	public void setTrail(GenericLinkedList<Item> trail) {
		this.trail = trail;
	}

	public int getExtraTrail() {
		return extraTrail;
	}

	public void setExtraTrail(int extraTrail) {
		this.extraTrail = extraTrail;
	}

	public void addExtraTrail(int extraTrail) {
		this.extraTrail += extraTrail;
	}
/*
	public GenericNode<Item> getHead() {
		return trail.getHead();
	}*/

	public Item deleteTail() {
		Item deleted = null;

		if (getExtraTrail() > 0) {
			addExtraTrail(-1);
		} else {
			deleted = trail.deleteLast();
		}

		return deleted;
	}

	public void addHead(int indexI, int indexJ) {
		Item newItem = new Item(ItemType.tronTrail, indexI, indexJ, true, this.owner);
		addHead(newItem);
	}

	public void addHead(Item item) {
		GenericNode<Item> newHead = new GenericNode<>(item);
		if (!trail.isEmpty()) {
			trail.getHead().getData().setFirst(false);
		}
		trail.setHead(newHead);
	}

	public void addItem(Item newItem) {
		itemsQueue.add(newItem);
	}

	public void useItem() {
		if (!itemsQueue.isEmpty()) {
			Item itemToUse = itemsQueue.poll();
			switch (itemToUse.getType()) {
				case bomb:

					break;
				case fuel:
					this.addFuel(itemToUse.getValue());

					break;
				case increaseTail:
					this.addExtraTrail(itemToUse.getValue());

					break;
				case shield:

					break;
				case turbo:

					break;

				default:
					break;
			}
		}

	}

}
