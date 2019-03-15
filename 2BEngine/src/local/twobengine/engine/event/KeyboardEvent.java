package local.twobengine.engine.event;

import local.twobengine.engine.windows.ActionTypeKeyboard;

public class KeyboardEvent extends Event {
	private int keyId;
	private ActionTypeKeyboard actionTypeKeyboard;
	public KeyboardEvent(int keyId, ActionTypeKeyboard actionTypeKeyboard) {
		super();
		this.keyId = keyId;
		this.actionTypeKeyboard = actionTypeKeyboard;
	}
	
	public ActionTypeKeyboard getAction() {
		return actionTypeKeyboard;
	}
	
	public int getKeyId() {
		return keyId;
		
	}
	
}
