package local.twobengine.engine.graphic;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;
import local.twobengine.engine.window.GameWindow;

public class GraphicManager {
	private ArrayList<GraphicComponent> graphicsComponents = new ArrayList<GraphicComponent>();
	private GameWindow gameWindow;
	public static GraphicManager current;
	public GraphicManager(GameWindow gameWindow) {
		this.setGameWindow(gameWindow);
		current = this;
	}
	
	public GraphicManager(GameWindow gameWindow, GraphicComponent[] graphicsComponentsToArray) {
		this(gameWindow);
		graphicsComponents = (ArrayList<GraphicComponent>) Arrays.asList(graphicsComponentsToArray);
	}
	
	public void addGraphicComponent(GraphicComponent graphicComponent) {
		graphicsComponents.add(graphicComponent);
	}
	
	public void removeGraphicComponent(GraphicComponent graphicComponent) {
		graphicsComponents.remove(graphicComponent);
	}
	
	public ArrayList<GraphicComponent> getGraphicsComponents(){
		return graphicsComponents;
	}
	
	public void drawGraphicManager() {
		Graphics graphics = GameWindow.current().getImageFrame().getGraphics(); 
		if(graphicsComponents.size() <= 0) 
			return;
		for (GraphicComponent graphicBuildComponent : graphicsComponents) {
			graphicBuildComponent.build(graphics);
		}
	}

	public GameWindow getGameWindow() {
		return gameWindow;
	}

	public void setGameWindow(GameWindow gameWindow) {
		this.gameWindow = gameWindow;
	}
	
	public static GraphicManager current() {
		return current;
	}
	
	
}
