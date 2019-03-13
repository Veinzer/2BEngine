package local.twobengine.engine.world;


public class Location {
	private int xPos; 
	private int yPos;
	private boolean isWindowPos;
	
	public Location(int xPos, int yPos, boolean isWindowPos) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.isWindowPos = isWindowPos;
	}
	
	public Location(boolean isWindowPos) {
		this(0, 0, isWindowPos);
	}
	
	public void setX(int xPos) {
		this.xPos = xPos;
	}
	
	public void setY(int yPos) {
		this.yPos = yPos;
	}
	
	public int getX() {
		return xPos;
	}
	
	
	public int getY() {
		return yPos;
	}
	
	public boolean getIsWindowPos() {
		return isWindowPos;
	}
	
	public static Location parseLocation(String stringToParseLocation) {
		String[] stringParseLocation = stringToParseLocation.split(":");
		int xPos = Integer.parseInt(stringParseLocation[0]);
		int yPos = Integer.parseInt(stringParseLocation[1]);
		String binaryResult = stringParseLocation[2];
		boolean binaryConvertBoolean = false;
		
		if (binaryResult.equals("1")) {
			binaryConvertBoolean = true;
		} else if(!(binaryResult.equals("0"))){
			throw new NullPointerException("Error: Location.java update the engine or revise your code.");
		}
		
		return new Location(xPos, yPos, binaryConvertBoolean );
	}
	
}
