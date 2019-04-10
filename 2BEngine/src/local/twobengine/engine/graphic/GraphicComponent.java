package local.twobengine.engine.graphic;

import java.awt.Graphics;

import local.twobengine.engine.phys.Region2D;
import local.twobengine.engine.world.Location;

public abstract class GraphicComponent {
	private Location loc;
	
	private Region2D region2d;

	private boolean canGravity;
	
	public GraphicComponent(boolean isWindowPos) {
		loc = new Location(0, 0, isWindowPos);
	}
	
	public void setLocation(Location location) {
		this.loc = location;
	}
	
	public Location getLocation() {
		return loc;
	}
	
	
	public Region2D getBounds() {
		return region2d;
	}
	
	public boolean canGravity() {
		// TODO Auto-generated method stub
		return canGravity;
	}

	public abstract void build(Graphics graphics);


}
