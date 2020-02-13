package dev.alex.game.tile;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import dev.alex.game.Game;
import dev.alex.game.Launcher;
import dev.alex.game.states.GameState;

public class Tile {
	
	private Color color;
	private final int id;
	public static int rectSize = 50;
	private static Color black = new Color(50, 50, 50);
	private static Color white = new Color(200, 200, 200);
	
	public Rectangle bounds;
	
	
	public static Tile[] tiles = new Tile[64];
	
	public static Tile blackTile = new Tile(black, 0);
	public static Tile whiteTile = new Tile(white, 1);
	
	public Tile(Color color, int id) {
		this.color = color;
		this.id = id;
		tiles[id] = this;
	}
	
	public int getId() {
		return id;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g, int x, int y) {
		g.setColor(color);
		g.fillRect(x, y, rectSize, rectSize);
	}
}
