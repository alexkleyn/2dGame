package dev.alex.game;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import dev.alex.game.Display;

public class Game implements Runnable { //Anfang von Klasse.
	
	private Display display;
	public int width;
	public int height;	
	public String title;
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
	}
	
	
	
	private void init() {
		display = new Display(title, width, height);
	}
	
	private void tick() {
		
	}
	
	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		//Drawing
		
		g.fillRect(0, 0, width, height);
		
		//End of Drawing
		bs.show();
		g.dispose();
	}
	
	
	
	public void run() {
		init();
		while(running) {
			tick();
			render();
		}
		
		stop();
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
