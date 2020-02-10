package dev.alex.game.gfx;
import java.awt.image.BufferedImage;
import dev.alex.game.gfx.SpriteSheet;

public class ChessPieces {
	
	private BufferedImage chessSheet;
	
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
	
	public ChessPieces() {
		this.chessSheet = ImageLoader.loadImage("/textures/chess.png");
	}
	
	private BufferedImage loadChessPiece(int x, int y, int width, int height) {
		return new SpriteSheet(chessSheet).crop(x, y, width, height);
	}

	public void loadAll() {
		whiteKing = loadChessPiece (0, 0, 50, 50);
		whiteQueen = loadChessPiece (50, 0, 50, 50);
		whiteBishop = loadChessPiece (100, 0, 50, 50);
		whiteKnight = loadChessPiece (150, 0, 50, 50);
		whiteRook = loadChessPiece (200, 0, 50, 50);
		whitePawn = loadChessPiece (250, 0, 50, 50);
		
		blackKing = loadChessPiece (0, 50, 50, 50);
		blackQueen = loadChessPiece (50, 50, 50, 50);
		blackBishop = loadChessPiece (100, 50, 50, 50);
		blackKnight = loadChessPiece (150, 50, 50, 50);
		blackRook = loadChessPiece (200, 50, 50, 50);
		blackPawn = loadChessPiece (250, 50, 50, 50);
	}
}
