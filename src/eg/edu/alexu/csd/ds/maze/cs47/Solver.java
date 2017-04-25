package eg.edu.alexu.csd.ds.maze.cs47;

import eg.edu.alexu.csd.ds.maze.cs47.IMazeSolver;

@SuppressWarnings("rawtypes")

public class Solver {

	IMazeSolver cach ;
	private Character [][] maze ;
	private int rows ;
	private int cols ;
	private Coordinate Start ;
	
	public Solver(Character [][] maze , Coordinate Start , int n , int m, String method) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		this.maze = maze ;
		this.Start = Start ;
		this.rows = n ;
		this.cols = m ;
		Class c = Class.forName("eg.edu.alexu.csd.ds.maze.cs47."+method);
		cach  = (IMazeSolver) c.newInstance();
	}
	
	public Coordinate Search() {
		Coordinate current = this.Start ;
		cach.add(this.Start);
		while(!cach.isEmpty())
		{

			current = (Coordinate) cach.remove() ;
			if (maze[current.getRow()][current.getCol()] == 'E')
			{

				return current ;
			}
			if (isNotVisited(current.getRow()+1, current.getCol()))
			{
				maze[current.getRow()][current.getCol()] = '-' ;
				Coordinate next = new Coordinate(current.getRow()+1, current.getCol(), current) ;
				cach.add(next);

			}
			if (isNotVisited(current.getRow()-1, current.getCol()))
			{
				maze[current.getRow()][current.getCol()] = '-' ;
				Coordinate next = new Coordinate(current.getRow()-1, current.getCol(), current) ;
				cach.add(next);

			}
			if (isNotVisited(current.getRow(), current.getCol()+1))
			{
				maze[current.getRow()][current.getCol()] = '-' ;
				Coordinate next = new Coordinate(current.getRow(), current.getCol()+1, current) ;
				cach.add(next);

			}
			if (isNotVisited(current.getRow(), current.getCol()-1))
			{
				maze[current.getRow()][current.getCol()] = '-' ;
				Coordinate next = new Coordinate(current.getRow(), current.getCol()-1, current) ;
				cach.add(next);
			}
		}
		return null ;
	}
	
	private boolean isNotVisited (int x , int y) {
		
		if (x>=0 && x<rows && y>=0 && y<cols && (maze[x][y] == '.' || maze[x][y] == 'E'))
		{
			return true ;
		}
		return false ;
	}
}
