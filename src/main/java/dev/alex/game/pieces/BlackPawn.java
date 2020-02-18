package dev.alex.game.pieces;

import java.awt.Color;
import java.awt.image.BufferedImage;

import dev.alex.game.Game;
import dev.alex.game.gfx.chessGfx.Position;

public class BlackPawn extends BlackPiece {

	public BlackPawn(BufferedImage img, Position p, int id) {
		super(img, p, id);
	}
	
	@Override
	public void makeDots() {
		boolean isOccupied = false;
		boolean isOccupied2 = false;
		Game.g.setColor(Color.red);
		for(Piece p : Piece.pieces) {
			if(p.p.getX() == this.p.getX() - OFFSET && p.p.getY() == this.p.getY() + OFFSET && p.isBlack != this.isBlack) {
				renderDot(this.p.getX() - OFFSET, this.p.getY() + OFFSET);
			}
			if(p.p.getX() == this.p.getX() + OFFSET && p.p.getY() == this.p.getY() + OFFSET && p.isBlack != this.isBlack) {
				renderDot(this.p.getX() + OFFSET, this.p.getY() + OFFSET);
			}
			if(this.p.getX() == p.p.getX() && this.p.getY() + OFFSET == p.p.getY()) {
				isOccupied = true;
			}
			if(this.p.getX() == p.p.getX() && this.p.getY() + 100 == p.p.getY()) {
				isOccupied2 = true;
			}
		}
		if (!isOccupied)
			renderDot(p.getX(), p.getY() + OFFSET);
		if (p.getY() == OFFSET && !isOccupied2 && !isOccupied)
			renderDot(p.getX(), p.getY() + 100);
		isOccupied = false;
		isOccupied2 = false;
	}

}
