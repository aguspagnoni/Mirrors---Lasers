package TPE;

public class Wall extends Cell {
	
	public Wall (int x, int y)
	{
		super(x, y);
	}
	
	@Override
	public void callNext(Directions dir)
	{
		return;
	}

}
