package local.twobengine.engine;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Metrics {
	private int ms;
	private int fps;
	public Metrics() {
		this.ms = 0;
		this.fps = 0;
		
	}
	
	public void setMs(int ms) {
		this.ms = ms;
	}
	
	public void setFps(int fps) {
		this.fps = fps;
	}
	
	public int getMs() {
		return ms;
	}
	
	public int getFps() {
		return fps;
	}
	
	public Metrics drawEngineMetrics(Graphics g) {
		
		//Color transparentGrayColor = new Color(102, 153, 153, Color.TRANSLUCENT);
		g.setColor(Color.white);
		g.setFont(Font.decode(Font.DIALOG));
		g.drawString("Processor: "+System.getenv("PROCESSOR_ARCHITECTURE"), 50, 40);
		g.drawString("MS: "+ms, 50, 50);
		g.drawString("FPS: "+fps, 50, 60);
		
		return this;
	}
}
