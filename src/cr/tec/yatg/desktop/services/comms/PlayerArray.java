package cr.tec.yatg.desktop.services.comms;

import java.io.PrintWriter;

/**
 * Created by joseph on 10/2/16.
 */
public class PlayerArray {
	private int size = 0;
	private PlayerArrayNodo head;

	public PlayerArray() {
		this.head = new PlayerArrayNodo();
		this.head.setIndexNumber(1);

		PlayerArrayNodo actual = head;

		for (int i = 2; i <= 4; i++) {
			actual.setNext(new PlayerArrayNodo());
			actual = actual.getNext();
			actual.setIndexNumber(i);
		}
	}

	public PlayerArrayNodo get(int i) {
		PlayerArrayNodo actual = this.head;
		while (actual != null) {
			if (actual.getIndexNumber() == i) {
				return actual;
			}
			actual = actual.getNext();
		}
		return null;
	}

	public PlayerArrayNodo get(String name) {
		PlayerArrayNodo actual = this.head;
		while (actual != null) {
			if (actual.getName() != null && actual.getName().equals(name)) {
				return actual;
			}

			actual = actual.getNext();
		}

		return null;
	}


	public void remove(int i) {
		get(i).anulate();
		this.size--;
	}

	public void remove(String name) {
		get(name).anulate();
		this.size--;
	}

	public int insertAvailable(String name, PrintWriter out) {
		PlayerArrayNodo actual = this.head;
		while (actual != null) {
			if (actual.getName() == null) {
				actual.setName(name);
				actual.setOut(out);
				this.size++;
				return actual.getIndexNumber();
			}

			actual = actual.getNext();
		}

		return -1;
	}

	public int getSize() {
		return size;
	}

	public void sendAll(String msg) {
		PlayerArrayNodo actual = this.head;
		while (actual != null) {
			if (actual.getOut() != null) {
				actual.getOut().println(msg);
				actual.getOut().flush();
			}
			actual = actual.getNext();
		}
	}

	public void sendTo(int i, String msg) {
		PrintWriter actual = get(i).getOut();
		actual.println(msg);
		actual.flush();

	}

	public void sendTo(String name, String msg) {
		PrintWriter actual = get(name).getOut();
		actual.println(msg);
		actual.flush();
	}

	public boolean contains(String name) {
		return get(name) != null;
	}

	public boolean contains(int i) {
		return get(i) != null;
	}
}

