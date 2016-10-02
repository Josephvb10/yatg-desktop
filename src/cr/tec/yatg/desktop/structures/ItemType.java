package cr.tec.yatg.desktop.structures;

public enum ItemType {
	bomb(1), fuel(2), increaseTail(3), shield(4), turbo(5), tronTrail(6);
	private int value;

	ItemType(int value) {
		this.value = value;

	}

}
