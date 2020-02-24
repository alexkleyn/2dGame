package dev.alex.game.tile;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import dev.alex.game.Game;
import dev.alex.game.Launcher;
import dev.alex.game.states.GameState;

public class Tile {
	
	public int x;
	public int y;
	private Color color;
	private final int id;
	public static int rectSize = 50;
	public static Color black = new Color(50, 50, 50);
	public static Color white = new Color(200, 200, 200);
	public boolean enterable;
	public Rectangle TileBounds;
	
	
	public static Tile[] tiles = new Tile[64];
	
	public Tile(int x, int y, Color color, int id) {
		enterable = false;
		this.x = x;
		this.y = y;
		this.color = color;
		this.id = id;
		TileBounds = new Rectangle(x, y, rectSize, rectSize);
		tiles[id] = this;
	}
	
	public int getId() {
		return id;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, rectSize, rectSize);
	}
}
