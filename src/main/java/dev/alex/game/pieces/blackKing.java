package dev.alex.game.pieces;

import java.awt.Color;
import java.awt.image.BufferedImage;

import dev.alex.game.Game;
import dev.alex.game.gfx.chessGfx.Position;

public class blackKing extends blackPiece{

	public blackKing(BufferedImage img, Position p, int id) {
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
	}

}
