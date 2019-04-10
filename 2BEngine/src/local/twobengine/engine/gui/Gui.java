package local.twobengine.engine.gui;

import java.awt.Graphics;

public interface Gui { 
	
	public void loopGame();	
	
	public String getName(); 
	
	public int getId();
	
	public void renderGraphics(Graphics g);
	
	
}
 