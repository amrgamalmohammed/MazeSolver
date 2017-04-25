package eg.edu.alexu.csd.ds.maze.cs47;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ReadMaze {
	private int n  ;
	private int m  ;
	private Character [][] maze ;
	private String FileName = "src/eg/edu/alexu/csd/ds/maze/cs47/" ;
	private Coordinate Start ;
	
	public ReadMaze(String FileName){
		this.FileName += FileName ;
	}
	
	public ReadMaze(){
		this("src/eg/edu/alexu/csd/ds/maze/cs47/maze.txt") ;
	}
	
	public void ReadFile () {
		File mazeFile = new File(this.FileName);
		try {
			BufferedReader br = new BufferedReader(new FileReader(mazeFile));
			String temp = br.readLine() ;
			String [] dim = temp.split(" ") ;
			this.n = Integer.parseInt(dim[0]);
			this.m = Integer.parseInt(dim[1]);
			this.maze = new Character[this.n][this.m] ;
			for (int i = 0 ; i < this.n ; i++)
			{
				temp = br.readLine() ;
				for (int j = 0 ; j < this.m ; j++)
				{
					this.maze[i][j] = temp.charAt(j) ;
					if (this.maze[i][j] == 'S')
					{
						this.Start = new Coordinate(i, j, null) ;
					}
				}
			}
			br.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public int getM() {
		return this.m;
	}
	public int getN() {
		return this.n;
	}
	public Character [][] getMaze() {
		return this.maze;
	}

	public Coordinate getStart() {
		return this.Start;
	}
}
