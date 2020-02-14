package dev.alex.game.pieces;

import java.awt.Color;
import java.awt.image.BufferedImage;

import dev.alex.game.Game;
import dev.alex.game.gfx.chessGfx.Position;
import dev.alex.game.tile.Tile;

public class blackBishop extends blackPiece {

	public blackBishop(BufferedImage img, Position p, int id) {
		super(img, p, id);
	}
	
	@Override
	public void makeDots() {
		Game.g.setColor(Color.red);
		//Diagonalen
		for(int x = p.getX(), y = p.getY(); x < width && y < height; x += 50) {
			renderDot(x, y);
			y += 50;
		}
		
		for(int x = p.getX(), y = p.getY(); x > -50 && y > -50; x -= 50) {
			renderDot(x, y);
			y -= 50;
		}
		for(int x = p.getX(), y = p.getY(); x > -50 && y < height; x -= 50) {
			renderDot(x, y);
			y += 50;
		}
		for(int x = p.getX(), y = p.getY(); x < width && y > -50; x += 50) {
			renderDot(x, y);
			y -= 50;
		}
	}

}
