package dev.alex.game;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.image.BufferStrategy;
import dev.alex.game.display.Display;

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
		
		Color black = new Color(0, 0, 0);
		Color blue = new Color(0, 255, 255);
		String lastColor = "black";
		int x = 0;
		int y = 0;
		
		while (y < height) {
			if(((x/50)%2) == 0) {				// Checks whether x is even.
				if (lastColor == "black") {
					g.setColor(blue);
					lastColor = "blue";
				} else {
					g.setColor(black);
					lastColor = "black";
				}
			}
			x = 0;
			while (x < width) {
				if (lastColor == "black") {
					g.setColor(blue);
					lastColor = "blue";
				} else {
					g.setColor(black);
					lastColor = "black";
				}
	
				g.fillRect(x, y, 50, 50);
				x = x + 50;
			}
			y = y + 50;
		}
		
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
