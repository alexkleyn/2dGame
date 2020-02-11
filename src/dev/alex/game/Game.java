package dev.alex.game;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import dev.alex.game.display.Display;
import dev.alex.game.gfx.ChessPieces;
import dev.alex.game.gfx.Position;
import dev.alex.game.gfx.setPositions;

public class Game implements Runnable { //Anfang von Klasse.
	
	private boolean running = false;
	
	public int width;
	public int height;
	public String title;
	
	private Thread thread;
	private ChessPieces chessPieces;
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
		drawChessPieces();
		
		
		//End of Drawing
		bs.show();
		g.dispose();
	}
	
	
	private void drawChessPieces() {


		

		g.drawImage(chessPieces.whiteKing, setPositions.pWhiteKing.getX(), setPositions.pWhiteKing.getY(), null);
		g.drawImage(chessPieces.whiteQueen, setPositions.pWhiteQueen.getX(), setPositions.pWhiteQueen.getY(), null);
		g.drawImage(chessPieces.whiteBishop, setPositions.pWhiteBishop.getX(), setPositions.pWhiteBishop.getY(), null);
		g.drawImage(chessPieces.whiteBishop, setPositions.pWhiteBishop2.getX(), setPositions.pWhiteBishop2.getY(), null);
		g.drawImage(chessPieces.whiteKnight, setPositions.pWhiteKnight.getX(), setPositions.pWhiteKnight.getY(), null);
		g.drawImage(chessPieces.whiteKnight, setPositions.pWhiteKnight2.getX(), setPositions.pWhiteKnight2.getY(), null);
		g.drawImage(chessPieces.whiteRook, setPositions.pWhiteRook.getX(), setPositions.pWhiteRook.getY(), null);
		g.drawImage(chessPieces.whiteRook, setPositions.pWhiteRook2.getX(), setPositions.pWhiteRook2.getY(), null);
		
		int x = 0;
		for (int i = 0; i < 8; i++) {
			g.drawImage(chessPieces.whitePawn, x, 300, null);
			x = x + 50;
		}
		
		g.drawImage(chessPieces.blackKing, setPositions.pBlackKing.getX(), setPositions.pBlackKing.getY(), null);
		g.drawImage(chessPieces.blackQueen, setPositions.pBlackQueen.getX(), setPositions.pBlackQueen.getY(), null);
		g.drawImage(chessPieces.blackBishop, setPositions.pBlackBishop.getX(), setPositions.pBlackBishop.getY(), null);
		g.drawImage(chessPieces.blackBishop, setPositions.pBlackBishop2.getX(), setPositions.pBlackBishop2.getY(), null);
		g.drawImage(chessPieces.blackKnight, setPositions.pBlackKnight.getX(), setPositions.pBlackKnight.getY(), null);
		g.drawImage(chessPieces.blackKnight, setPositions.pBlackKnight2.getX(), setPositions.pBlackKnight2.getY(), null);
		g.drawImage(chessPieces.blackRook, setPositions.pBlackRook.getX(), setPositions.pBlackRook.getY(), null);
		g.drawImage(chessPieces.blackRook, setPositions.pBlackRook2.getX(), setPositions.pBlackRook2.getY(), null);
		
		x = 0;
		for (int i = 0; i < 8; i++) {
			g.drawImage(chessPieces.blackPawn, x, 50, null);
			x = x + 50;
		}
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
		chessPieces = new ChessPieces();
		chessPieces.loadAll(50, 50);
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
