package dev.alex.game.pieces;

import java.awt.Color;
import java.awt.image.BufferedImage;

import dev.alex.game.Game;
import dev.alex.game.gfx.chessGfx.Position;


public class whitePawn extends whitePiece {

	public whitePawn(BufferedImage img, Position p, int id) {
		super(img, p, id);
	}
	
	@Override
	public void makeDots() {
		boolean isOccupied = false;
		boolean isOccupied2 = false;
		Game.g.setColor(Color.red);
		for(Piece p : Piece.pieces) {
			if(p.p.getX() == this.p.getX() - 50 && p.p.getY() == this.p.getY() - 50 && p.isBlack != this.isBlack) {
				renderDot(this.p.getX() - 50, this.p.getY() - 50);
			}
			if(p.p.getX() == this.p.getX() + 50 && p.p.getY() == this.p.getY() - 50 && p.isBlack != this.isBlack) {
				renderDot(this.p.getX() + 50, this.p.getY() - 50);
			}
			if(this.p.getX() == p.p.getX() && this.p.getY() - 50 == p.p.getY()) {
				isOccupied = true;
			}
			if(this.p.getX() == p.p.getX() && this.p.getY() - 100 == p.p.getY()) {
				isOccupied2 = true;
			}
		}
		if(!isOccupied)
			renderDot(p.getX(), p.getY() - 50);
		if(p.getY() == 300 && !isOccupied2 && !isOccupied)
			renderDot(p.getX(), p.getY() - 100);
		isOccupied = false;
		isOccupied2 = false;
	}

}
