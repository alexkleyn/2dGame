package dev.alex.game.pieces;

import java.awt.Color;
import java.awt.image.BufferedImage;

import dev.alex.game.Game;
import dev.alex.game.gfx.chessGfx.Position;

public class BlackBishop extends BlackPiece {

	public BlackBishop(BufferedImage img, Position p, int id) {
		super(img, p, id);
	}

	@Override
	public void makeDots() {
		Game.g.setColor(Color.red);
		//Diagonalen
		//Unten rechts
		for(int x = p.getX() + OFFSET, Y = p.getY() + OFFSET; x < width && Y < height; x += OFFSET) {
			renderDot(x, Y);
			if(isPieceObstructing(this, x, Y)) {
				break;
			}
			Y += OFFSET;
		}
		//Oben links
		for(int x = p.getX() - OFFSET, Y = p.getY() - OFFSET; x > -OFFSET && Y > -OFFSET; x -= OFFSET) {
			renderDot(x, Y);
			if(isPieceObstructing(this, x, Y)) {
				break;
			}
			Y -= OFFSET;
		}
		//Unten links
		for(int x = p.getX() - OFFSET, Y = p.getY() + OFFSET; x > -OFFSET && Y < height; x -= OFFSET) {
			renderDot(x, Y);
			if(isPieceObstructing(this, x, Y)) {
				break;
			}
			Y += OFFSET;
		}
		//Oben rechts
		for(int x = p.getX() + OFFSET, Y = p.getY() - OFFSET; x < width && Y > -OFFSET; x += OFFSET) {
			renderDot(x, Y);
			if(isPieceObstructing(this, x, Y)) {
				break;
			}
			Y -= OFFSET;
		}
	}
}
