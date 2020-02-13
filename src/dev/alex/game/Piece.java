package dev.alex.game;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import dev.alex.game.gfx.chessGfx.ImgS;
import dev.alex.game.gfx.chessGfx.Position;
import dev.alex.game.states.GameState;

public class Piece {
	
	public Graphics g;
	
	private final int id;
	private BufferedImage imgBackup;
	private BufferedImage img;
	public Position p;
	private int backupX;
	private int backupY;
	long wait = System.nanoTime();
	long waitValue = System.nanoTime();
	public Rectangle bounds;
	
	public static Piece[] pieces = new Piece[32];
	
	public Piece (BufferedImage img, Position p, int id) {
		this.p = p;
		backupX = p.getX();
		backupY = p.getY();
		this.img = img;
		imgBackup = img;
		this.id = id;
		pieces[id] = this;
		bounds = new Rectangle(p.getX(), p.getY(), 50, 50);
	}
	
	public void tick() {
		moveUp();
		moveDown();
		moveLeft();
		moveRight();
		delete();
		create();
	}
	
	public void render() {
		bounds.setLocation(p.getX(), p.getY());
		Game.g.drawImage(img, p.getX(), p.getY(), null);
	}
	
	public void create() {
		if (Game.km.c) {
			img = imgBackup;
			p.setY(backupY);
			p.setX(backupX);
		}
	}
	
	public void delete() {
		if (Game.km.del) {
			img = null;
		}
	}
	
	
	public void moveUp() {
		waitValue = System.nanoTime();
		if (Game.km.up && p.getY() > 0 && waitValue - wait > 150000000) {
			int newY = p.getY() - 50;
			while (p.getY() > newY) {
				p.setY(p.getY() - 1);
				wait = System.nanoTime();
	}}}
	
	public void moveDown() {
		waitValue = System.nanoTime();
		if (Game.km.down && p.getY() < 350 && waitValue - wait > 150000000) {
			int newY = p.getY() + 50;
			while (p.getY() < newY) {
				p.setY(p.getY() + 1);
				wait = System.nanoTime();
	}}}
	
	public void moveRight() {
		waitValue = System.nanoTime();
		if (Game.km.right && p.getX() < 350 && waitValue - wait > 150000000) {
			int newX = p.getX() + 50;
			while (p.getX() < newX)
				p.setX(p.getX() + 1);
				wait = System.nanoTime();
	}}
	
	public void moveLeft() {
		waitValue = System.nanoTime();
		if (Game.km.left && p.getX() > 0 && waitValue - wait > 150000000) {
			int newX = p.getX() - 50;
			while (p.getX() > newX) {
				p.setX(p.getX() - 1);
				wait = System.nanoTime();
	}}}
	
	public int getId() {
		return id;
	}
} //End of class
