package dev.alex.game.pieces;

import java.awt.Color;
import java.awt.image.BufferedImage;

import dev.alex.game.Game;
import dev.alex.game.gfx.chessGfx.Position;
import dev.alex.game.tile.Tile;
import dev.alex.game.tile.TileS;

public class WhiteKing extends WhitePiece{
	
	
	public WhiteKing(BufferedImage img, Position p, int id) {
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
		
		
		if (!wasMoved && !PieceS.whiteRook.wasMoved) {
			for (Piece p : Piece.pieces) {
				if (p.p.getX() == Tile.rectSize && p.p.getY() == 7*Tile.rectSize) {
					canRochade = false;
				}
			}
			for (Piece p : Piece.pieces) {
				if (p.p.getX() == 2*Tile.rectSize && p.p.getY() == 7*Tile.rectSize) {
					canRochade = false;
				}
			}
			if (canRochade) {
				renderDot(Tile.rectSize, 7*Tile.rectSize);
			}
		}
		if (!wasMoved && !PieceS.whiteRook2.wasMoved) {
			for (Piece p : Piece.pieces) {
				if (p.p.getX() == 5*Tile.rectSize && p.p.getY() == 7*Tile.rectSize) {
					canRochade2 = false;
				}
			}
			for (Piece p : Piece.pieces) {
				if (p.p.getX() == 6*Tile.rectSize && p.p.getY() == 7*Tile.rectSize) {
					canRochade2 = false;
				}
			}
			for (Piece p : Piece.pieces) {
				if (p.p.getX() == 4*Tile.rectSize && p.p.getY() == 7*Tile.rectSize) {
					canRochade2 = false;
				}
			}
			if (canRochade2) {
				renderDot(5*Tile.rectSize, 7*Tile.rectSize);
			}
		}
	}

}
