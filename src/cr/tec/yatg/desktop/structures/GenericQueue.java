package cr.tec.yatg.desktop.structures;

public class GenericQueue<T> extends GenericLinkedList<T> {
	
	public GenericQueue() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void enqueue(T data){
		this.add(data);
	}
	public T dequeue(){
		T currentData = null;

		if(!this.isEmpty()){
			currentData = this.getHead().getData();
			this.deleteAtPosition(0);
		}
		return currentData;
	}
}
