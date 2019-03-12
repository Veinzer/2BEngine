package org.twobengine.engine.memory;

import java.util.HashMap;

public class Memory {

	private HashMap<String,Object> map;
	
	public Memory(int size) {
		map = new HashMap<String, Object>();
	}
	
	public Object get(String key) {
		return map.get(key);
	}
	
	public void add(String name, Object element) {
		map.put(name, element);
	}
	
	public Object addReturn(String name, Object element) {
		add(name, element);
		return element;
	}
	
	
	public void remove(String name) {
		map.remove(map.get(name));
	}
	
	
	
	public void wipeMemory() {
		map.clear();
	}

	
	
	
}
