package eg.edu.alexu.csd.ds.maze.cs47;

import eg.edu.alexu.csd.ds.maze.cs47.IMazeSolver;
import eg.edu.alexu.csd.ds.maze.MyStack;


public class DFS implements IMazeSolver {

	private MyStack stack = new Stack();
	
	@Override
	public void add(Object element) {
		stack.push(element);
	}

	@Override
	public Object remove() {
		return stack.pop();
	}

	@Override
	public boolean isEmpty() {
		return stack.isEmpty();
	}

}
