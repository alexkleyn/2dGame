package dev.alex.game;

import dev.alex.game.tile.Tile;

public class Launcher {

	public static Game game = new Game("2dGame", 8*Tile.rectSize, 8*Tile.rectSize);
	
	public static void main (String[] args) {
		game.start();
	}
	
}
