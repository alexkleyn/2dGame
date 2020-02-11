package dev.alex.game.gfx;
import java.awt.image.BufferedImage;
import dev.alex.game.gfx.SpriteSheet;

public class ChessPieces {		// Assets
	
	public BufferedImage whiteKing;
	public  BufferedImage whiteQueen;
	public  BufferedImage whiteBishop;
	public  BufferedImage whiteKnight;
	public  BufferedImage whiteRook;
	public  BufferedImage whitePawn;
	
	public  BufferedImage blackKing;
	public  BufferedImage blackQueen;
	public  BufferedImage blackBishop;
	public  BufferedImage blackKnight;
	public  BufferedImage blackRook;
	public  BufferedImage blackPawn;
	
	
		
	private BufferedImage loadChessPiece(int x, int y, int width, int height) {
		return new SpriteSheet(ImageLoader.loadImage("/textures/chess.png")).crop(x, y, width, height);
	}

	public void loadAll (int width, int height) {
		whiteKing = loadChessPiece (0, 0, width, height);
		whiteQueen = loadChessPiece (1*width, 0, width, height);
		whiteBishop = loadChessPiece (2*width, 0, width, height);
		whiteKnight = loadChessPiece (3*width, 0, width, height);
		whiteRook = loadChessPiece (4*width, 0, width, height);
		whitePawn = loadChessPiece (5*width, 0, width, height);
		
		blackKing = loadChessPiece (0, 1*height, width, height);
		blackQueen = loadChessPiece (1*width, 1*height, width, height);
		blackBishop = loadChessPiece (2*width, 1*height, width, height);
		blackKnight = loadChessPiece (3*width, 1*height, width, height);
		blackRook = loadChessPiece (4*width, 1*height, width, height);
		blackPawn = loadChessPiece (5*width, 1*height, width, height);
	}
}
