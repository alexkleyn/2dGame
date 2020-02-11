package dev.alex.game;
import java.awt.Color;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import dev.alex.game.display.Display;
import dev.alex.game.gfx.ImgS;
import dev.alex.game.gfx.pS;

public class Game implements Runnable { //Anfang von Klasse.
	
	private boolean running = false;
	
	public int width;
	public int height;
	public String title;
	
	private Thread thread;
	private ImgS img;
	private Display display;
	private BufferStrategy bs;
	private Graphics g;
	

	
	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		g.clearRect(0, 0, width, height);
		
		//Drawing	
		
		drawBoard();
		drawPieces();
		
		
		//End of Drawing
		bs.show();
		g.dispose();
	}
	
	
	private void drawPieces() {

		g.drawImage(ImgS.ImgWhiteKing, pS.pWhiteKing.getX(), pS.pWhiteKing.getY(), null);
		g.drawImage(ImgS.ImgWhiteQueen, pS.pWhiteQueen.getX(), pS.pWhiteQueen.getY(), null);
		g.drawImage(ImgS.ImgWhiteBishop, pS.pWhiteBishop.getX(), pS.pWhiteBishop.getY(), null);
		g.drawImage(ImgS.ImgWhiteBishop, pS.pWhiteBishop2.getX(), pS.pWhiteBishop2.getY(), null);
		g.drawImage(ImgS.ImgWhiteKnight, pS.pWhiteKnight.getX(), pS.pWhiteKnight.getY(), null);
		g.drawImage(ImgS.ImgWhiteKnight, pS.pWhiteKnight2.getX(), pS.pWhiteKnight2.getY(), null);
		g.drawImage(ImgS.ImgWhiteRook, pS.pWhiteRook.getX(), pS.pWhiteRook.getY(), null);
		g.drawImage(ImgS.ImgWhiteRook, pS.pWhiteRook2.getX(), pS.pWhiteRook2.getY(), null);
		
		g.drawImage(ImgS.ImgWhitePawn, pS.pWhitePawn.getX(), pS.pWhitePawn.getY(), null);
		g.drawImage(ImgS.ImgWhitePawn, pS.pWhitePawn2.getX(), pS.pWhitePawn2.getY(), null);
		g.drawImage(ImgS.ImgWhitePawn, pS.pWhitePawn3.getX(), pS.pWhitePawn3.getY(), null);
		g.drawImage(ImgS.ImgWhitePawn, pS.pWhitePawn4.getX(), pS.pWhitePawn4.getY(), null);
		g.drawImage(ImgS.ImgWhitePawn, pS.pWhitePawn5.getX(), pS.pWhitePawn5.getY(), null);
		g.drawImage(ImgS.ImgWhitePawn, pS.pWhitePawn6.getX(), pS.pWhitePawn6.getY(), null);
		g.drawImage(ImgS.ImgWhitePawn, pS.pWhitePawn7.getX(), pS.pWhitePawn7.getY(), null);
		g.drawImage(ImgS.ImgWhitePawn, pS.pWhitePawn8.getX(), pS.pWhitePawn8.getY(), null);
		
		g.drawImage(ImgS.ImgBlackKing, pS.pBlackKing.getX(), pS.pBlackKing.getY(), null);
		g.drawImage(ImgS.ImgBlackQueen, pS.pBlackQueen.getX(), pS.pBlackQueen.getY(), null);
		g.drawImage(ImgS.ImgBlackBishop, pS.pBlackBishop.getX(), pS.pBlackBishop.getY(), null);
		g.drawImage(ImgS.ImgBlackBishop, pS.pBlackBishop2.getX(), pS.pBlackBishop2.getY(), null);
		g.drawImage(ImgS.ImgBlackKnight, pS.pBlackKnight.getX(), pS.pBlackKnight.getY(), null);
		g.drawImage(ImgS.ImgBlackKnight, pS.pBlackKnight2.getX(), pS.pBlackKnight2.getY(), null);
		g.drawImage(ImgS.ImgBlackRook, pS.pBlackRook.getX(), pS.pBlackRook.getY(), null);
		g.drawImage(ImgS.ImgBlackRook, pS.pBlackRook2.getX(), pS.pBlackRook2.getY(), null);
		
		g.drawImage(ImgS.ImgBlackPawn, pS.pBlackPawn.getX(), pS.pBlackPawn.getY(), null);
		g.drawImage(ImgS.ImgBlackPawn, pS.pBlackPawn2.getX(), pS.pBlackPawn2.getY(), null);
		g.drawImage(ImgS.ImgBlackPawn, pS.pBlackPawn3.getX(), pS.pBlackPawn3.getY(), null);
		g.drawImage(ImgS.ImgBlackPawn, pS.pBlackPawn4.getX(), pS.pBlackPawn4.getY(), null);
		g.drawImage(ImgS.ImgBlackPawn, pS.pBlackPawn5.getX(), pS.pBlackPawn5.getY(), null);
		g.drawImage(ImgS.ImgBlackPawn, pS.pBlackPawn6.getX(), pS.pBlackPawn6.getY(), null);
		g.drawImage(ImgS.ImgBlackPawn, pS.pBlackPawn7.getX(), pS.pBlackPawn7.getY(), null);
		g.drawImage(ImgS.ImgBlackPawn, pS.pBlackPawn8.getX(), pS.pBlackPawn8.getY(), null);
	}
	
	private void tick() {

		
	}
	
	private void drawBoard() {
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
	} // Ende von drawBoard
	
	private void init() {

		display = new Display(title, width, height);
		ImgS.loadAll(50, 50);
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
	
	public void run() {
		init();
		while(running) {
			tick();
			render();
		}
		stop();
	}
} // Ende von Klasse.
