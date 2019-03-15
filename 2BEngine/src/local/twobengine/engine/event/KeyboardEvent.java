package local.twobengine.engine.event;

public class KeyboardEvent extends Event {
	private int keyId;

	public KeyboardEvent(int keyId) {
		super();
		this.keyId = keyId;
	}
	
	public int getKeyId() {
		return keyId;
		
	}
	
}
