package dev.alex.game.pieces;
import java.awt.Color;
import java.awt.image.BufferedImage;

import dev.alex.game.Game;
import dev.alex.game.gfx.chessGfx.Position;
import dev.alex.game.states.GameState;
import dev.alex.game.tile.Tile;

public class BlackRook extends BlackPiece {

	public BlackRook(BufferedImage img, Position p, int id) {
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
	}
	
	public void loadEnterableTiles() {
		resetEnterableTiles();
		for(int x = this.p.getX(); x < width; x += Tile.rectSize) {
			addEnterableTile(x, this.p.getY());
			if(isPieceObstructing(this, x, p.getY())) {
				break;
			}
		}
		for(int x = this.p.getX(); x > -Tile.rectSize; x -= Tile.rectSize) {
			addEnterableTile(x, this.p.getY());
			if(isPieceObstructing(this, x, p.getY())) {
				break;
			}
		}
		
		
		for(int y = this.p.getY(); y < width; y+= Tile.rectSize) {
			addEnterableTile(this.p.getX(), y);
			if(isPieceObstructing(this, p.getX(), y)) {
				break;
			}
		}
		for(int y = this.p.getY(); y > -Tile.rectSize; y-= Tile.rectSize) {
			addEnterableTile(this.p.getX(), y);
			if(isPieceObstructing(this, p.getX(), y)) {
				break;
			}
		}
	}
}
