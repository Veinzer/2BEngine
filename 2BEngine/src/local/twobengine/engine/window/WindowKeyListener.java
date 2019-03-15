package local.twobengine.engine.window;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import local.twobengine.engine.GameEngine;
import local.twobengine.engine.event.KeyboardEvent;
import local.twobengine.engine.windows.ActionTypeKeyboard;

public class WindowKeyListener implements KeyListener {

	@Override
	public void keyPressed(KeyEvent event) {
		GameEngine.listener.executeAllEvents(new KeyboardEvent(event.getKeyCode(), ActionTypeKeyboard.PRESS));

	}

	@Override
	public void keyReleased(KeyEvent event) {
		GameEngine.listener.executeAllEvents(new KeyboardEvent(event.getKeyCode(), ActionTypeKeyboard.RELEASE));
	}
	
    //unsed code
	@Override
	public void keyTyped(KeyEvent event) {
		// TODO Auto-generated method stub

	}

}
