package dev.alex.game;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import dev.alex.game.display.Display;
import dev.alex.game.gfx.chessGfx.ImgS;

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
	
	private void tick() {
		if (PieceS.blackPawn.p.getY() < 150)
			PieceS.blackPawn.p.setY(PieceS.blackPawn.p.getY() + 1);
	}
	
	
	
	private void init() {


		display = new Display(title, width, height);
		ImgS.loadAll(50, 50);
	}
	
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
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
	
	
	private void drawPieces() {
		PieceS.whiteKing.draw();
		PieceS.whiteQueen.draw();
		PieceS.whiteBishop.draw();
		PieceS.whiteBishop2.draw();
		PieceS.whiteKnight.draw();
		PieceS.whiteKnight2.draw();
		PieceS.whiteRook.draw();
		PieceS.whiteRook2.draw();
		
		PieceS.whitePawn.draw();
		PieceS.whitePawn2.draw();
		PieceS.whitePawn3.draw();
		PieceS.whitePawn4.draw();
		PieceS.whitePawn5.draw();
		PieceS.whitePawn6.draw();
		PieceS.whitePawn7.draw();
		PieceS.whitePawn8.draw();
		
		
		PieceS.blackKing.draw();
		PieceS.blackQueen.draw();
		PieceS.blackBishop.draw();
		PieceS.blackBishop2.draw();
		PieceS.blackKnight.draw();
		PieceS.blackKnight2.draw();
		PieceS.blackRook.draw();
		PieceS.blackRook2.draw();
		
		PieceS.blackPawn.draw();
		PieceS.blackPawn2.draw();
		PieceS.blackPawn3.draw();
		PieceS.blackPawn4.draw();
		PieceS.blackPawn5.draw();
		PieceS.blackPawn6.draw();
		PieceS.blackPawn7.draw();
		PieceS.blackPawn8.draw();
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
} // Ende von Klasse.
