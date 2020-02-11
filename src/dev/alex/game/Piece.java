package dev.alex.game;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import dev.alex.game.gfx.chessGfx.Position;

public class Piece {
	
	public Graphics g;
	
	private BufferedImage img;
	public Position p;
	
	public Piece (BufferedImage img, Position p) {
		this.p = p;
		this.img = img;
	}
	
	public void draw() {
		Game.g.drawImage(img, p.getX(), p.getY(), null);
	}
	
}
