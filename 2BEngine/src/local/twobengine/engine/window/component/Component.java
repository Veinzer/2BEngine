package local.twobengine.engine.window.component;

import java.awt.Graphics;

import local.twobengine.engine.graphic.GraphicComponent;

public abstract class Component extends GraphicComponent {
	private boolean canClick;
	private String name;
	public Component(String name, boolean canClick, boolean isWindowPos) {
		super(isWindowPos);
		this.name = name;
		this.setCanClick(canClick);
	}
	
	public boolean canClick() {
		return canClick;
	}

	public void setCanClick(boolean canClick) {
		this.canClick = canClick;
	}
	
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	
	@Override
	public abstract void build(Graphics graphics);



	
}
