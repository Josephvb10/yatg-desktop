package cr.tec.yatg.desktop.services.comms;

import java.io.PrintWriter;

/**
 * Created by joseph on 10/2/16.
 */
public class PlayerArrayNodo {
	private PlayerArrayNodo next = null;
	private int indexNumber;
	private PrintWriter out = null;
	private String name = null;

	public int getIndexNumber() {
		return indexNumber;
	}

	public void setIndexNumber(int indexNumber) {
		this.indexNumber = indexNumber;
	}

	public PrintWriter getOut() {
		return out;
	}

	public void setOut(PrintWriter out) {
		this.out = out;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PlayerArrayNodo getNext() {

		return next;
	}

	public void setNext(PlayerArrayNodo next) {
		this.next = next;
	}

	public void anulate() {
		this.out = null;
		this.name = null;
	}

}
