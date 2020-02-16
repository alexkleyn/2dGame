package dev.alex.game.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {
	
	private boolean[] keys;
	public boolean up;
	public boolean down;
	public boolean left;
	public boolean right;
	
	public boolean del;
	
	public boolean q;
	public boolean k;
	public boolean c;
	
	
	public KeyManager() {
		keys = new boolean[256];
	}
	
	public void tick() {
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
		
		del = keys[KeyEvent.VK_BACK_SPACE];
		c = keys[KeyEvent.VK_C];
		
		q = keys[KeyEvent.VK_Q];
		k = keys[KeyEvent.VK_K];
	}
	

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}

}
