package eg.edu.alexu.csd.ds.maze.cs47;

import java.util.Scanner;
import eg.edu.alexu.csd.ds.maze.MyStack;

public class SolverApp {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		System.out.println("New Maze or Load from file (Enter New or Load): ");
		String choice = s.nextLine();
		if (choice.equals("Load")) {
			System.out.println("Enter maze file name (Without Extension): ");
			String fileName = s.nextLine();
			fileName += ".txt" ;
			ReadMaze maze = new ReadMaze(fileName);
			maze.ReadFile();
			for(int i = 0 ; i < maze.getN() ; i++)
			{
				for (int j = 0 ; j < maze.getM() ; j++)
				{
					System.out.print(maze.getMaze()[i][j]);
				}
				System.out.println("");
			}
			System.out.println("==========================");
			System.out.println("Choose a method to solve the maze (BFS or DFS): ");
			String method = new String();
			method = s.nextLine();
			
			try {
				Solver solveMaze = new Solver(maze.getMaze(), maze.getStart(), maze.getN(), maze.getM(), method);
				Coordinate E = solveMaze.Search();
				if (E == null) {
					System.out.println("Maze has no solution !");
					return;
				}
				
				MyStack cach = new Stack();
				
				while (E.getPrevious() != null)
				{
					cach.push(E);
					E = E.getPrevious() ;
				}
				System.out.println("The Points you should follow :");
				System.out.println("(" + maze.getStart().getRow() + "," + maze.getStart().getCol() + ")");
				maze.getMaze()[maze.getStart().getRow()][maze.getStart().getCol()] = 'S';
				while (!cach.isEmpty()) {
					E = (Coordinate) cach.pop();
					maze.getMaze()[E.getRow()][E.getCol()] = '*';
					System.out.println("(" + E.getRow() + "," + E.getCol() + ")");
				}
				maze.getMaze()[E.getRow()][E.getCol()] = 'E';
				System.out.println("==========================");
				System.out.println("The Final Path :");
				for(int i = 0 ; i < maze.getN() ; i++)
				{
					for (int j = 0 ; j < maze.getM() ; j++)
					{
						if (maze.getMaze()[i][j] == '-') {
							System.out.print(".");
						}
						else {
							System.out.print(maze.getMaze()[i][j]);
						}
					}
					System.out.println("");
				}
				
				
			} catch (ClassNotFoundException e) {
				System.out.println(e.getMessage());
			} catch (InstantiationException e) {
				System.out.println(e.getMessage());
			} catch (IllegalAccessException e) {
				System.out.println(e.getMessage());
			}
		}
		//Generator part
		else if (choice.equals("New")) {
			
			Generator gen = null;
			Character[][] maze = null;
			while (maze == null) {
				gen = new Generator();
				maze = gen.generate();
			}
			System.out.println("Do you want to solve it ? Y or N");
			choice = s.nextLine();
			if (choice.equals("Y")) {
				System.out.println("Choose a method to solve the maze : ");
				System.out.println("BFS or DFS");
				String method = new String();
				method = s.nextLine();
				try {
					Solver solveMaze = new Solver(maze, gen.getStart(), gen.getRows(), gen.getCols(), method);
					Coordinate E = solveMaze.Search();
					if (E == null) {
						System.out.println("Maze has no solution !");
						return;
					}
					
					MyStack cach = new Stack();
					
					while (E.getPrevious() != null)
					{
						cach.push(E);
						E = E.getPrevious() ;
					}
					System.out.println("The Points you should follow :");
					System.out.println("(" + gen.getStart().getRow() + "," + gen.getStart().getCol() + ")");
					maze[gen.getStart().getRow()][gen.getStart().getCol()] = 'S';
					while (!cach.isEmpty()) {
						E = (Coordinate) cach.pop();
						maze[E.getRow()][E.getCol()] = '*';
						System.out.println("(" + E.getRow() + "," + E.getCol() + ")");
					}
					maze[E.getRow()][E.getCol()] = 'E';
					System.out.println("==========================");
					System.out.println("The Final Path :");
					for(int i = 0 ; i < gen.getRows() ; i++)
					{
						for (int j = 0 ; j < gen.getCols() ; j++)
						{
							if (maze[i][j] == '-') {
								System.out.print(".");
							}
							else {
								System.out.print(maze[i][j]);
							}
						}
						System.out.println("");
					}
				
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}
