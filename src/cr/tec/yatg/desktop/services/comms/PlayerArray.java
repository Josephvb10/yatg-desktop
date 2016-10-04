package cr.tec.yatg.desktop.services.comms;

import java.io.PrintWriter;

/**
 * Created by joseph on 10/2/16.
 */
public class PlayerArray {
	private final PlayerArrayNodo head;
	private int size = 0;

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
		PlayerArrayNodo toRemove = get(i);
		if (toRemove != null) {
			toRemove.anulate();
			this.size--;
		}
	}

	public void remove(String name) {
		PlayerArrayNodo toRemove = get(name);
		if (toRemove != null) {
			toRemove.anulate();
			this.size--;
		}
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
		PlayerArrayNodo actual = get(i);
		if (actual != null) {
			PrintWriter client = actual.getOut();
			client.println(msg);
			client.flush();
		}
	}

	public void sendTo(String name, String msg) {
		PlayerArrayNodo actual = get(name);
		if (actual != null) {
			PrintWriter client = actual.getOut();
			client.println(msg);
			client.flush();
		}
	}

	public boolean contains(String name) {
		return get(name) != null;
	}

	public boolean contains(int i) {
		return get(i) != null;
	}
}

