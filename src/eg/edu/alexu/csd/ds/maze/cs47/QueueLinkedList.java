package eg.edu.alexu.csd.ds.maze.cs47;

import eg.edu.alexu.csd.ds.maze.MyLinkedList;
import eg.edu.alexu.csd.ds.maze.MyQueue;

import java.util.NoSuchElementException;

public class QueueLinkedList implements MyQueue {
	
	MyLinkedList queue = new DoublyLinkedList();
	
	public void enqueue(Object item) {
		if (item == null) {
			throw new RuntimeException();
		}
		queue.add(item);
	}
	
	public Object dequeue() {
		if (queue.isEmpty()) {
			throw new NoSuchElementException();
		}
		Object dequeue = new Object();
		dequeue = queue.get(1);
		queue.remove(1);
		return dequeue;
	}
	
	public boolean isEmpty() {
		return queue.isEmpty();
	}
	
	public int size() {
		return queue.size();
	}
}
