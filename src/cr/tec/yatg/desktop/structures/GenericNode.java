package Structures;

import java.io.Serializable;

public class GenericNode<T> implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5356394639328185524L;
	private T data;
	private GenericNode<T> next;
	
	public GenericNode(){
		data=null;
		next=null;
	}
	
	public GenericNode(T data) {
		super();
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public GenericNode<T> getNext() {
		return next;
	}

	public void setNext(GenericNode<T> next) {
		this.next = next;
	}
	 
	
	
}