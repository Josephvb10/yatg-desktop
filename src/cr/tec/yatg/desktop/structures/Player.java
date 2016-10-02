package cr.tec.yatg.desktop.structures;

public enum Player {
	player1(1), player2(2), player3(3), player4(4), bot(5);

	public int value;

	Player(int value) {
		this.value = value;
	}
}
