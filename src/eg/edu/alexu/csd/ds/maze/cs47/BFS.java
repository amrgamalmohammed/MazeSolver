package eg.edu.alexu.csd.ds.maze.cs47;

import eg.edu.alexu.csd.ds.maze.cs47.IMazeSolver;
import eg.edu.alexu.csd.ds.maze.MyQueue;

public class BFS implements IMazeSolver {

	private MyQueue queue = new QueueLinkedList();
	
	@Override
	public void add(Object element) {
		queue.enqueue(element);
	}

	@Override
	public Object remove() {
		return queue.dequeue();
	}

	@Override
	public boolean isEmpty() {
		return queue.isEmpty();
	}

}
