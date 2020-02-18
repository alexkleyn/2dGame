package dev.alex.game.pieces;

import java.awt.Color;
import java.awt.image.BufferedImage;

import dev.alex.game.Game;
import dev.alex.game.gfx.chessGfx.Position;

public class BlackKing extends BlackPiece {



	public BlackKing(BufferedImage img, Position p, int id) {
		super(img, p, id);
	}
	
	@Override
	public void makeDots() {
		Game.g.setColor(Color.red);
		renderDot(p.getX() + OFFSET, p.getY() + OFFSET);
		renderDot(p.getX() + OFFSET, p.getY());
		renderDot(p.getX() + OFFSET, p.getY() - OFFSET);
		
		renderDot(p.getX(), p.getY() + OFFSET);
		renderDot(p.getX(), p.getY());
		renderDot(p.getX(), p.getY() - OFFSET);
		
		renderDot(p.getX() - OFFSET, p.getY() + OFFSET);
		renderDot(p.getX() - OFFSET, p.getY());
		renderDot(p.getX() - OFFSET, p.getY() - OFFSET);
		
		if (!wasMoved && !PieceS.blackRook.wasMoved) {
			for (Piece p : Piece.pieces) {
				if (p.p.getX() == OFFSET && p.p.getY() == 0) {
					canRochade = false;
				}
			}
			for (Piece p : Piece.pieces) {
				if (p.p.getX() == 100 && p.p.getY() == 0) {
					canRochade = false;
				}
			}
			if (canRochade) {
				renderDot(OFFSET, 0);
			}
		}
		if (!wasMoved && !PieceS.blackRook2.wasMoved) {
			for (Piece p : Piece.pieces) {
				if (p.p.getX() == 250 && p.p.getY() == 0) {
					canRochade2 = false;
				}
			}
			for (Piece p : Piece.pieces) {
				if (p.p.getX() == 300 && p.p.getY() == 0) {
					canRochade2 = false;
				}
			}
			for (Piece p : Piece.pieces) {
				if (p.p.getX() == 200 && p.p.getY() == 0) {
					canRochade2 = false;
				}
			}
			if (canRochade2) {
				renderDot(250, 0);
			}
		}
	}

}
