package cr.tec.yatg.desktop.services.Structures;

public class Stack {
	private SimpleNodo head;
	
	public Stack(){
		this.head = null;
	}
	
	public void push(SimpleNodo nodo){
		nodo = new SimpleNodo("Empty");
		if(getHead() == null){
			setHead(nodo);
		}
		else{
			nodo.setNext(getHead());
			setHead(nodo);
		}
	}
	
	
	public SimpleNodo pop(){
		if (getHead() != null){
			this.head = getHead().getNext();
		}
		return head;
	}

	
	public SimpleNodo getHead() {
		return head;
	}

	public void setHead(SimpleNodo head) {
		this.head = head;
	}

}
