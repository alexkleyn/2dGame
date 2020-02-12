package dev.alex.game.states;
import java.awt.Color;
import dev.alex.game.Game;
import dev.alex.game.Piece;

import java.awt.Graphics;
import dev.alex.game.PieceS;

public class GameState extends State {
	
	public int width;
	public int height;
	public Graphics g;
	private Piece currentActor = PieceS.whiteKing;
	
	public void tick() {
		changeActor();
		currentActor.tick();
		
	}

	public void changeActor() {
		if (Game.km.q)
			currentActor = PieceS.whiteQueen;
		if (Game.km.k)
			currentActor = PieceS.whiteKing;
	}
	
	
	public void render(Graphics g) {
		this.g = g;
		drawBoard();
		drawPieces();
	}
	public void setCurrentActor(Piece newCurrentActor) {
		currentActor =  newCurrentActor;
	}
	public Piece getCurrentActor() {
		return currentActor;
	}
	public GameState (int width, int height, Game game) {
		super(game);
		this.width = width;
		this.height = height;
	}
	private void drawPieces() {


		PieceS.whiteKing.render();
		PieceS.whiteQueen.render();
		PieceS.whiteBishop.render();
		PieceS.whiteBishop2.render();
		PieceS.whiteKnight.render();
		PieceS.whiteKnight2.render();
		PieceS.whiteRook.render();
		PieceS.whiteRook2.render();
		
		PieceS.whitePawn.render();
		PieceS.whitePawn2.render();
		PieceS.whitePawn3.render();
		PieceS.whitePawn4.render();
		PieceS.whitePawn5.render();
		PieceS.whitePawn6.render();
		PieceS.whitePawn7.render();
		PieceS.whitePawn8.render();
		
		
		PieceS.blackKing.render();
		PieceS.blackQueen.render();
		PieceS.blackBishop.render();
		PieceS.blackBishop2.render();
		PieceS.blackKnight.render();
		PieceS.blackKnight2.render();
		PieceS.blackRook.render();
		PieceS.blackRook2.render();
		
		PieceS.blackPawn.render();
		PieceS.blackPawn2.render();
		PieceS.blackPawn3.render();
		PieceS.blackPawn4.render();
		PieceS.blackPawn5.render();
		PieceS.blackPawn6.render();
		PieceS.blackPawn7.render();
		PieceS.blackPawn8.render();
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
