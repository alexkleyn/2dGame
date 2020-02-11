package dev.alex.game.states;
import java.awt.Color;
import java.awt.Graphics;

import dev.alex.game.PieceS;

public class GameState extends State {
	
	public int width;
	public int height;
	
	public Graphics g;
	
	
	public GameState(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public void tick() {
		if (PieceS.whitePawn4.p.getY() > 200)
			PieceS.whitePawn4.p.setY(PieceS.whitePawn4.p.getY() - 2);
	}

	public void render(Graphics g) {
		this.g = g;
		drawBoard();
		drawPieces();
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
	
	
}
