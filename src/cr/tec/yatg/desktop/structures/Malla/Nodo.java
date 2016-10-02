package cr.tec.yatg.desktop.services.Structures.Malla;


import cr.tec.yatg.desktop.services.Structures.Item;

public class Nodo {
	private Nodo up, down, left, right, next;
	private int indexI, indexJ;
	private Item item;
	
	
	public Nodo(){
		this.next = null;
		this.up = null;
		this.down = null;
		this.left = null;
		this.right = null;	
		this.indexI = 0;
		this.indexJ = 0;
		this.item=null;
	}

	
	public Nodo getNext(){
		return next;
	}
	
	public void setNext(Nodo nodo){
		this.next = nodo;
	}
	
	public Nodo getUp() {
		return up;
	}

	public void setUp(Nodo up) {
		this.up = up;
	}

	public Nodo getDown() {
		return down;
	}

	public void setDown(Nodo down) {
		this.down = down;
	}

	public Nodo getLeft() {
		return left;
	}

	public void setLeft(Nodo left) {
		this.left = left;
	}

	public Nodo getRight() {
		return right;
	}

	public void setRight(Nodo right) {
		this.right = right;
	}
	
	public void setIndex(int i, int j){
		this.indexI = i;
		this.indexJ = j;
	}
	
	public void getIndex(){ System.out.println( "[" + this.indexI + " , " + this.indexJ + "]");

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


	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	
}
	
	
	


