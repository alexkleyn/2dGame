package dev.alex.game.pieces;

import java.awt.*;
import java.awt.image.BufferedImage;
import dev.alex.game.Game;
import dev.alex.game.Launcher;
import dev.alex.game.gfx.chessGfx.Position;
import dev.alex.game.states.GameState;
import dev.alex.game.tile.Tile;

public abstract class Piece {

	protected String makeDotsOf = "pawn";
	public boolean canRochadeRight = true;
	public boolean canRochadeLeft = true;
	public boolean wasMoved = false;
	public boolean sameTeam = false;
	public boolean isBlack;
	public Graphics g;
	public int width = 8 * Tile.rectSize;
	public int height = 8 * Tile.rectSize;
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
	public boolean isPawn = false;
	public boolean tileEnterableForKing = true;

	public boolean[][] enterableTiles = new boolean[Tile.rectSize*8][Tile.rectSize*8];

	public static Piece[] pieces = new Piece[32];
	public static Piece[] blackPieces = new Piece[32];
	public static Piece[] whitePieces = new Piece[32];

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

	public void resetEnterableTiles() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				enterableTiles[i][j] = false;
			}
		}
	}

	public void addEnterableTile(int x, int y) {
		if (x >= 0 && x <= Tile.rectSize*8-1 && y >= 0 && y <= Tile.rectSize*8-1)
		enterableTiles[x][y] = true;
	}

	public void removeEnterableTile(int x, int y) {
		enterableTiles[x][y] = false;
	}

	public void renderDot(int x, int y) {
		sameTeam = false;
		for (Tile t : Tile.tiles) {
			if (x == t.x && y == t.y) {
				for (Piece p : Piece.pieces) {
					if (p.p.getX() == x && p.p.getY() == y && p.isBlack == this.isBlack) {
						sameTeam = true;
					}
				}
				if (!sameTeam) {
					t.enterable = true;
					Game.g.fillOval(x + (Tile.rectSize / 5) * 2, y + (Tile.rectSize / 5) * 2, Tile.rectSize / 5,
							Tile.rectSize / 5);
				}
			}
		}
	}

	public abstract void loadEnterableTiles();

	public void renderDotKing(int x, int y) {
		tileEnterableForKing = true;
		sameTeam = false;
		for (Tile t : Tile.tiles) {
			if (x == t.x && y == t.y) {
				for (Piece p : Piece.pieces) {
					p.resetEnterableTiles();
					if (p.p.getX() == x && p.p.getY() == y && p.isBlack == this.isBlack) {
						sameTeam = true;
					}
				}
				if (this.isBlack) {
					for (Piece p : Piece.whitePieces) {
						if (p != null) {
							p.loadEnterableTiles();
							if (p.enterableTiles[x][y]) {
								tileEnterableForKing = false;
								p.resetEnterableTiles();
							}
						}
					}
				} else {
					for (Piece p : Piece.blackPieces) {
						if (p != null) {
							p.loadEnterableTiles();
							if (p.enterableTiles[x][y]) {
								tileEnterableForKing = false;
								p.resetEnterableTiles();
							}
						}
					}
				}
				if (!sameTeam && tileEnterableForKing) {

					t.enterable = true;
					Game.g.fillOval(x + (Tile.rectSize / 5) * 2, y + (Tile.rectSize / 5) * 2, Tile.rectSize / 5,
							Tile.rectSize / 5);
				}
			}
		}
	}

	public void makeDots() {
	}

	public void deleteDots() {
		for (Tile t : Tile.tiles) {
			t.enterable = false;
		}
		GameState.makeDots = false;
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
		p.setX(100 * Tile.rectSize);
		p.setY(100 * Tile.rectSize);
		img = null;
	}

	public int getId() {
		return id;
	}

	public void setImg(BufferedImage img) {
		this.img = img;
	}

	public BufferedImage getImg() {
		return img;
	}

	public boolean isPieceObstructing(Piece piece, int x, int y) {
		for (Piece p : Piece.pieces) {
			if (p.p.getX() == x && p.p.getY() == y && p.getId() != piece.getId()) {
				// System.out.println("Piece found: " + piece.name + ":" + piece.getId());
				return true;
			}
		}
		return false;
	}

	public String getMakeDotsOf() {
		return makeDotsOf;
	}

	public void setMakeDotsOf(String s) {
		makeDotsOf = s;
	}
} // End of class
