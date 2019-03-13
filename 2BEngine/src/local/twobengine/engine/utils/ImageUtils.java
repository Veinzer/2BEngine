package local.twobengine.engine.utils;

import java.awt.Image;

import javax.swing.ImageIcon;

public class ImageUtils {
	
	private String path;

	public ImageUtils(String path) {
		this.path = path;
	}
	
	public Image getImage() {
		return new ImageIcon(path).getImage();
	}
	
	
	// make package assets for fast image
	public static Image loadGame(String file) {
		return new ImageUtils(ImageUtils.class.getResource("/assets/"+file).getPath()).getImage();
	}

}
