package eg.edu.alexu.csd.ds.maze.cs47;

import java.util.EmptyStackException;

import eg.edu.alexu.csd.ds.maze.MyLinkedList;
import eg.edu.alexu.csd.ds.maze.MyStack;

public class Stack implements MyStack {

	private MyLinkedList list = new SinglyLinkedList();
	
	@Override
	public void add(int index, Object element) {
		
		if (index <= 0 || index > size()+1) {
			throw new RuntimeException();
		}
		else if (index-1 == size()) {
			push(element);
		}
		else {
			list.add(list.size()-index+2 , element);
		}
	}

	@Override
	public Object pop() {
		
		if (list.isEmpty()) {
			throw new EmptyStackException();
		}
		Object pop = new Object();
		pop = list.get(1);
		list.remove(1);
		return pop;
	}

	@Override
	public Object peek() {
		
		if (list.isEmpty()) {
			throw new EmptyStackException();
		}
		return list.get(1);
	}

	@Override
	public void push(Object element) {
		if (list.size() == 0) {
			list.add(element);
		}
		else {
			list.add(1, element);
		}
	}

	@Override
	public boolean isEmpty() {
		
		return list.isEmpty();
	}

	@Override
	public int size() {
		
		return list.size();
	}

}
