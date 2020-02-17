package dev.alex.game;

public class Launcher {

	public static Game game = new Game("2dGame", 400, 400);
	
	public static void main (String[] args) {
		game.start();
	}
	
}
