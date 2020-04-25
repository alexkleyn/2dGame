package dev.alex.game.pieces;

import java.awt.image.BufferedImage;

import dev.alex.game.gfx.chessGfx.Position;

public abstract class BlackPiece extends Piece{

	public BlackPiece(BufferedImage img, Position p, int id) {
		super(img, p, id);
		isBlack = true;
		Piece.blackPieces[id] = this;
	}
	
	

}
