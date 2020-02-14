package dev.alex.game.pieces;

import java.awt.Color;
import java.awt.image.BufferedImage;

import dev.alex.game.Game;
import dev.alex.game.gfx.chessGfx.Position;

public class blackPawn extends blackPiece {

	public blackPawn(BufferedImage img, Position p, int id) {
		super(img, p, id);
	}
	
	@Override
	public void makeDots() {
		Game.g.setColor(Color.red);
		renderDot(p.getX(), p.getY() + 50);
		if (p.getY() == 50)
			renderDot(p.getX(), p.getY() + 100);
	}

}
