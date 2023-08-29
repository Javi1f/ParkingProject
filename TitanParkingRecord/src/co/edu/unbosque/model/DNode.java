package co.edu.unbosque.model;

import java.io.Serializable;

public class DNode<E> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3689095504331499914L;
	private DNode<E> next;
	private E info;
	private DNode<E> prev;

	public DNode() {
		// TODO Auto-generated constructor stub
	}

	public DNode(E info) {
		this(null, info, null);

	}

	public DNode(DNode<E> next, E info, DNode<E> prev) {
		super();
		this.next = next;
		this.info = info;
		this.prev = prev;
	}

	public DNode<E> getNext() {
		return next;
	}

	public void setNext(DNode<E> next) {
		this.next = next;
	}

	public E getInfo() {
		return info;
	}

	public void setInfo(E info) {
		this.info = info;
	}

	public DNode<E> getPrev() {
		return prev;
	}

	public void setPrev(DNode<E> prev) {
		this.prev = prev;
	}

	@Override
	public String toString() {
		return "DNode [next=" + next + ", info=" + info + ", prev=" + prev + "]";
	}
}
