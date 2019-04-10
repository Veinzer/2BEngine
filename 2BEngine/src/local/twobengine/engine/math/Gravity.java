package local.twobengine.engine.math;

import local.twobengine.engine.graphic.GraphicComponent;
import local.twobengine.engine.world.Location;

public class Gravity {
	private int speedGravity;
	private int tickGravity;
	private GraphicComponent[] graphicComponents;
	

	public Gravity(int speedGravity, GraphicComponent[] graphicComponents) {
		this.speedGravity = speedGravity;
		this.graphicComponents = graphicComponents;
	}
	
	public void setSpeedGravity(int speedGravity) {
		this.speedGravity = speedGravity;
	
	}
	
	public int getSpeedGravity() {
		return speedGravity;
	}
	
	public GraphicComponent[] getGraphicComponents() {
		return graphicComponents;
	}
	

	
	public void updateGravity() {
		if(!(tickGravity >= speedGravity)) {
			
			
		
		for (GraphicComponent graphicComponent : graphicComponents) {
			boolean cancelGravity = false;
			if(graphicComponent.canGravity()) {
				for(GraphicComponent graphicComponentPrevent : graphicComponents) {
					if(graphicComponentPrevent.getBounds().inspect(new Location(graphicComponent.getLocation().getX(), graphicComponent.getLocation().getY()-1, false))||graphicComponentPrevent.getBounds().inspect(new Location(graphicComponent.getLocation().getX(), graphicComponent.getLocation().getY()+1, false))) {
						cancelGravity = true;
					}
				}
			} else {
				cancelGravity = true;
			}
			if(!cancelGravity) {
				graphicComponent.setLocation(new Location(graphicComponent.getLocation().getX(), graphicComponent.getLocation().getY()-1, false));
			}
		}
		

		
		tickGravity++;
		}else {
			tickGravity = 0;
		}
	}
}
