package co.edu.unbosque.model;

public class MyDoubleLinkedList<E> {

	protected DNode<E> head;
	protected DNode<E> currentPosition;

	public MyDoubleLinkedList() {
		// TODO Auto-generated constructor stub
	}

	public DNode<E> getHead() {
		return head;
	}

	public void setHead(DNode<E> head) {
		this.head = head;
	}

	public DNode<E> getCurrentPosition() {
		return currentPosition;
	}

	public void setCurrentPosition(DNode<E> currentPosition) {
		this.currentPosition = currentPosition;
	}

	public boolean isEmpty() {
		return (head == null) ? true : false;
	}

	public void forward(int... numPositions) {
		if (numPositions[0] > 0 && head != null) {
			int positionsForward = numPositions[0];

			if (currentPosition == null) {
				currentPosition = head;
				positionsForward--;
			}
			while (currentPosition.getNext() != null && positionsForward > 0) {
				currentPosition = currentPosition.getNext();
				positionsForward--;

			}
		}
	}

	public void insert(E data) {

		DNode<E> newNode = new DNode<E>(data);

		if (currentPosition == null) {
			newNode.setNext(head);

			if (head != null) {
				head.setPrev(newNode);
			}

			head = newNode;
		} else {
			newNode.setNext(currentPosition.getNext());
			newNode.setPrev(currentPosition);

			if (currentPosition.getNext() != null) {
				currentPosition.getNext().setPrev(newNode);
			}
			currentPosition.setNext(newNode);
		}
		currentPosition = newNode;

	}

	public E extract() {
		E info = null;

		if (currentPosition != null) {
			info = currentPosition.getInfo();

			if (head == currentPosition) {
				head = currentPosition.getNext();
			} else {
				currentPosition.getPrev().setNext(currentPosition.getNext());
			}

			if (currentPosition.getNext() != null) {
				currentPosition.getNext().setPrev(currentPosition.getPrev());
			}

			currentPosition = currentPosition.getNext();
		}
		return info;

	}

	public void backward(int... numPosition) {

		if (numPosition[0] <= 0 || head == null || currentPosition == null) {
			return;
		}

		int backwardPosition = numPosition[0];

		while (currentPosition != null && backwardPosition > 0) {

			currentPosition = currentPosition.getPrev();
			backwardPosition--;

		}

	}

	public void remove(int i) {
		int index = 0;

		if (i > size() || head == null || i < 0) {
			return;
		}
		currentPosition = head;
		if (!this.isEmpty()) {
			while (index < i) {
				index++;
				currentPosition = currentPosition.getNext();
			}

			if (currentPosition.getNext() != null) {
				currentPosition.getPrev().setNext(currentPosition.getNext());
				currentPosition.getNext().setPrev(currentPosition.getPrev());
			} else {
				currentPosition.getPrev().setNext(null);
			}
		}
	}
	public E get(int i) {
		int index = 0;
		E info= null;
		
		if (i > size() || head == null || i < 0) {
			return info;
		}
		
		currentPosition = head;
		if (!this.isEmpty()) {
			while (index < i) {
				index++;
				currentPosition = currentPosition.getNext();
			}
		}
		info = currentPosition.getInfo();
		return info;
	}

	public int indexOf(E info) {
		int index = -1;
		DNode<E> temp = head;
		if (!this.isEmpty()) {
			index = 0;
			while (!(temp.getInfo().equals(info))) {
				index++;
				temp = temp.getNext();
			}
		}
		return index;
	}

	public int size() {
		int size = 0;
		DNode<E> temp = head;
		while (temp != null) {
			size++;
			temp = temp.getNext();
		}
		return size;
	}

	@Override
	public String toString() {

		DNode<E> temp = head;

		StringBuilder sb = new StringBuilder();

		while (temp != null) {
			sb.append(temp.getInfo());

			if (temp.getNext() != null) {
				sb.append(" <-> ");
			}
			temp = temp.getNext();
		}

		return sb.toString();
	}

}
