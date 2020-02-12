package dev.alex.game.states;

import java.awt.Graphics;

import dev.alex.game.Game;

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
		
	}
	
	public void render(Graphics g) {
		this.g = g;
	}
}
