package local.twobengine.engine.event;

public abstract class Event {
	
	private String name; 

	public Event() {
		name = getClass().getName();
	}
	
	public String getName() {
		return name;
	}
	
	
}
