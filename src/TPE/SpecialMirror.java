package TPE;

import java.awt.Color;

public class SpecialMirror extends DoubleMirror {
	
	public SpecialMirror(int x, int y, int rotation)
	{
		super(x, y, rotation);
	}
	
	public void hit (Directions dir, Color c)
	{
		
	}
	
	public void callNext(Directions dir)
	{
		//Llama al callNext de DoubleMirror y de Cell
	}
	
	public void unHit (Directions dir)
	{
		//Llama al unHit de DoubleMirror y de Cell
	}

}
