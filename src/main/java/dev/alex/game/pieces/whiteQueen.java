package dev.alex.game.pieces;

import java.awt.*;
import java.awt.image.BufferedImage;

import dev.alex.game.Game;
import dev.alex.game.gfx.chessGfx.Position;

public class whiteQueen extends whitePiece {

    public whiteQueen(BufferedImage img, Position p, int id) {
        super(img, p, id);
    }

	@Override
	public void makeDots() {
		Game.g.setColor(Color.red);
		for (int x = 0; x < width; x += 50) {
			renderDot(x, p.getY());
			if (isPieceObstructing(this, x, p.getY())) {
				break;
			}
		}


		for (int y = 0; y < width; y += 50) {
			renderDot(p.getX(), y);
			if(isPieceObstructing(this, p.getX(), y)) {
				break;
			}
		}

		//Diagonalen
		for (int x = p.getX(), Y = p.getY(); x < width && Y < height; x += 50) {
			renderDot(x, Y);
			if(isPieceObstructing(this, x, Y)) {
				break;
			}
			Y += 50;
		}
		for (int x = p.getX(), Y = p.getY(); x > -50 && Y > -50; x -= 50) {
			renderDot(x, Y);
			if(isPieceObstructing(this, x, Y)) {
				break;
			}
			Y -= 50;
		}
		for (int x = p.getX(), Y = p.getY(); x > -50 && Y < height; x -= 50) {
			renderDot(x, Y);
			if(isPieceObstructing(this, x, Y)) {
				break;
			}
			Y += 50;
		}
		for (int x = p.getX(), Y = p.getY(); x < width && Y > -50; x += 50) {
			renderDot(x, Y);
			if(isPieceObstructing(this, x, Y)) {
				break;
			}
			Y -= 50;
		}
	}
}
