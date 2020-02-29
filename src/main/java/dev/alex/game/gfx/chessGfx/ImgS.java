package dev.alex.game.gfx.chessGfx;
import java.awt.image.BufferedImage;

import dev.alex.game.gfx.ImageLoader;
import dev.alex.game.gfx.SpriteSheet;

public class ImgS {		// Assets
	
	public static BufferedImage ImgWhiteKing;
	public static BufferedImage ImgWhiteQueen;
	public static BufferedImage ImgWhiteBishop;
	public static BufferedImage ImgWhiteKnight;
	public static BufferedImage ImgWhiteRook;
	public static BufferedImage ImgWhitePawn;
	
	public static BufferedImage ImgBlackKing;
	public static BufferedImage ImgBlackQueen;
	public static BufferedImage ImgBlackBishop;
	public static BufferedImage ImgBlackKnight;
	public static BufferedImage ImgBlackRook;
	public static BufferedImage ImgBlackPawn;
	
	public static BufferedImage settingsBlock;
	public static BufferedImage gameStartBlock;
	
	public static BufferedImage chess3dThumb;
	public static BufferedImage chessBluePinkThumb;
	public static BufferedImage chessMedievalThumb;
	public static BufferedImage chessNormalThumb;
	
	public static BufferedImage chooseWhiteKnight;
	public static BufferedImage chooseWhiteBishop;
	public static BufferedImage chooseWhiteRook;
	public static BufferedImage chooseWhiteQueen;
	
	public static BufferedImage chooseBlackKnight;
	public static BufferedImage chooseBlackBishop;
	public static BufferedImage chooseBlackRook;
	public static BufferedImage chooseBlackQueen;
	
	public static String spritePath = "/textures/chessNormal.png";
		
	private static BufferedImage loadChessPieceSheet(int x, int y, int width, int height) {
		return new SpriteSheet(ImageLoader.loadImage(spritePath)).crop(x, y, width, height);
	}

	public static void loadAll (int width, int height) {
		ImgWhiteKing = loadChessPieceSheet (0, 0, width, height);
		ImgWhiteQueen = loadChessPieceSheet (1*width, 0, width, height);
		ImgWhiteBishop = loadChessPieceSheet (2*width, 0, width, height);
		ImgWhiteKnight = loadChessPieceSheet (3*width, 0, width, height);
		ImgWhiteRook = loadChessPieceSheet (4*width, 0, width, height);
		ImgWhitePawn = loadChessPieceSheet (5*width, 0, width, height);
		
		ImgBlackKing = loadChessPieceSheet (0, 1*height, width, height);
		ImgBlackQueen = loadChessPieceSheet (1*width, 1*height, width, height);
		ImgBlackBishop = loadChessPieceSheet (2*width, 1*height, width, height);
		ImgBlackKnight = loadChessPieceSheet (3*width, 1*height, width, height);
		ImgBlackRook = loadChessPieceSheet (4*width, 1*height, width, height);
		ImgBlackPawn = loadChessPieceSheet (5*width, 1*height, width, height);
		
		gameStartBlock = ImageLoader.loadImage("/textures/gameStartBlock.png");
		settingsBlock = ImageLoader.loadImage("/textures/settingsBlock.png");
		
		chess3dThumb = ImageLoader.loadImage("/textures/chess3dThumb.png");
		chessBluePinkThumb = ImageLoader.loadImage("/textures/chessBluePinkThumb.png");
		chessMedievalThumb = ImageLoader.loadImage("/textures/chessMedievalThumb.png");
		chessNormalThumb = ImageLoader.loadImage("/textures/chessNormalThumb.png");
		
		chooseWhiteKnight = ImageLoader.loadImage("/textures/chooseWhiteKnight.png");
		chooseWhiteBishop = ImageLoader.loadImage("/textures/chooseWhiteBishop.png");
		chooseWhiteRook = ImageLoader.loadImage("/textures/chooseWhiteRook.png");
		chooseWhiteQueen = ImageLoader.loadImage("/textures/chooseWhiteQueen.png");
		
		chooseBlackKnight = ImageLoader.loadImage("/textures/chooseBlackKnight.png");
		chooseBlackBishop = ImageLoader.loadImage("/textures/chooseBlackBishop.png");
		chooseBlackRook = ImageLoader.loadImage("/textures/chooseBlackRook.png");
		chooseBlackQueen = ImageLoader.loadImage("/textures/chooseBlackQueen.png");
	}
}
