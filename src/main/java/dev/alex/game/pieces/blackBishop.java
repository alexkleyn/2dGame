package dev.alex.game.pieces;

import java.awt.Color;
import java.awt.image.BufferedImage;

import dev.alex.game.Game;
import dev.alex.game.gfx.chessGfx.Position;
import dev.alex.game.tile.Tile;

public class BlackBishop extends BlackPiece {

	public BlackBishop(BufferedImage img, Position p, int id) {
		super(img, p, id);
	}

	@Override
	public void makeDots() {
		Game.g.setColor(Color.red);
		//Diagonalen
		//Unten rechts
		for(int x = p.getX() + Tile.rectSize, Y = p.getY() + Tile.rectSize; x < width && Y < height; x += Tile.rectSize) {
			renderDot(x, Y);
			if(isPieceObstructing(this, x, Y)) {
				break;
			}
			Y += Tile.rectSize;
		}
		//Oben links
		for(int x = p.getX() - Tile.rectSize, Y = p.getY() -Tile.rectSize; x > -Tile.rectSize && Y > -Tile.rectSize; x -= Tile.rectSize) {
			renderDot(x, Y);
			if(isPieceObstructing(this, x, Y)) {
				break;
			}
			Y -= Tile.rectSize;
		}
		//Unten links
		for(int x = p.getX() - Tile.rectSize, Y = p.getY() + Tile.rectSize; x > -Tile.rectSize && Y < height; x -= Tile.rectSize) {
			renderDot(x, Y);
			if(isPieceObstructing(this, x, Y)) {
				break;
			}
			Y += Tile.rectSize;
		}
		//Oben rechts
		for(int x = p.getX() + Tile.rectSize, Y = p.getY() - Tile.rectSize; x < width && Y > -Tile.rectSize; x += Tile.rectSize) {
			renderDot(x, Y);
			if(isPieceObstructing(this, x, Y)) {
				break;
			}
			Y -= Tile.rectSize;
		}
	}
}
