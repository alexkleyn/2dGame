package dev.alex.game.pieces;

import java.awt.*;
import java.awt.image.BufferedImage;

import dev.alex.game.Game;
import dev.alex.game.gfx.chessGfx.Position;
import dev.alex.game.tile.Tile;

public class Piece {

    public boolean sameTeam = false;
    public boolean isBlack;
    public Graphics g;
    public int width = 400;
    public int height = 400;
    private final int id;
    private BufferedImage imgBackup;
    private BufferedImage img;
    public Position p;
    private int backupX;
    private int backupY;
    long wait = System.nanoTime();
    long waitValue = System.nanoTime();
    public Rectangle bounds;
    protected String name = "";

    public static Piece[] pieces = new Piece[32];

    public Piece(BufferedImage img, Position p, int id) {
        this.p = p;
        backupX = p.getX();
        backupY = p.getY();
        this.img = img;
        imgBackup = img;
        this.id = id;
        pieces[id] = this;
        bounds = new Rectangle(p.getX(), p.getY(), 50, 50);
    }

    public void renderDot(int x, int y) {
        sameTeam = false;
        Game.g.fillOval(x + 20, y + 20, 10, 10);
        for (Tile t : Tile.tiles) {
            if (x == t.x && y == t.y) {
                for (Piece p : Piece.pieces) {
	                if (p.p.getX() == x && p.p.getY() == y && p.isBlack == this.isBlack) {
		                sameTeam = true;
	                }
                }
	            if (!sameTeam) {
		            t.enterable = true;
	            }
            }
        }
    }

    public void makeDots() {
    }

    public void deleteDots() {

    }

    public void tick() {
        moveUp();
        moveDown();
        moveLeft();
        moveRight();
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
        p.setX(500);
        p.setY(500);
        img = null;
    }


    public void moveUp() {
        waitValue = System.nanoTime();
        if (Game.km.up && p.getY() > 0 && waitValue - wait > 150000000) {
            int newY = p.getY() - 50;
            while (p.getY() > newY) {
                p.setY(p.getY() - 1);
                wait = System.nanoTime();
            }
        }
    }

    public void moveDown() {
        waitValue = System.nanoTime();
        if (Game.km.down && p.getY() < 350 && waitValue - wait > 150000000) {
            int newY = p.getY() + 50;
            while (p.getY() < newY) {
                p.setY(p.getY() + 1);
                wait = System.nanoTime();
            }
        }
    }

    public void moveRight() {
        waitValue = System.nanoTime();
        if (Game.km.right && p.getX() < 350 && waitValue - wait > 150000000) {
            int newX = p.getX() + 50;
	        while (p.getX() < newX) {
		        p.setX(p.getX() + 1);
	        }
            wait = System.nanoTime();
        }
    }

    public void moveLeft() {
        waitValue = System.nanoTime();
        if (Game.km.left && p.getX() > 0 && waitValue - wait > 150000000) {
            int newX = p.getX() - 50;
            while (p.getX() > newX) {
                p.setX(p.getX() - 1);
                wait = System.nanoTime();
            }
        }
    }

    public int getId() {
        return id;
    }

    public boolean isPieceObstructing(Piece piece, int x, int y) {
        for (Piece p : Piece.pieces) {
            if (p.p.getX() == x && p.p.getY() == y && p.getId() != piece.getId()) {
                //System.out.println("Piece found: " + piece.name + ":" + piece.getId());
                return true;
            }
        }
        return false;
    }
} //End of class
