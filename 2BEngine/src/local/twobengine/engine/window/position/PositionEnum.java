package local.twobengine.engine.window.position;

public enum PositionEnum {
	
	LEFT("0"),
	CENTER("0"),
	RIGHT("0+1");
	
	private int value;
	private PositionEnum(String decode) {
		value = Integer.decode(decode);
	}
	
	public int getValue() {
		return value;
	}
	

	
	
}
