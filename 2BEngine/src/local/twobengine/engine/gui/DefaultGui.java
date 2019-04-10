package local.twobengine.engine.gui;

import java.awt.Color;
import java.awt.Graphics;

public class DefaultGui implements Gui{
	
	public String getName() {
		return "DefaultGui";
	}

	
	public int getId() {
		return -1;
	}
	
	
	public void loopGame() {
		
	}

	public void renderGraphics(Graphics g) {
		g.setColor(Color.white);
		g.drawString("DEFAULT GUI ENGINE BY @Veinzer", 50, 50);
	}


}
