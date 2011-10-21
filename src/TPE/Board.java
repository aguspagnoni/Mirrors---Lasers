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
		if (x < 0 || x >= board.length || y < 0 || y >= board[0].length)
			return null;
		return board[x][y];
	}

}
