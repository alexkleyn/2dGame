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
		//Unten rechts
		for(int x = p.getX() + 50, Y = p.getY() + 50; x < width && Y < height; x += 50) {
			renderDot(x, Y);
			if(isPieceObstructing(this, x, Y)) {
				break;
			}
			Y += 50;
		}
		//Oben links
		for(int x = p.getX() - 50, Y = p.getY() - 50; x > -50 && Y > -50; x -= 50) {
			renderDot(x, Y);
			if(isPieceObstructing(this, x, Y)) {
				break;
			}
			Y -= 50;
		}
		//Unten links
		for(int x = p.getX() - 50, Y = p.getY() + 50; x > -50 && Y < height; x -= 50) {
			renderDot(x, Y);
			if(isPieceObstructing(this, x, Y)) {
				break;
			}
			Y += 50;
		}
		//Oben rechts
		for(int x = p.getX() + 50, Y = p.getY() - 50; x < width && Y > -50; x += 50) {
			renderDot(x, Y);
			if(isPieceObstructing(this, x, Y)) {
				break;
			}
			Y -= 50;
		}
	}
}
