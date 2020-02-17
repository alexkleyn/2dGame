package dev.alex.game.states;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import dev.alex.game.Game;
import dev.alex.game.gfx.chessGfx.ImgS;
import dev.alex.game.input.MouseManager;

public class MenuState extends State {

	public int width;
	public int height;
	public Graphics g;
	public Rectangle gameStartBounds = new Rectangle(50, 180, 300, 50);
	public Rectangle settingsBounds = new Rectangle(50, 280, 300, 50);
	
	public MenuState(int width, int height, Game game) {
		super(game);
		this.width = width;
		this.height = height;
	}
	
	public void tick() {
		if (Game.mm.getLeftPressed() && Game.mm.getRightPressed()) {
			StateManager.setState(game.gameState);
		}
		if (gameStartBounds.contains(Game.mm.getMouseX(), Game.mm.getMouseY()) && Game.mm.getLeftPressed()) {
			StateManager.setState(game.gameState);
		}
		if (settingsBounds.contains(Game.mm.getMouseX(), Game.mm.getMouseY()) && Game.mm.getLeftPressed()) {
			StateManager.setState(game.settingsState);
		}
	}
	
	public void render(Graphics g) {
		g.drawImage(ImgS.gameStartBlock, 50, 180, null);
		g.drawImage(ImgS.settingsBlock, 50, 280, null);
	}
}
