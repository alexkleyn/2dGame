package dev.alex.game.pieces;

import java.awt.*;
import java.awt.image.BufferedImage;

import dev.alex.game.Game;
import dev.alex.game.gfx.chessGfx.Position;
import dev.alex.game.tile.Tile;

public class BlackQueen extends BlackPiece {

    public BlackQueen(BufferedImage img, Position p, int id) {
        super(img, p, id);
    }

    @Override
    public void makeDots() {
        Game.g.setColor(Color.red);
        for(int x = this.p.getX(); x < width; x += Tile.rectSize) {
				renderDot(x, this.p.getY());
			if(isPieceObstructing(this, x, p.getY())) {
				break;
			}
		}
		for(int x = this.p.getX(); x > -Tile.rectSize; x -= Tile.rectSize) {
			renderDot(x, this.p.getY());
			if(isPieceObstructing(this, x, p.getY())) {
				break;
			}
		}
		
		
		for(int y = this.p.getY(); y < width; y+= Tile.rectSize) {
			renderDot(this.p.getX(), y);
			if(isPieceObstructing(this, p.getX(), y)) {
				break;
			}
		}
		for(int y = this.p.getY(); y > -Tile.rectSize; y-= Tile.rectSize) {
			renderDot(this.p.getX(), y);
			if(isPieceObstructing(this, p.getX(), y)) {
				break;
			}
		}

        //Diagonalen
        for (int x = p.getX(), Y = p.getY(); x < width && Y < height; x += Tile.rectSize) {
            renderDot(x, Y);
	        if(isPieceObstructing(this, x, Y)) {
		        break;
	        }
            Y += Tile.rectSize;
        }
        for (int x = p.getX(), Y = p.getY(); x > -Tile.rectSize && Y > -Tile.rectSize; x -= Tile.rectSize) {
            renderDot(x, Y);
	        if(isPieceObstructing(this, x, Y)) {
		        break;
	        }
            Y -= Tile.rectSize;
        }
        for (int x = p.getX(), Y = p.getY(); x > -Tile.rectSize && Y < height; x -= Tile.rectSize) {
            renderDot(x, Y);
	        if(isPieceObstructing(this, x, Y)) {
		        break;
	        }
            Y += Tile.rectSize;
        }
        for (int x = p.getX(), Y = p.getY(); x < width && Y > -Tile.rectSize; x += Tile.rectSize) {
            renderDot(x, Y);
	        if(isPieceObstructing(this, x, Y)) {
		        break;
	        }
            Y -= Tile.rectSize;
        }
    }
}
