package dev.alex.game.pieces;

import java.awt.image.BufferedImage;

import dev.alex.game.gfx.chessGfx.Position;

public abstract class WhitePiece extends Piece{

	
	public WhitePiece(BufferedImage img, Position p, int id) {
		super(img, p, id);
		isBlack = false;
		Piece.whitePieces[id] = this;
	}

	

}
