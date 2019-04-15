package local.twobengine.engine.window;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import local.twobengine.engine.GameEngine;
import local.twobengine.engine.event.KeyboardEvent;

public class WindowKeyListener implements KeyListener {

	@Override
	public void keyPressed(KeyEvent event) {
		GameEngine.listener.executeAllEvents(new KeyboardEvent(event.getKeyCode(), ActionType.PRESS));

	}

	@Override
	public void keyReleased(KeyEvent event) {
		GameEngine.listener.executeAllEvents(new KeyboardEvent(event.getKeyCode(), ActionType.RELEASE));
	}
	
    //unsed code
	@Override
	public void keyTyped(KeyEvent event) {
		// TODO Auto-generated method stub

	}

}
