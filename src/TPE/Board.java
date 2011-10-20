package TPE;

public class Board {
	
	private Cell[][] board;
	
	public Board(int width, int height)
	{
		this.board = new Cell[width][height];
	}
	
	public void setCell(int x, int y, Cell obj)
	{
		board[x][y] = obj;
	}
	
	public Cell getCell(int x, int y)
	{
		return board[x][y];
	}

}
