package dev.alex.game.pieces;

import dev.alex.game.tile.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import dev.alex.game.Game;
import dev.alex.game.gfx.chessGfx.Position;
import dev.alex.game.tile.Tile;

public class Piece {

	public boolean canRochade2 = true;
	public boolean canRochade = true;
	public boolean wasMoved = false;
    public boolean sameTeam = false;
    public boolean isBlack;
    public Graphics g;
    public int width = 8*Tile.rectSize;
    public int height = 8*Tile.rectSize;
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
        bounds = new Rectangle(p.getX(), p.getY(), Tile.rectSize, Tile.rectSize);
    }

    public void renderDot(int x, int y) {
        sameTeam = false;
        Game.g.fillOval(x + (Tile.rectSize/5)*2, y + (Tile.rectSize/5)*2, Tile.rectSize/5, Tile.rectSize/5);
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
        p.setX(10*Tile.rectSize);
        p.setY(10*Tile.rectSize);
        img = null;
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
