package dev.alex.game.pieces;
import java.awt.Color;
import java.awt.image.BufferedImage;

import dev.alex.game.Game;
import dev.alex.game.gfx.chessGfx.Position;
import dev.alex.game.states.GameState;

public class whiteRook extends whitePiece {

	public whiteRook(BufferedImage img, Position p, int id) {
		super(img, p, id);
	}

	@Override
	public void makeDots() {
		Game.g.setColor(Color.red);
		for(int x = 0; x < width; x += 50)
			renderDot(x, p.getY());
		for(int y = 0; y < width; y+= 50)
			renderDot(p.getX(), y);
	}
}
