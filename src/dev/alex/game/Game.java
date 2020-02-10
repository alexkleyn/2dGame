package dev.alex.game;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import dev.alex.game.display.Display;
import dev.alex.game.gfx.ChessPieces;

public class Game implements Runnable { //Anfang von Klasse.
	
	private Display display;
	public int width;
	public int height;	
	public String title;
	private boolean running = false;
	private Thread thread;
	
	private ChessPieces chessPieces;
	private BufferStrategy bs;
	private Graphics g;
	
	
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
	}
	
	
	
	private void init() {
		display = new Display(title, width, height);
		chessPieces = new ChessPieces();
		chessPieces.loadAll();
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
		g.clearRect(0, 0, width, height);
		
		//Drawing	
			Color black = new Color(50, 50, 50);
			Color blue = new Color(200, 200, 200);
			String lastColor = "black";
			int rectSize = 50;
			int x = 0;
			int y = 0;
			
			
			while (y < height) {
				if(((x/rectSize)%2) == 0) {				// Checks whether x is even.
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
		
					g.fillRect(x, y, rectSize, rectSize);
					x = x + rectSize;
				}
				y = y + rectSize;
			}
			
			g.drawImage(chessPieces.blackRook, 0, 0, null);
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
