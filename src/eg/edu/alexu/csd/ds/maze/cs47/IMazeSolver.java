package eg.edu.alexu.csd.ds.maze.cs47;

public interface IMazeSolver {

	/*
	 * In case of Queue : Enqueue Element
	 * In case of Stack : Push Element
	 */
	public void add(Object element) ;
	
	/*
	 * In case of Queue : Dequeue Element
	 * In case of Stack : Pop Element
	 */
	public Object remove() ;
	
	/*
	 * In case of Queue and Stack return if is empty of not
	 */
	public boolean isEmpty();
}
