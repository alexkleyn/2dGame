package dev.alex.game.states;
import dev.alex.game.Game;

import dev.alex.game.Launcher;
import dev.alex.game.gfx.chessGfx.ImgS;
import dev.alex.game.gfx.chessGfx.pS;
import dev.alex.game.pieces.Piece;
import java.awt.Graphics;
import dev.alex.game.pieces.PieceS;
import dev.alex.game.tile.Tile;

public class GameState extends State {
	
	public boolean lastWasBlack = true;
	public int width;
	public int height;
	public Graphics g;
	private Piece currentActor = PieceS.whiteKing;
	public boolean makeDots = false;
	Piece piece = new Piece(ImgS.ImgBlackBishop, pS.pBlackBishop, 32);
	
	public void tick() {
		pieceDrag();
		changeActor("white");
		currentActor.tick();
		
	}

	public void pieceDrag() {
		if (Game.mm.getLeftPressed()) {
			for (Piece piece : Piece.pieces) {
				if(piece.bounds.contains(Game.mm.getMouseX(), Game.mm.getMouseY())) {
					Integer newPosX = null;
					Integer newPosY = null;
					makeDots = true;
					this.piece = piece;
					currentActor = piece;
					while(!Game.mm.getRightPressed()) {
						Launcher.game1.render();
						int bumpX = (Game.mm.getMouseX()%50);
						newPosX = (Game.mm.getMouseX() - bumpX);
						int bumpY = (Game.mm.getMouseY()%50);
						newPosY = (Game.mm.getMouseY() - bumpY);
						System.out.println("waiting");
					}
					if(newPosX != null && newPosY != null) {
						for (Tile t : Tile.tiles) {
							if(newPosX == t.x && newPosY == t.y && t.enterable) {
								piece.p.setX(newPosX);
								piece.p.setY(newPosY);
								for (Piece p : Piece.pieces) {
									if (piece.p.getX() == p.p.getX() && piece.p.getY() == p.p.getY() && piece.getId() != p.getId() && piece.isBlack != p.isBlack)
										p.delete();
								}
								t.enterable = false;
							}
						}
					}
					for (Tile t : Tile.tiles) {
						if(t.enterable)
							t.enterable = false;
					}
					makeDots = false;
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
		if(makeDots)
			piece.makeDots();
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
		for(Tile t : Tile.tiles)
		t.render(g);
	}
} // Ende von Klasse