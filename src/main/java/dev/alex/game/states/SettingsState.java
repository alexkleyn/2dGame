package dev.alex.game.states;

import java.awt.Graphics;
import java.awt.Rectangle;

import dev.alex.game.Game;
import dev.alex.game.gfx.chessGfx.ImgS;
import dev.alex.game.pieces.PieceS;
import dev.alex.game.tile.Tile;

public class SettingsState extends State{
	
	private int width;
	private int height;
	public Graphics g;
	public Rectangle bounds = new Rectangle(Tile.rectSize, Tile.rectSize, 2*Tile.rectSize + (Tile.rectSize/5)*2, 2*Tile.rectSize + (Tile.rectSize/5)*2);
	public Rectangle bounds2 = new Rectangle(Tile.rectSize, 4*Tile.rectSize + (Tile.rectSize/5)*3, 2*Tile.rectSize + (Tile.rectSize/5)*2, 2*Tile.rectSize + (Tile.rectSize/5)*2);
	public Rectangle bounds3 = new Rectangle(4*Tile.rectSize + (Tile.rectSize/5)*3, Tile.rectSize, 2*Tile.rectSize + (Tile.rectSize/5)*2, 2*Tile.rectSize + (Tile.rectSize/5)*2);
	public Rectangle bounds4 = new Rectangle(4*Tile.rectSize + (Tile.rectSize/5)*3, 4*Tile.rectSize + (Tile.rectSize/5)*3, 2*Tile.rectSize + (Tile.rectSize/5)*2, 2*Tile.rectSize + (Tile.rectSize/5)*2);

	public SettingsState(int width, int height, Game game) {
		super(game);
		this.width = width;
		this.height = height;
	}

	@Override
	public void tick() {
		if (Game.km.esc) {
			StateManager.setState(game.menuState);
		}
		if (bounds.contains(Game.mm.getMouseX(), Game.mm.getMouseY()) && Game.mm.getLeftPressed()) {
			ImgS.spritePath = "/textures/chess3d.png";
			ImgS.loadAll(50, 50);
			PieceS.loadAll();
		}
		if (bounds2.contains(Game.mm.getMouseX(), Game.mm.getMouseY()) && Game.mm.getLeftPressed()) {
			ImgS.spritePath = "/textures/chessBluePink.png";
			ImgS.loadAll(50, 50);
			PieceS.loadAll();
		}
		if (bounds3.contains(Game.mm.getMouseX(), Game.mm.getMouseY()) && Game.mm.getLeftPressed()) {
			ImgS.spritePath = "/textures/chessMedieval.png";
			ImgS.loadAll(50, 50);
			PieceS.loadAll();
		}
		if (bounds4.contains(Game.mm.getMouseX(), Game.mm.getMouseY()) && Game.mm.getLeftPressed()) {
			ImgS.spritePath = "/textures/chessNormal.png";
			ImgS.loadAll(50, 50);
			PieceS.loadAll();
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(ImgS.chess3dThumb, Tile.rectSize, Tile.rectSize, null);
		g.drawImage(ImgS.chessBluePinkThumb, Tile.rectSize, 4*Tile.rectSize + (Tile.rectSize/5)*3, null);
		g.drawImage(ImgS.chessMedievalThumb, 4*Tile.rectSize + (Tile.rectSize/5)*3, Tile.rectSize, null);
		g.drawImage(ImgS.chessNormalThumb, 4*Tile.rectSize + (Tile.rectSize/5)*3, 4*Tile.rectSize + (Tile.rectSize/5)*3, null);
	}
}
