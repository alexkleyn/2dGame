package dev.alex.game.pieces;

import java.awt.Color;
import java.awt.image.BufferedImage;

import dev.alex.game.Game;
import dev.alex.game.gfx.chessGfx.ImgS;
import dev.alex.game.gfx.chessGfx.Position;
import dev.alex.game.tile.Tile;


public class WhitePawn extends WhitePiece {

	public WhitePawn(BufferedImage img, Position p, int id) {
		super(img, p, id);
		isPawn = true;
	}
	
	@Override
	public void makeDots() {
		boolean isOccupied = false;
		boolean isOccupied2 = false;
		Game.g.setColor(Color.red);
		for(Piece p : Piece.pieces) {
			if(p.p.getX() == this.p.getX() - Tile.rectSize && p.p.getY() == this.p.getY() - Tile.rectSize && p.isBlack != this.isBlack) {
				renderDot(this.p.getX() - Tile.rectSize, this.p.getY() - Tile.rectSize);
			}
			if(p.p.getX() == this.p.getX() + Tile.rectSize && p.p.getY() == this.p.getY() - Tile.rectSize && p.isBlack != this.isBlack) {
				renderDot(this.p.getX() + Tile.rectSize, this.p.getY() - Tile.rectSize);
			}
			if(this.p.getX() == p.p.getX() && this.p.getY() - Tile.rectSize == p.p.getY()) {
				isOccupied = true;
			}
			if(this.p.getX() == p.p.getX() && this.p.getY() - 2*Tile.rectSize == p.p.getY()) {
				isOccupied2 = true;
			}
		}
		if(!isOccupied)
			renderDot(p.getX(), p.getY() - Tile.rectSize);
		if(p.getY() == 6*Tile.rectSize && !isOccupied2 && !isOccupied)
			renderDot(p.getX(), p.getY() - 2*Tile.rectSize);
		isOccupied = false;
		isOccupied2 = false;
	}

}
