package dev.alex.game.pieces;

import java.awt.Color;
import java.awt.image.BufferedImage;

import dev.alex.game.Game;
import dev.alex.game.gfx.chessGfx.Position;
import dev.alex.game.tile.Tile;

public class WhiteKnight extends WhitePiece {

	public WhiteKnight(BufferedImage img, Position p, int id) {
		super(img, p, id);
	}
	
	@Override
	public void makeDots() {
		Game.g.setColor(Color.red);
		renderDot(p.getX() + 2*Tile.rectSize, p.getY() + Tile.rectSize);
		renderDot(p.getX() + 2*Tile.rectSize, p.getY() - Tile.rectSize);
		
		renderDot(p.getX() - 2*Tile.rectSize, p.getY() + Tile.rectSize);
		renderDot(p.getX() - 2*Tile.rectSize, p.getY() - Tile.rectSize);
		
		renderDot(p.getX() + Tile.rectSize, p.getY() + 2*Tile.rectSize);
		renderDot(p.getX() - Tile.rectSize, p.getY() + 2*Tile.rectSize);
		
		renderDot(p.getX() + Tile.rectSize, p.getY() - 2*Tile.rectSize);
		renderDot(p.getX() - Tile.rectSize, p.getY() - 2*Tile.rectSize);
	}

}
