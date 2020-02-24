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
		renderDotKing(p.getX() + Tile.rectSize, p.getY() + Tile.rectSize);
		renderDotKing(p.getX() + Tile.rectSize, p.getY());
		renderDotKing(p.getX() + Tile.rectSize, p.getY() - Tile.rectSize);
		
		renderDotKing(p.getX(), p.getY() + Tile.rectSize);
		renderDotKing(p.getX(), p.getY());
		renderDotKing(p.getX(), p.getY() - Tile.rectSize);
		
		renderDotKing(p.getX() - Tile.rectSize, p.getY() + Tile.rectSize);
		renderDotKing(p.getX() - Tile.rectSize, p.getY());
		renderDotKing(p.getX() - Tile.rectSize, p.getY() - Tile.rectSize);
		
		if (!wasMoved && !PieceS.blackRook.wasMoved) {
			for (Piece p : Piece.pieces) {
				if (p.p.getX() == Tile.rectSize && p.p.getY() == 0) {
					canRochadeLeft = false;
				}
			}
			for (Piece p : Piece.pieces) {
				if (p.p.getX() == 2*Tile.rectSize && p.p.getY() == 0) {
					canRochadeLeft = false;
				}
			}
			if (canRochadeLeft) {
				renderDotKing(Tile.rectSize, 0);
			}
		}
		if (!wasMoved && !PieceS.blackRook2.wasMoved) {
			for (Piece p : Piece.pieces) {
				if (p.p.getX() == 5*Tile.rectSize && p.p.getY() == 0) {
					canRochadeRight = false;
				}
			}
			for (Piece p : Piece.pieces) {
				if (p.p.getX() == 6*Tile.rectSize && p.p.getY() == 0) {
					canRochadeRight = false;
				}
			}
			for (Piece p : Piece.pieces) {
				if (p.p.getX() == 4*Tile.rectSize && p.p.getY() == 0) {
					canRochadeRight = false;
				}
			}
			if (canRochadeRight) {
				renderDotKing(5*Tile.rectSize, 0);
			}
		}
	}

}
