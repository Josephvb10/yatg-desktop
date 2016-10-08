package cr.tec.yatg.desktop.structures;

/**
 * Generic stack.
 *
 * @param <T> Type of the elements to be contained.
 * @author gsegura96
 */
public class GenericStack<T> {

	private GenericNode<T> head;

	/**
	 * Constructs an empty stack.
	 */
	public GenericStack() {
		this.head = null;
	}

	/**
	 * Constructs a stack containing data as the first element.
	 *
	 * @param data First element of the list to be created.
	 */
	public GenericStack(T data) {
		GenericNode<T> newNode = new GenericNode<>(data);
		this.head = newNode;
	}

	/**
	 * Inserts an element at the first position of the stack.
	 *
	 * @param data Element to be inserted.
	 */
	public void push(T data) {
		GenericNode<T> newNode = new GenericNode<>(data);
		push(newNode);
	}

	/**
	 * Inserts a node at the beginning if the stack.
	 *
	 * @param newNode Node to be inserted.
	 */
	public void push(GenericNode<T> newNode) {
		if (getHead() == null) {
			setHead(newNode);
		} else {
			newNode.setNext(getHead());
			setHead(newNode);
		}
	}

	/**
	 * Deletes and returns the first element of the stack.
	 *
	 * @return The first element of the stack.
	 */
	public T pop() {
		T result = null;
		if (getHead() != null) {
			result = head.getData();
			this.head = getHead().getNext();
		}
		return result;
	}

	/**
	 * Returns the first node of the stack.
	 *
	 * @return The first node of the stack
	 */
	public GenericNode<T> getHead() {
		return head;
	}

	/**
	 * Sets the stack head, unlinked to the previous head.
	 *
	 * @param head Node to be set as the new head.
	 */
	public void setHead(GenericNode<T> head) {
		this.head = head;
	}

	/**
	 * Checks if the stack is empty, if it is returns true, else returns false.
	 *
	 * @return true if the stack is empty, else returns false.
	 */
	public boolean isEmpty() {
		return head == null;
	}

	/**
	 * Adds an element at the end of the stack.
	 *
	 * @param data Element to be added.
	 */
	public void addLast(T data) {
		if (this.head != null) {
			GenericNode<T> temp = this.head;
			while (temp.getNext() != null) {
				temp = temp.getNext();
			}
			GenericNode<T> newNodo = new GenericNode<T>(data);
			temp.setNext(newNodo);
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String result = "(";
		GenericNode<T> current = this.getHead();
		while (current != null) {
			result += current.getData().toString() + ", ";
			current = current.getNext();

		}
		result += ")";
		return result;
	}

}
