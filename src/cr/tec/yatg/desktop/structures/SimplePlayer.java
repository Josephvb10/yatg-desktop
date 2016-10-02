package cr.tec.yatg.desktop.structures;

public class SimplePlayer {
	private Player owner;
	private int speed;
	private double fuel;
	private Direction currentDirection;
	private int extraTrail, powerUpSteps;
	private boolean isDead, powerUpActivated;
	
	
	public SimplePlayer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SimplePlayer(Player owner, int speed, double fuel, Direction currentDirection, int extraTrail,
			int powerUpSteps, boolean isDead, boolean powerUpActivated) {
		super();
		this.owner = owner;
		this.speed = speed;
		this.fuel = fuel;
		this.currentDirection = currentDirection;
		this.extraTrail = extraTrail;
		this.powerUpSteps = powerUpSteps;
		this.isDead = isDead;
		this.powerUpActivated = powerUpActivated;
	}
	public Player getOwner() {
		return owner;
	}
	public void setOwner(Player owner) {
		this.owner = owner;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public double getFuel() {
		return fuel;
	}
	public void setFuel(double fuel) {
		this.fuel = fuel;
	}
	public Direction getCurrentDirection() {
		return currentDirection;
	}
	public void setCurrentDirection(Direction currentDirection) {
		this.currentDirection = currentDirection;
	}
	public int getExtraTrail() {
		return extraTrail;
	}
	public void setExtraTrail(int extraTrail) {
		this.extraTrail = extraTrail;
	}
	public int getPowerUpSteps() {
		return powerUpSteps;
	}
	public void setPowerUpSteps(int powerUpSteps) {
		this.powerUpSteps = powerUpSteps;
	}
	public boolean isDead() {
		return isDead;
	}
	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}
	public boolean isPowerUpActivated() {
		return powerUpActivated;
	}
	public void setPowerUpActivated(boolean powerUpActivated) {
		this.powerUpActivated = powerUpActivated;
	}


}
