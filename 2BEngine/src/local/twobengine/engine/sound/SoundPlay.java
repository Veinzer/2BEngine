package local.twobengine.engine.sound;

import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;

import local.twobengine.engine.world.Location;

public class SoundPlay {

	private AudioInputStream soundStream;
	private Clip clip;
	private SoundManager soundManager;
	private Location panLocation;

	public SoundPlay(SoundManager soundManager, AudioInputStream soundStream) {

		this.soundStream = soundStream;
		try {
			this.clip = AudioSystem.getClip();
			this.soundManager = soundManager;
			this.soundStream = soundStream;
			clip.open(soundStream);
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void play() {
	  new Thread(new Runnable() {
		
		@Override
		public void run() {
			clip.start();
		}
	  }).run();
		
	 
	}
	
	public void play(Location location) {
		this.panLocation = location;
	}
	
	public void pause() {
		clip.stop();
	}
	
	public Clip getClip() {
		return clip;
	}
	
	public Location getPos() {
		return panLocation;
	}


	public void setPos(Location panLocation) {
		this.panLocation = panLocation;
	}


	
	
	public AudioInputStream getStream() {
		return soundStream;
		
	}


	public SoundManager getSoundManager() {
		return soundManager;
	}



	
	
	
	
}
