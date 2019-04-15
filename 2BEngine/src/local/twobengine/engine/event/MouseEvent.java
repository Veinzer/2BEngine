package local.twobengine.engine.event;

import local.twobengine.engine.window.ActionType;

public class MouseEvent extends Event {
	private int keyId;
	private ActionType actionType;
	private int xPos;
	private int yPos;
	public MouseEvent(int keyId, ActionType actionType, int xPos, int yPos) {
		super();
		this.keyId = keyId;
		this.actionType = actionType;
		this.setX(xPos);
		this.setY(yPos);
	}
	
	public ActionType getAction() {
		return actionType;
	}
	
	public int getKeyId() {
		return keyId;
		
	}

	public int getXPos() {
		return xPos;
	}

	public void setX(int xPos) {
		this.xPos = xPos;
	}

	public int getYPos() {
		return yPos;
	}

	public void setY(int yPos) {
		this.yPos = yPos;
	}
}
