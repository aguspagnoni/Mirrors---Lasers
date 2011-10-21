package TPE;

import java.awt.Color;

public class BeamGenerator extends Cell {
	
	private Directions dir;
	private Color col;
	
	public BeamGenerator(int x,int y,Directions dir,Color col)
	{
		super(x,y);
		this.dir = dir;
		this.col = col;
	}

	public void hit (Directions dir)
	{
		return;
	}
	
	public void unHit(Directions dir)
	{
		return;
	}
}
