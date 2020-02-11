package dev.alex.game.states;
import java.awt.Graphics;

public abstract class State {
	
	public abstract void tick();
	
	public abstract void render(Graphics g);

}
