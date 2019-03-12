package org.twobengine.engine.window;

import java.awt.Color;

import java.awt.Graphics;
//import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.twobengine.engine.GameEngine;
import org.twobengine.engine.GameInfo;

public class GameWindow extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame window;
	private JPanel scene;
	//private Graphics2D g2d;
	private BufferedImage currentFrame;
	public static GameWindow currentObject;
	
	public GameWindow() {
		this.window = new JFrame();
		this.scene = this;
		currentObject = this;
		
	}
	
	public void init() {
		GameInfo gameInfo = GameEngine.current().getGameInfo();
		window.setResizable(false);
		window.add(scene);
		window.setTitle(gameInfo.getName()+" | "+gameInfo.getVersion());
		if(gameInfo.getVersion().length() == 0) {
			window.setTitle(gameInfo.getName());
		}
		window.setSize(648, 448);
		window.setLocationRelativeTo(null);
	
		window.setIconImage((Image)GameEngine.memory.get("ENGINE_LogoEngine"));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		scene.setBackground(Color.black);
		//setFullScreen(true);
		window.setVisible(true);
		this.currentFrame = new BufferedImage(window.getWidth(), window.getHeight(),2);
	}
	

	
	public void setFullScreen(boolean fullScreen) {
		if(fullScreen) {
		window.setExtendedState(JFrame.MAXIMIZED_BOTH);
		} else {
			window.setSize(648, 448);
		}
		window.setUndecorated(fullScreen);
		
	}
	
	public void setTitle(String title) {
		window.setTitle(title);
		
	}
	
	public String getTitle() {
		return window.getTitle();
	}
	
	public JFrame getFrame() {
		return window;
	}
	
	public JPanel getPane() {
		return scene;
	}
	
	public BufferedImage getImageFrame() {
		return currentFrame;
	}
	
	//clear scene because normal repaint is bugged

	public static GameWindow current() {
		return currentObject;
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		GameEngine.gameMain.renderGraphics(getImageFrame().getGraphics());
		GameEngine.current().getCurrentGui().renderGraphics(getImageFrame().getGraphics());
		g.drawImage(getImageFrame(),0,0,null);
		
	}
	
	 
}
