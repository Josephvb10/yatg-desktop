package cr.tec.yatg.desktop.structures;

public class GenericStack<T> {

		private GenericNode<T> head;
		
		public GenericStack(){
			this.head = null;
		}
		public GenericStack(T data){
			GenericNode<T> newNode = new GenericNode<>(data);
			this.head = newNode;
		}
		public void push(T data){
			GenericNode<T> newNode = new GenericNode<>(data);
			push(newNode);
		}
		
		public void push(GenericNode<T>  newNode){
			if(getHead() == null){
				setHead(newNode);
			}
			else{
				newNode.setNext(getHead());
				setHead(newNode);
			}
		}
		
		
		public T pop(){
			if (getHead() != null){
				this.head = getHead().getNext();
			}
			return head.getData();
		}

		
		public GenericNode<T> getHead() {
			return head;
		}

		public void setHead(GenericNode<T> head) {
			this.head = head;
		}
		

	}

