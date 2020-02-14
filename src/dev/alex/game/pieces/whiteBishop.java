package dev.alex.game.pieces;

import java.awt.Color;
import java.awt.image.BufferedImage;

import dev.alex.game.Game;
import dev.alex.game.gfx.chessGfx.Position;

public class whiteBishop extends whitePiece {

	public whiteBishop(BufferedImage img, Position p, int id) {
		super(img, p, id);
	}
	
	@Override
	public void makeDots() {
		Game.g.setColor(Color.red);
		//Diagonalen
		for(int x = p.getX(), Y = p.getY(); x < width && Y < height; x += 50) {
			renderDot(x, Y);
			Y += 50;
		}
		for(int x = p.getX(), Y = p.getY(); x > -50 && Y > -50; x -= 50) {
			renderDot(x, Y);
			Y -= 50;
		}
		for(int x = p.getX(), Y = p.getY(); x > -50 && Y < height; x -= 50) {
			renderDot(x, Y);
			Y += 50;
		}
		for(int x = p.getX(), Y = p.getY(); x < width && Y > -50; x += 50) {
			renderDot(x, Y);
			Y -= 50;
		}
	}

}
