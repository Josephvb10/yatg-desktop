package Structures;

public enum ItemType {
	bomb(1), fuel(2), increaseTail(3), shield(4), turbo(5), tronTrail(6);
	private int value;

	private ItemType(int value) {
		this.value = value;

	}

}
