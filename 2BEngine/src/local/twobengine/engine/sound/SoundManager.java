package local.twobengine.engine.sound;

import java.util.ArrayList;
import javax.sound.sampled.FloatControl;

import local.twobengine.engine.GameEngine;
import local.twobengine.engine.world.Location;

public class SoundManager {
	
	private float volume;
	private static SoundManager currentObject;
	private static ArrayList<String> sounds;
	

	public SoundManager() {	
		volume = 20F;
		
		GameEngine.memory.add("ENGINE_SOUNDS", new ArrayList<String>());
		sounds = new ArrayList<String>();
		currentObject = this;
	
	}
	
	public void setVolume(float volume) {
		this.volume = volume;
	
	}
	
	public float getVolume() {
		return volume;
	} 
	
	public void play(String inAudio) {
		sounds.add(inAudio);
		Sound sound = (Sound)GameEngine.memory.get(inAudio);
		
		sound.getPlayback().play();
	}

	public void play(String inAudio,int x, int y, boolean isWindowPos) {
		sounds.add(inAudio);
	}
	
	public void play(String inAudio, Location location) {
		play(inAudio, location.getX(), location.getY(), location.getIsWindowPos());
	}
	


			
	public void add(String soundName) {
		sounds.add(soundName);
	}
	
	
	public void remove(String soundName) {
		sounds.remove(soundName);
	}
	
	public static SoundManager current() {
		return currentObject;
	}
	
	public static void onLoop() {
		for (String soundsName : sounds) {
			Sound sound = (Sound) GameEngine.memory.get(soundsName);
			FloatControl panControl = (FloatControl) sound.getPlayback().getClip().getControl(FloatControl.Type.PAN);
			panControl.setValue(100);
			}
		}
	
}