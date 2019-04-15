package local.twobengine.engine.window.component;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.StringWriter;

import javax.swing.JButton;

import local.twobengine.engine.phys.Region2D;
import local.twobengine.engine.world.Location;

public class ButtonComponent extends Component{
	private int width;
	private int height;
	private Color color;
	private Color hoverColor;
	public ButtonComponent(String name, int width, int height, Location location, Color color) {
		super(name, true, true);
		this.width = width;
		this.height = height;
		this.color = color;
		this.hoverColor = color;
		this.setLocation(location);
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setHoverColor(Color hoverColor) {
		this.hoverColor = hoverColor;
	}
	
	public Color getHoverColor() {
		return hoverColor;
	}
	
	@Override
	public Region2D getBounds() {
		Location locationTwo = new Location(getLocation().getX(), getLocation().getY(), false);
		locationTwo.setX(getLocation().getX()+width);
		locationTwo.setY(getLocation().getY()+height);
		return new Region2D(getLocation(),locationTwo) ;
	}
	
//Front to set
	@Override
	public void build(Graphics graphics) {
		Graphics2D graphics2d = (Graphics2D) graphics;
		graphics2d.setColor(color);
		graphics2d.fillRoundRect(getLocation().getX(), getLocation().getY(), width, height, width/10, height/10);
		graphics2d.setColor(Color.black);
		int firstNumber = getLocation().getX()+width;
		firstNumber /= 2;
		firstNumber -= graphics2d.getFontMetrics().stringWidth(getName())/2;
		graphics2d.drawString(getName(), firstNumber, getLocation().getY()+height/2);		
	}

}
