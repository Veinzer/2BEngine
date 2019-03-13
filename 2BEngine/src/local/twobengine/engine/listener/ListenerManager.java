package local.twobengine.engine.listener;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import local.twobengine.engine.event.Event;

public class ListenerManager {
	private ArrayList<Listener> listeners;
	private ArrayList<Event> events;
	
	public ListenerManager() {
		listeners = new ArrayList<>();
	}
	
	public void addListener(Listener listener) {

		listeners.add(listener);
	}
	
	public void removeListener(Listener listener) {
		listeners.remove(listener);
	}
	
	public void addEvent(Event event) {
		if(!(events.contains(event))) {
			events.add(event);
		}
	}
	
	public void removeEvent(Event event) {
		if(events.contains(event)) {
			events.remove(event);
		}
	}
	
	public void executeAllEvents(Event event) {
		for(Listener listener : listeners) {
			for(Method method : listener.getClass().getMethods()) {
				for(Annotation annotation : method.getDeclaredAnnotations()) {
				
				if(annotation.annotationType().getSimpleName().equals("ValidateListener")&& method.getParameterTypes().length == 1 && method.getParameterTypes()[0]== event.getClass()) {
					
					try {
						method.invoke(listener, new Object[] {event});
					} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
						e.printStackTrace();
					}
				}
				}
			}
		}
	}
	
	public List<Event> getEvents(){
		return events;
	}
	
	public ArrayList<Listener> getListeners() {
		return listeners;
	}
}
