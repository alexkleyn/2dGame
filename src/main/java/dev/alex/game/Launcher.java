package dev.alex.game;

public class Launcher {

	public static Game game1;
	
	public static void main (String[] args) {
		Game game = new Game("2dGame", 400, 400);
		game1 = game;
		game.start();
	}
	
}
