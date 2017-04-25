package eg.edu.alexu.csd.ds.maze.cs47;

public class Coordinate {
	
	private int row ;
	private int col ; 
	private Coordinate previous ;
	
	public Coordinate (int row , int col , Coordinate previous) {
		this.setRow(row) ;
		this.setCol(col) ;
		this.setPrevious(previous) ;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public Coordinate getPrevious() {
		return previous;
	}

	public void setPrevious(Coordinate previous) {
		this.previous = previous;
	}
	
	public Coordinate opposite(){
		if(compare(this.row, previous.getRow())!=0)
			return new Coordinate(this.row+compare(this.row, previous.getRow()),this.col,this);
		if(compare(this.col, previous.getCol())!=0)
			return new Coordinate(this.row,this.col+compare(this.col, previous.getCol()),this);
		return null;
	}
	
	public int compare (int x, int y) {
		if (x == y) {
			return 0;
		}
		else if (x < y) {
			return -1;
		}
		return 1;
	}
	
}
