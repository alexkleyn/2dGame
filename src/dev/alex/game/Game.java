package dev.alex.game;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import dev.alex.game.display.Display;
import dev.alex.game.gfx.chessGfx.ImgS;
import dev.alex.game.states.GameState;
import dev.alex.game.states.State;
import dev.alex.game.states.StateManager;

public class Game implements Runnable { //Anfang von Klasse.
	
	private boolean running = false;
	
	public int width;
	public int height;
	public String title;
	
	private Thread thread;
	private ImgS img;
	private Display display;
	private BufferStrategy bs;
	public static Graphics g;
	
	private State gameState;
	private State settings;
	private State Menu;
	
	
	
	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		g.clearRect(0, 0, width, height);
		//Drawing	
		
		if(StateManager.getState() != null)
			StateManager.getState().render(g);
		
		//End of Drawing
		bs.show();
		g.dispose();
	}
	
	private void tick() {
		if (StateManager.getState() != null)
			StateManager.getState().tick();
	}
	
	private void init() {
		display = new Display(title, width, height);
		ImgS.loadAll(50, 50);
		
		gameState = new GameState(width, height);
		StateManager.setState(gameState);
	}
	
	public void run() {
		init();
		
		int fps = 60;			//makes Game run at same Speed on every Device.
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		
		while(running) {	
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			lastTime = now;
			
			if(delta >= 1) {
				tick();
				render();
				delta--;
			}
		}
		
		stop();
	}
	
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
	}

	public synchronized void start() {
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start(); 					// calls "run" Method.
	}	
	
	public synchronized void stop() {
		if (!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
} // Ende von Klasse.
