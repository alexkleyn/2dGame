package dev.alex.game.pieces;

import java.awt.*;
import java.awt.image.BufferedImage;

import dev.alex.game.Game;
import dev.alex.game.gfx.chessGfx.Position;

public class whiteRook extends whitePiece {

    public whiteRook(BufferedImage img, Position p, int id) {
        super(img, p, id);
    }

    @Override
    public void makeDots() {
        Game.g.setColor(Color.red);
        for (int x = this.p.getX(); x < width; x += 50) {
            renderDot(x, this.p.getY());
            if (isPieceObstructing(this, x, p.getY())) {
                break;
            }
        }
        for (int x = this.p.getX(); x > -50; x -= 50) {
            renderDot(x, this.p.getY());
	        if(isPieceObstructing(this, x, p.getY())) {
		        break;
	        }
        }


        for (int y = this.p.getY(); y < width; y += 50) {
            renderDot(this.p.getX(), y);
	        if(isPieceObstructing(this, p.getX(), y)) {
		        break;
	        }
        }
        for (int y = this.p.getY(); y > -50; y -= 50) {
            renderDot(this.p.getX(), y);
	        if(isPieceObstructing(this, p.getX(), y)) {
		        break;
	        }
        }
    }
}
