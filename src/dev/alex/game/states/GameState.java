package dev.alex.game.states;
import java.awt.Color;
import dev.alex.game.Game;
import dev.alex.game.Piece;

import java.awt.Graphics;
import java.awt.Rectangle;

import dev.alex.game.PieceS;
import dev.alex.game.tile.Tile;

public class GameState extends State {
	
	public int width;
	public int height;
	public Graphics g;
	private Piece currentActor = PieceS.whiteKing;
	
	public void tick() {
		pieceDrag();
		changeActor("white");
		currentActor.tick();
		
	}

	public void pieceDrag() {
		if (Game.mm.getLeftPressed()) {
			for (Piece piece : Piece.pieces) {
				if(piece.bounds.contains(Game.mm.getMouseX(), Game.mm.getMouseY())) {
					currentActor = piece;
					while(!Game.mm.getRightPressed()) {
						piece.p.setX(Game.mm.getMouseX());
						piece.p.setY(Game.mm.getMouseY());
						System.out.println("waiting");
					}
					piece.render();
				}
			}
		}
	}
	
	public void changeActor(String color) {
		if (color == "white" || color == "White") {
			if (Game.km.q)
				currentActor = PieceS.whiteQueen;
			if (Game.km.k)
				currentActor = PieceS.whiteKing;
		}
		
		else if (color == "black" || color == "Black") {
			if (Game.km.q)
				currentActor = PieceS.blackQueen;
			if (Game.km.k)
				currentActor = PieceS.blackKing;
		} else {
			System.out.println("Wrong value given for 'changeActor'.");
		}
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
	public void drawBoard() {
		boolean lastColorBlack = true;
		int x = 0;
		int y = 0;
		
		while (y < height) {
			if(((x/Tile.rectSize)%2) == 0) {				// Checks whether x is even.
				if (lastColorBlack) {
					lastColorBlack = false;
				} else {
					lastColorBlack = true;
				}
			}
			x = 0;
			while (x < width) {
				if (!lastColorBlack) {
					Tile.tiles[0].render(g, x, y);
					Tile.tiles[0].bounds = new Rectangle(x, y, 50, 50);
					lastColorBlack = true;
				} else {
					Tile.tiles[1].render(g, x, y);
					Tile.tiles[1].bounds = new Rectangle(x, y, 50, 50);
					lastColorBlack = false;
				}
				x += Tile.rectSize;
			}
			y +=Tile.rectSize;
		}
	}
} // Ende von Klasse