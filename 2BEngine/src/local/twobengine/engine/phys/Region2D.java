package local.twobengine.engine.phys;

import local.twobengine.engine.world.Location;

public class Region2D {
	
	private Location posOne;
	private Location posTwo;
	private int minX;
	private int maxX;
	private int minY;
	private int maxY;
	
	void calcRegion2D() {
		minX = Math.min(posOne.getX(), posTwo.getX());
		maxX = Math.max(posOne.getX(), posTwo.getX());
		minY = Math.min(posOne.getY(), posTwo.getY());
		maxY = Math.max(posOne.getY(), posTwo.getY());
	}
	
	public Region2D(Location posOne, Location posTwo) {
		this.posOne = posOne;
		this.posTwo = posTwo;
		calcRegion2D();
	}
	
	public void setPosOne(Location pos) {
		this.posOne = pos;
		calcRegion2D();
	}
	
	public void setPosTwo(Location pos) {
		this.posTwo = pos;
		calcRegion2D();
	}
	
	public Location getPosOne() {
		return posOne;
	}
	
	public Location getPosTwo() {
		return posTwo;
	}
	
	public int getSize() {
		return maxX*maxY;
	}

	public boolean inspect(Location location) {
		return location.getX() >= minX && location.getX() <= maxX && location.getY() >= minY && location.getY() <=maxY;
	}
}
