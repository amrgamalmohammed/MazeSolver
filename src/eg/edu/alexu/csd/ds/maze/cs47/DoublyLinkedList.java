package eg.edu.alexu.csd.ds.maze.cs47;

import eg.edu.alexu.csd.ds.maze.MyLinkedList;

public class DoublyLinkedList implements MyLinkedList {

	private DNode head;
	private DNode tail;
	private int listSize;
	
	public DoublyLinkedList() {
		head = new DNode(null);
		tail = new DNode(null);
		head.next = tail;
		tail.pre = head;
		listSize = 0;
	}
	
	public void add(int index, Object element) {
		if (index <= 0 || index > size()) {
			throw new RuntimeException();
		}
		
		DNode tempNode = new DNode(element);
		DNode currentNode = head;
		
		for (int i = 1; i < index && currentNode.getNext() != null; i++) {
			currentNode = currentNode.getNext();
		}
		
		tempNode.setNext(currentNode.getNext());
		tempNode.setPre(currentNode);
		currentNode.setNext(tempNode);
		currentNode.getNext().setPre(tempNode);
		listSize++;
	}
	
	public void add(Object element) {
		DNode tempNode = new DNode(element);
		DNode currentNode = tail.getPre();
		tempNode.setNext(tail);
		tempNode.setPre(currentNode);
		currentNode.setNext(tempNode);
		tail.setPre(tempNode);
		listSize++;
	}
	
	public Object get(int index) {
		if (index <= 0 || index > size()) {
			return null;
		}
		
		DNode currentNode = head.getNext();
		
		for (int i = 1; i < index; i++) {
			if (currentNode.getNext() == null) {
				return null;
			}
			
			currentNode = currentNode.getNext();
		}
		
		return currentNode.getData();
	}
	
	public void set(int index, Object element) {
		if (index <= 0 || index > size()) {
			throw new RuntimeException();
		}
		
		DNode tempNode = new DNode(element);
		DNode currentNode = head;
		
		for (int i = 1; i < index && currentNode.getNext() != null; i++) {
			currentNode = currentNode.getNext();
		}
		
		DNode replacedNode = currentNode.getNext();
		tempNode.setNext(replacedNode.getNext());
		tempNode.setPre(currentNode);
		currentNode.setNext(tempNode);
		replacedNode.getNext().setPre(tempNode);
		replacedNode.setNext(null);
		replacedNode.setPre(null);
		
	}

	public void clear() {
		head.setData(null);
		head.setPre(null);
		head.setNext(tail);
		tail.setData(null);
		tail.setNext(null);
		tail.setPre(head);
		listSize = 0;
		
	}

	public boolean isEmpty() {
		DNode currentNode = head;
		if (currentNode.getNext() == tail) {
			return true;
		}
		return false;
	}

	public void remove(int index) {
		if (index <= 0 || index > size()) {
			throw new RuntimeException();
		}
		
		DNode currentNode = head;
		for (int i = 1; i < index; i++) {
			if (currentNode.getNext() == null) {
				throw new RuntimeException();
			}
			currentNode = currentNode.getNext();
		}
		
		DNode removedNode = currentNode.getNext();
		currentNode.setNext(removedNode.getNext());
		removedNode.getNext().setPre(currentNode);
		removedNode.setNext(null);
		removedNode.setPre(null);
		listSize--;
		
	}
	
	public int size () {
		return listSize;
	}
	
	public MyLinkedList sublist(int fromIndex, int toIndex) {
		if (fromIndex <= 0 || fromIndex > size() || toIndex <= 0 
						|| toIndex > size() || toIndex < fromIndex) {
		throw new RuntimeException();
		}
		
		DNode currentNode = head.getNext();
		MyLinkedList newList = new DoublyLinkedList();
		
		for (int i = 1; i <= toIndex; i++) {
		if (i >= fromIndex) {
			newList.add(currentNode.getData());
		}
		currentNode = currentNode.getNext();
		}
		return newList;
	}

	public boolean contains(Object o) {
		DNode currentNode = head;
		while (currentNode.getNext() != tail) {
			if (currentNode.getNext().getData() == o) {
				return true;
			}
			currentNode = currentNode.getNext();
		}
		return false;
	}
	
	private class DNode {
		Object data;
		DNode next;
		DNode pre;
		
		public DNode (Object newData) {
			data = newData;
			next = null;
			pre = null;
		}
		
		public Object getData() {
			return data;
		}
		
		public DNode getNext() {
			return next;
		}
		
		public DNode getPre() {
			return pre;
		}
		
		public void setData(Object newData) {
			data = newData;
		}
		
		public void setNext(DNode newNode) {
			next = newNode;
		}
		
		public void setPre(DNode newNode) {
			pre = newNode;
		}
	}

}
