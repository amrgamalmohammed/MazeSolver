package eg.edu.alexu.csd.ds.maze.cs47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import eg.edu.alexu.csd.ds.maze.cs47.IMazeSolver;

public class Generator {

	IMazeSolver cach ;
	Random rand = new Random();
	private int rows = 10;
	private int cols = 10;
	private Character [][] maze = new Character[rows][cols] ;
	private Coordinate Start ;
	
	public Generator() {

	}
	
	public Character[][] generate () {
		
		for (int i = 0; i < rows; i++) {
			Arrays.fill(maze[i], '#');
		}
		
		Start = new Coordinate((int)(Math.random()*rows), (int)(Math.random()*cols), null);
		maze[Start.getRow()][Start.getCol()] = 'S';
		
		ArrayList<Coordinate> container = new ArrayList<Coordinate>();
        for(int x=-1;x<=1;x++) {
        	for(int y=-1;y<=1;y++){
        		if(x==0&&y==0||x!=0&&y!=0)
        			continue;
        		try{
        			if(maze[Start.getRow()+x][Start.getCol()+y]=='.') continue;
        		}catch(Exception e){ 
        			continue;
        		}
        		// add coordinates to container
        		container.add(new Coordinate(Start.getRow()+x,Start.getCol()+y,Start));
        	}
        }
        
        Coordinate pre=null;
        while(!container.isEmpty()){
 
        	Coordinate current = container.remove((int)(Math.random()*container.size()));
        	Coordinate opposite = current.opposite();
        	try{

        		if(maze[current.getRow()][current.getCol()]=='#'){
        			if(maze[opposite.getRow()][opposite.getCol()]=='#'){
 
        				maze[current.getRow()][current.getCol()]='.';
        				maze[opposite.getRow()][opposite.getCol()]='.';
 
        				pre = opposite;
 
        				for(int x=-1;x<=1;x++) {
				        	for(int y=-1;y<=1;y++){
				        		if(x==0&&y==0||x!=0&&y!=0)
				        			continue;
				        		try{
				        			if(maze[opposite.getRow()+x][opposite.getCol()+y]=='.') continue;
				        		}catch(Exception e){
				        			continue;
				        		}
				        		container.add(new Coordinate(opposite.getRow()+x,opposite.getRow()+y,opposite));
				        	}
        				}
        			}
        		}
        	}catch(Exception e){
        	}
 
        	if(container.isEmpty())
        		maze[pre.getRow()][pre.getCol()]='E';
        }
        try {
			Solver test = new Solver(maze, Start, rows, cols, "DFS");
			Coordinate E = test.Search();
			if (E == null) {
				return null;
			}
			else {
				for(int i = 0; i < rows; i++) {
					for(int j = 0; j < cols; j++) {
						if (maze[i][j]=='-') {
							maze[i][j] = '.';
						}
					}
					
				}
				maze[Start.getRow()][Start.getCol()] = 'S';
				PrintMaze();
		        return maze;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
        return null;
	}
	
	private void PrintMaze () {
		for(int i = 0 ; i < this.rows ; i++)
		{
			for (int j = 0 ; j < this.cols ; j++)
			{
				System.out.print(maze[i][j]);
			}
			System.out.println("");
		}
		System.out.println("==========================");
	}
	
	public int getRows() {
		return rows;
	}
	
	public int getCols() {
		return cols;
	}
	
	public Coordinate getStart() {
		return Start;
	}
	
}
