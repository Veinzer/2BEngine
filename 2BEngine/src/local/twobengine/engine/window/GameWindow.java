package local.twobengine.engine.window;

import java.awt.Color;

import java.awt.Graphics;
//import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;
import local.twobengine.engine.GameEngine;
import local.twobengine.engine.GameInfo;

public class GameWindow extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JFrame window;
	private JPanel scene;
	//private Graphics2D g2d;
	private BufferedImage currentFrame;
	private boolean fullScreen;
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
		window.addKeyListener(new WindowKeyListener());
		window.setTitle(gameInfo.getName()+" | "+gameInfo.getVersion());
		if(gameInfo.getVersion().length() == 0) {
			window.setTitle(gameInfo.getName());
		}

		window.setIconImage((Image)GameEngine.memory.get("ENGINE_LogoEngine"));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		scene.setBackground(Color.black);
		
		
		if(fullScreen) {
			window.setLocation(0, 0);	
			window.setSize(getToolkit().getScreenSize());
		
		} else {
			
			window.setSize(648, 448);
			window.setLocationRelativeTo(null);
		}
		window.setUndecorated(fullScreen);
		window.setVisible(true);

		this.currentFrame = new BufferedImage(window.getWidth(), window.getHeight(),2);
		
	}
	

	
	public void setFullScreen(boolean fullScreen) {
        window.setVisible(false);		
		window = new JFrame();
	
	    this.fullScreen = fullScreen;
	    init(); 
	    this.currentFrame = new BufferedImage(window.getWidth(), window.getHeight(),2);
	   
	
		
	}
	
	public void setTitle(String title) {
		window.setTitle(title);
		
	}
	public boolean getFullscreen() {
		return fullScreen;
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
