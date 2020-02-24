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
		renderDotKing(p.getX() + Tile.rectSize, p.getY() + Tile.rectSize);
		renderDotKing(p.getX() + Tile.rectSize, p.getY());
		renderDotKing(p.getX() + Tile.rectSize, p.getY() - Tile.rectSize);
		
		renderDotKing(p.getX(), p.getY() + Tile.rectSize);
		renderDotKing(p.getX(), p.getY());
		renderDotKing(p.getX(), p.getY() - Tile.rectSize);
		
		renderDotKing(p.getX() - Tile.rectSize, p.getY() + Tile.rectSize);
		renderDotKing(p.getX() - Tile.rectSize, p.getY());
		renderDotKing(p.getX() - Tile.rectSize, p.getY() - Tile.rectSize);
		
		
		if (!wasMoved && !PieceS.whiteRook.wasMoved) {
			for (Piece p : Piece.pieces) {
				if (p.p.getX() == Tile.rectSize && p.p.getY() == 7*Tile.rectSize) {
					canRochadeLeft = false;
				}
			}
			for (Piece p : Piece.pieces) {
				if (p.p.getX() == 2*Tile.rectSize && p.p.getY() == 7*Tile.rectSize) {
					canRochadeLeft = false;
				}
			}
			if (canRochadeLeft) {
				renderDotKing(Tile.rectSize, 7*Tile.rectSize);
			}
		}
		if (!wasMoved && !PieceS.whiteRook2.wasMoved) {
			for (Piece p : Piece.pieces) {
				if (p.p.getX() == 5*Tile.rectSize && p.p.getY() == 7*Tile.rectSize) {
					canRochadeRight = false;
				}
			}
			for (Piece p : Piece.pieces) {
				if (p.p.getX() == 6*Tile.rectSize && p.p.getY() == 7*Tile.rectSize) {
					canRochadeRight = false;
				}
			}
			for (Piece p : Piece.pieces) {
				if (p.p.getX() == 4*Tile.rectSize && p.p.getY() == 7*Tile.rectSize) {
					canRochadeRight = false;
				}
			}
			if (canRochadeRight) {
				renderDotKing(5*Tile.rectSize, 7*Tile.rectSize);
			}
		}
	}

}
