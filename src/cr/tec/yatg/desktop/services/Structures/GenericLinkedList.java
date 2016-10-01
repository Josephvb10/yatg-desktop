package Structures;

public class GenericLinkedList<T> {
	private GenericNode<T> head;

	public GenericLinkedList() {
		super();
	}

	public GenericNode<T> getHead() {
		return head;
	}

	
	public void setHead(GenericNode<T> head) {
		head.setNext(this.getHead());
		this.head = head;
	}
	public void add(T data) {
		GenericNode<T> newNode = new GenericNode<>(data);
		this.add(newNode);
	}
	public void add(GenericNode<T> newNode) {
		if (this.head!=null){
		this.getLast().setNext(newNode);
	}else{
		this.head=newNode;
	}
		}

	private GenericNode<T> getLast() {
		GenericNode<T> current = head;
		if (head != null) {
			while (current.getNext() != null) {
				current = current.getNext();
			}

		}
		return current;
	}

	public int getSize() {
		GenericNode<T> current = head;
		int cont = 0;
		while (current != null) {
			cont++;
			current = current.getNext();
		}
		return cont;
	}

	public T getAtPosition(int position) {
		return this.getNodeAtPosition(position).getData();
	}
	public GenericNode<T> getNodeAtPosition(int position) {
		GenericNode<T> current = head;
		GenericNode<T> result = null;
		int cont = 0;

		if (this.checkPosition(position)) {
			while (cont < position) {
				current = current.getNext();
				cont++;
			}
			result = current;
		}

		return result;
	}
	public boolean insertAtPosition(T data, int position) {
		GenericNode<T> newNode = new GenericNode<>(data);
		return this.insertAtPosition(newNode, position);
	}
	public boolean insertAtPosition(GenericNode<T> newNode, int position) {
		GenericNode<T> current = head;
		int cont = 0;
		boolean result = false;
		if (this.checkPosition(position)) {
			if (position == 0) {
				this.insertAtBeggining(newNode);
				result = true;
			} else {
				while (cont < position) {
					current = current.getNext();
					cont++;
				}
				newNode.setNext(current.getNext());
				current.setNext(newNode);
				result = true;
			}
		}
		return result;
	}

	public T deleteAtPosition(int position) {
		GenericNode<T> current = head;
		T result = null;
		if (this.checkPosition(position)) {
			if (position == 0) {
				result = head.getData();
				head = head.getNext();

			} else if (position == this.getSize() - 1) {
				result = deleteLast();
			}

			else {
				current = this.getNodeAtPosition(position - 1);
				result = current.getNext().getData();
				current.setNext(current.getNext().getNext());
			}

			
		}
		return result;
	}
	public T deleteLast() {
		GenericNode<T> current = head;
		GenericNode<T> prev = head;
		T result = null;
		if(current.getNext()==null){
			result = current.getData();
			head=null;

		}
		else{
			while(current.getNext()!=null){
				prev=current;
				current=current.getNext();
				result = current.getData();
			}
			prev.setNext(null);
			
		}
		return result;
	}

	private boolean checkPosition(int position) {
		return position >= 0 && position < this.getSize();
	}
	public void insertAtBeggining(T data) {
		GenericNode<T> newNode = new GenericNode<>(data);
		this.insertAtBeggining(newNode);
	}
	public void insertAtBeggining(GenericNode<T> newNode) {
		newNode.setNext(this.head);
		this.head = newNode;
	}
	public boolean isEmpty(){
		return head==null;
		
	}

	

}
