package dev.alex.game.pieces;

import java.awt.Color;
import java.awt.image.BufferedImage;

import dev.alex.game.Game;
import dev.alex.game.gfx.chessGfx.Position;
import dev.alex.game.tile.Tile;

public class BlackKing extends BlackPiece{

	public BlackKing(BufferedImage img, Position p, int id) {
		super(img, p, id);
	}
	
	@Override
	public void makeDots() {
		Game.g.setColor(Color.red);
		renderDot(p.getX() + Tile.rectSize, p.getY() + Tile.rectSize);
		renderDot(p.getX() + Tile.rectSize, p.getY());
		renderDot(p.getX() + Tile.rectSize, p.getY() - Tile.rectSize);
		
		renderDot(p.getX(), p.getY() + Tile.rectSize);
		renderDot(p.getX(), p.getY());
		renderDot(p.getX(), p.getY() - Tile.rectSize);
		
		renderDot(p.getX() - Tile.rectSize, p.getY() + Tile.rectSize);
		renderDot(p.getX() - Tile.rectSize, p.getY());
		renderDot(p.getX() - Tile.rectSize, p.getY() - Tile.rectSize);
		
		if (!wasMoved && !PieceS.blackRook.wasMoved) {
			for (Piece p : Piece.pieces) {
				if (p.p.getX() == Tile.rectSize && p.p.getY() == 0) {
					canRochade = false;
				}
			}
			for (Piece p : Piece.pieces) {
				if (p.p.getX() == 2*Tile.rectSize && p.p.getY() == 0) {
					canRochade = false;
				}
			}
			if (canRochade) {
				renderDot(Tile.rectSize, 0);
			}
		}
		if (!wasMoved && !PieceS.blackRook2.wasMoved) {
			for (Piece p : Piece.pieces) {
				if (p.p.getX() == 5*Tile.rectSize && p.p.getY() == 0) {
					canRochade2 = false;
				}
			}
			for (Piece p : Piece.pieces) {
				if (p.p.getX() == 6*Tile.rectSize && p.p.getY() == 0) {
					canRochade2 = false;
				}
			}
			for (Piece p : Piece.pieces) {
				if (p.p.getX() == 4*Tile.rectSize && p.p.getY() == 0) {
					canRochade2 = false;
				}
			}
			if (canRochade2) {
				renderDot(5*Tile.rectSize, 0);
			}
		}
	}

}
