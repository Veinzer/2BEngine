package local.twobengine.engine;

import local.twobengine.engine.event.KeyboardEvent;
import local.twobengine.engine.graphic.GraphicManager;
import local.twobengine.engine.gui.DefaultGui;
import local.twobengine.engine.gui.Gui;
import local.twobengine.engine.listener.Listener;
import local.twobengine.engine.listener.ListenerManager;
import local.twobengine.engine.listener.ValidateListener;
import local.twobengine.engine.memory.Memory;
import local.twobengine.engine.sound.SoundManager;
import local.twobengine.engine.utils.ImageUtils;
import local.twobengine.engine.window.GameWindow;

public class GameEngine implements Listener {

	/**
	 * 
	 */

	public static Metrics metrics;
	public static SoundManager sound;
	public static GameWindow window;
	public static GraphicManager graphicManager;
	public static Memory memory;
	public static ListenerManager listener;
	private static GameEngine currentObject;
	
	private static boolean isRun;

	public static Game gameMain;

	// for lower computer
	private Gui currentGui;
	private int waitSpeed;
	private int tickSpeed;
	private int fpsSpeed;
	public static GameInfo gameInfo;

	public static void init(Game currentGameMain) {
		gameMain = currentGameMain;

		memory = new Memory(838860799);

		System.out.println("[Started-Log] Initialising of MemoryManager with default memory size");

		memory.add("ENGINE_LogoEngine", ImageUtils.loadGame("logoEngine.png"));

		System.out.println("[Started-Log] Initialising of Assets");

		currentObject = new GameEngine();

		System.out.println("[Started-Log] Initialising of GameEngine");

		currentObject.setWaitSpeed(6);
		System.out.println("[Started-Log] Initialising of WaitSpeed");

		sound = new SoundManager();
		
		
		listener = new ListenerManager();
		listener.addListener(currentObject);
		window = new GameWindow();

		System.out.println("[Started-Log] Initialising of GameWindow");
		
		graphicManager = new GraphicManager(window);
		
		gameInfo = new GameInfo() {

			@Override
			public String getVersion() {
				// TODO Auto-generated method stub
				return "INDEV";
			}

			@Override
			public String getName() {
				// TODO Auto-generated method stub
				return "2BEngine";
			}

			@Override
			public String[] getAuthors() {
				// TODO Auto-generated method stub
				return new String[] { "2BEngine" };
			}

		};

		System.out.println("[Started-Log] GameInfo is set to default");

		currentObject.setTickSpeed(20);

		System.out.println("[Started-Log] TickSpeed is set to default");

		currentObject.setFpsSpeed(60);

		System.out.println("[Started-Log] FpsSpeed is set to default");

		metrics = new Metrics();

		System.out.println("[Started-Log] Gui is set to default");

		current().setCurrentGui(new DefaultGui());
	}

	public static void startGameEngine() {

		isRun = true;

		Long startTimeMS = System.currentTimeMillis();
		Long startTimeFps = System.currentTimeMillis();

		int metricMs = 0;

		int metricFps;
		
		window.init();
		
		while (isRun) {
			try {

				if (System.currentTimeMillis() - startTimeMS <= currentObject.getTickSpeed()) {

					gameMain.loopGame();
					current().currentGui.loopGame();
				} else {

					metricMs = (int) (System.currentTimeMillis() - startTimeMS);
					metrics.setMs(1000 / metricMs);
					startTimeMS = System.currentTimeMillis();
				}

				if (System.currentTimeMillis() - startTimeFps <= currentObject.getFpsSpeed()) {

					window.getPane().repaint();
				} else {

					metricFps = (int) (System.currentTimeMillis() - startTimeFps);
					metrics.setFps(1000 / metricFps);
					startTimeFps = System.currentTimeMillis();
					// for fix flashing

				}

				Thread.sleep(currentObject.getWaitSpeed());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

	public static GameEngine current() {
		return currentObject;
	}

	public void setFpsSpeed(int fpsSpeed) {
		this.fpsSpeed = 1000 / fpsSpeed;
	}

	public void setTickSpeed(int tickSpeed) {
		this.tickSpeed = 1000 / tickSpeed;
	}

	public void setGameInfo(GameInfo info) {
		gameInfo = info;
	}

	public void setWaitSpeed(int waitSpeed) {
		this.waitSpeed = waitSpeed;
	}

	public void setCurrentGui(Gui gui) {
		this.currentGui = gui;
	}

	public Gui getCurrentGui() {
		return currentGui;
	}

	public GameInfo getGameInfo() {
		return gameInfo;
	}

	public int getTickSpeed() {
		return tickSpeed;
	}

	public int getFpsSpeed() {
		return fpsSpeed;
	}

	public int getWaitSpeed() {
		return waitSpeed;
	}
    


}