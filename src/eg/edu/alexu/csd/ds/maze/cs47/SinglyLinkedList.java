package eg.edu.alexu.csd.ds.maze.cs47;

import eg.edu.alexu.csd.ds.maze.MyLinkedList;

public class SinglyLinkedList implements MyLinkedList {

	private SNode head;
	private int listSize;
	
	public SinglyLinkedList() {
		head = new SNode(null);
		listSize = 0;
	}
	
	@Override
	public void add(int index, Object element) {
		if (index <= 0 || index > size()) {
			throw new RuntimeException();
		}
		
		SNode tempNode = new SNode(element);
		SNode currentNode = head;
		
		for (int i = 1; i < index && currentNode.getNext() != null; i++) {
			currentNode = currentNode.getNext();
		}
		
		tempNode.setNext(currentNode.getNext());
		currentNode.setNext(tempNode);
		listSize++;
	}
	
	@Override
	public void add(Object element) {
		SNode tempNode = new SNode(element);
		SNode currentNode = head;
		
		while (currentNode.getNext() != null) {
			currentNode = currentNode.getNext();
		}
		
		tempNode.setNext(null);
		currentNode.setNext(tempNode);
		listSize++;
	}
	
	@Override
	public Object get(int index) {
		if (index <= 0 || index > size()) {
			return null;
		}
		
		SNode currentNode = head.getNext();
		
		for (int i = 1; i < index; i++) {
			if (currentNode.getNext() == null) {
				return null;
			}
			
			currentNode = currentNode.getNext();
		}
		
		return currentNode.getData();
	}
	
	@Override
	public void set(int index, Object element) {
		if (index <= 0 || index > size()) {
			throw new RuntimeException();
		}
		
		SNode tempNode = new SNode(element);
		SNode currentNode = head;
		
		for (int i = 1; i < index && currentNode.getNext() != null; i++) {
			currentNode = currentNode.getNext();
		}
		
		SNode replacedNode = currentNode.getNext();
		tempNode.setNext(replacedNode.getNext());
		currentNode.setNext(tempNode);
		replacedNode.setNext(null);
	}
	
	@Override
	public void clear() {
		head.setNext(null);
		head.setData(null);
		listSize = 0;
	}
	
	@Override
	public boolean isEmpty() {
		SNode currentNode = head;
		if (currentNode.getNext() == null) {
			return true;
		}
		return false;
	}
	
	@Override
	public void remove(int index) {
		if (index <= 0 || index > size()) {
			throw new RuntimeException();
		}
		
		SNode currentNode = head;
		for (int i = 1; i < index; i++) {
			if (currentNode.getNext() == null) {
				throw new RuntimeException();
			}
			currentNode = currentNode.getNext();
		}
		
		currentNode.setNext(currentNode.getNext().getNext());
		listSize--;
	}
	
	@Override
	public int size() {
		return listSize;
	}
	
	@Override
	public MyLinkedList sublist(int fromIndex, int toIndex) {
		if (fromIndex <= 0 || fromIndex > size() || toIndex <= 0 
							|| toIndex > size() || toIndex < fromIndex) {
			throw new RuntimeException();
		}
		
		SNode currentNode = head.getNext();
		MyLinkedList newList = new SinglyLinkedList();
		
		for (int i = 1; i <= toIndex; i++) {
			if (i >= fromIndex) {
				newList.add(currentNode.getData());
			}
			currentNode = currentNode.getNext();
		}
		return newList;
	}
	
	@Override
	public boolean contains(Object o) {
		SNode currentNode = head;
		while (currentNode.getNext() != null) {
			if (currentNode.getNext().getData() == o) {
				return true;
			}
			currentNode = currentNode.getNext();
		}
		return false;
	}
	
	private class SNode {
		Object data;
		SNode next;
		
		public SNode(Object newData){
			data = newData;
			next = null;
		}
		
		public Object getData() {
			return data;
		}
		
		public SNode getNext() {
			return next;
		}
		
		public void setData(Object newData) {
			data = newData;
		}
		
		public void setNext(SNode newNode) {
			next = newNode;
		}
	}

}
