package dev.alex.game.pieces;

import java.awt.image.BufferedImage;

import dev.alex.game.gfx.chessGfx.Position;

public class whitePiece extends Piece{

	
	public whitePiece(BufferedImage img, Position p, int id) {
		super(img, p, id);
		isBlack = false;
		// TODO Auto-generated constructor stub
	}

}
