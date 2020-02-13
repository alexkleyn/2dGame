package dev.alex.game.states;

import java.awt.Color;
import java.awt.Graphics;

import dev.alex.game.Game;
import dev.alex.game.input.MouseManager;

public class MenuState extends State {

	public int width;
	public int height;
	public Graphics g;
	
	
	public MenuState(int width, int height, Game game) {
		super(game);
		this.width = width;
		this.height = height;
	}
	
	public void tick() {
		if (Game.mm.getLeftPressed() && Game.mm.getRightPressed())
			StateManager.setState(game.gameState);
	}
	
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(Game.mm.getMouseX(), Game.mm.getMouseY(), 8, 8);
		this.g = g;
		
	}
}
