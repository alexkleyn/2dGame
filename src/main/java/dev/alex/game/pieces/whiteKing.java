package dev.alex.game.pieces;

import java.awt.Color;
import java.awt.image.BufferedImage;

import dev.alex.game.Game;
import dev.alex.game.gfx.chessGfx.Position;
import dev.alex.game.tile.TileS;

public class whiteKing extends whitePiece{
	
	
	public whiteKing(BufferedImage img, Position p, int id) {
		super(img, p, id);
	}
	
	@Override
	public void makeDots() {
		Game.g.setColor(Color.red);
		renderDot(p.getX() + 50, p.getY() + 50);
		renderDot(p.getX() + 50, p.getY());
		renderDot(p.getX() + 50, p.getY() - 50);
		
		renderDot(p.getX(), p.getY() + 50);
		renderDot(p.getX(), p.getY());
		renderDot(p.getX(), p.getY() - 50);
		
		renderDot(p.getX() - 50, p.getY() + 50);
		renderDot(p.getX() - 50, p.getY());
		renderDot(p.getX() - 50, p.getY() - 50);
		
		
		if (!wasMoved && !PieceS.whiteRook.wasMoved) {
			for (Piece p : Piece.pieces) {
				if (p.p.getX() == 50 && p.p.getY() == 350) {
					canRochade = false;
				}
			}
			for (Piece p : Piece.pieces) {
				if (p.p.getX() == 100 && p.p.getY() == 350) {
					canRochade = false;
				}
			}
			if (canRochade) {
				renderDot(50, 350);
			}
		}
		if (!wasMoved && !PieceS.whiteRook2.wasMoved) {
			for (Piece p : Piece.pieces) {
				if (p.p.getX() == 250 && p.p.getY() == 350) {
					canRochade2 = false;
				}
			}
			for (Piece p : Piece.pieces) {
				if (p.p.getX() == 300 && p.p.getY() == 350) {
					canRochade2 = false;
				}
			}
			for (Piece p : Piece.pieces) {
				if (p.p.getX() == 200 && p.p.getY() == 350) {
					canRochade2 = false;
				}
			}
			if (canRochade2) {
				renderDot(250, 350);
			}
		}
	}

}
