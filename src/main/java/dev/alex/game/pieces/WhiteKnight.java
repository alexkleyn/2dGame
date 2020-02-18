package dev.alex.game.pieces;

import java.awt.Color;
import java.awt.image.BufferedImage;

import dev.alex.game.Game;
import dev.alex.game.gfx.chessGfx.Position;

public class WhiteKnight extends WhitePiece {

	public WhiteKnight(BufferedImage img, Position p, int id) {
		super(img, p, id);
	}
	
	@Override
	public void makeDots() {
		Game.g.setColor(Color.red);
		renderDot(p.getX() + 100, p.getY() + OFFSET);
		renderDot(p.getX() + 100, p.getY() - OFFSET);
		
		renderDot(p.getX() - 100, p.getY() + OFFSET);
		renderDot(p.getX() - 100, p.getY() - OFFSET);
		
		renderDot(p.getX() + OFFSET, p.getY() + 100);
		renderDot(p.getX() - OFFSET, p.getY() + 100);
		
		renderDot(p.getX() + OFFSET, p.getY() - 100);
		renderDot(p.getX() - OFFSET, p.getY() - 100);
	}

}
