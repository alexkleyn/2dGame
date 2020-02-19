package dev.alex.game.pieces;

import java.awt.*;
import java.awt.image.BufferedImage;

import dev.alex.game.Game;
import dev.alex.game.gfx.chessGfx.Position;
import dev.alex.game.tile.Tile;

public class WhiteRook extends WhitePiece {

    public WhiteRook(BufferedImage img, Position p, int id) {
        super(img, p, id);
    }

    @Override
    public void makeDots() {
        Game.g.setColor(Color.red);
        for (int x = this.p.getX(); x < width; x += Tile.rectSize) {
            renderDot(x, this.p.getY());
            if (isPieceObstructing(this, x, p.getY())) {
                break;
            }
        }
        for (int x = this.p.getX(); x > -Tile.rectSize; x -= Tile.rectSize) {
            renderDot(x, this.p.getY());
	        if(isPieceObstructing(this, x, p.getY())) {
		        break;
	        }
        }


        for (int y = this.p.getY(); y < width; y += Tile.rectSize) {
            renderDot(this.p.getX(), y);
	        if(isPieceObstructing(this, p.getX(), y)) {
		        break;
	        }
        }
        for (int y = this.p.getY(); y > -Tile.rectSize; y -= Tile.rectSize) {
            renderDot(this.p.getX(), y);
	        if(isPieceObstructing(this, p.getX(), y)) {
		        break;
	        }
        }
    }
}
