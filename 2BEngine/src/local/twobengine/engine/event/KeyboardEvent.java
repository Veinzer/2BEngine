package local.twobengine.engine.event;

import local.twobengine.engine.window.ActionType;


public class KeyboardEvent extends Event {
	private int keyId;
	private ActionType actionType;
	public KeyboardEvent(int keyId, ActionType actionType) {
		super();
		this.keyId = keyId;
		this.actionType = actionType;
	}
	
	public ActionType getAction() {
		return actionType;
	}
	
	public int getKeyId() {
		return keyId;
		
	}
	
}
