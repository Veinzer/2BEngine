package local.twobengine.engine.sound;

import javax.sound.sampled.AudioInputStream;

import local.twobengine.engine.GameEngine;

public class Sound {
	private AudioInputStream is;
	private SoundPlay soundPlay;

	public Sound(AudioInputStream is ) {
		this.is = is;
		this.soundPlay = new SoundPlay(GameEngine.sound, is);
	}
	
	
	public AudioInputStream getAudioInputStream() {
		return is;
	}
	

	public AudioInputStream getStream() {
		return is;
	}
	
	
	
	public SoundPlay getPlayback() {
		return soundPlay;
	}

}
