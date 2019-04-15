package local.twobengine.engine.window;

import java.awt.event.MouseEvent;

import java.awt.event.MouseListener;

import local.twobengine.engine.GameEngine;

public class WindowMouseListener implements MouseListener {
	
	//unsed code
	@Override
	public void mouseClicked(MouseEvent event) {
	

	}
	//unsed code
	@Override
	public void mouseEntered(MouseEvent event) {
		

	}
	//unsed code
	@Override
	public void mouseExited(MouseEvent event) {
		

	}

	@Override
	public void mousePressed(MouseEvent event) {
		GameEngine.listener.executeAllEvents(new local.twobengine.engine.event.MouseEvent(event.getButton(), ActionType.PRESS, event.getX(), event.getY()));
	}

	@Override
	public void mouseReleased(MouseEvent event) {
		GameEngine.listener.executeAllEvents(new local.twobengine.engine.event.MouseEvent(event.getButton(), ActionType.RELEASE, event.getX(), event.getY()));
	}

}
