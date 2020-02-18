package dev.alex.game.pieces;

import java.awt.*;
import java.awt.image.BufferedImage;

import dev.alex.game.Game;
import dev.alex.game.gfx.chessGfx.Position;

public class BlackQueen extends BlackPiece {

    public BlackQueen(BufferedImage img, Position p, int id) {
        super(img, p, id);
    }

    @Override
    public void makeDots() {
        Game.g.setColor(Color.red);
        for(int x = this.p.getX(); x < width; x += OFFSET) {
				renderDot(x, this.p.getY());
			if(isPieceObstructing(this, x, p.getY())) {
				break;
			}
		}
		for(int x = this.p.getX(); x > -OFFSET; x -= OFFSET) {
			renderDot(x, this.p.getY());
			if(isPieceObstructing(this, x, p.getY())) {
				break;
			}
		}
		
		
		for(int y = this.p.getY(); y < width; y+= OFFSET) {
			renderDot(this.p.getX(), y);
			if(isPieceObstructing(this, p.getX(), y)) {
				break;
			}
		}
		for(int y = this.p.getY(); y > -OFFSET; y-= OFFSET) {
			renderDot(this.p.getX(), y);
			if(isPieceObstructing(this, p.getX(), y)) {
				break;
			}
		}

        //Diagonalen
        for (int x = p.getX(), Y = p.getY(); x < width && Y < height; x += OFFSET) {
            renderDot(x, Y);
	        if(isPieceObstructing(this, x, Y)) {
		        break;
	        }
            Y += OFFSET;
        }
        for (int x = p.getX(), Y = p.getY(); x > -OFFSET && Y > -OFFSET; x -= OFFSET) {
            renderDot(x, Y);
	        if(isPieceObstructing(this, x, Y)) {
		        break;
	        }
            Y -= OFFSET;
        }
        for (int x = p.getX(), Y = p.getY(); x > -OFFSET && Y < height; x -= OFFSET) {
            renderDot(x, Y);
	        if(isPieceObstructing(this, x, Y)) {
		        break;
	        }
            Y += OFFSET;
        }
        for (int x = p.getX(), Y = p.getY(); x < width && Y > -OFFSET; x += OFFSET) {
            renderDot(x, Y);
	        if(isPieceObstructing(this, x, Y)) {
		        break;
	        }
            Y -= OFFSET;
        }
    }
}
