package dev.alex.game.states;

import java.awt.*;
import java.awt.image.BufferedImage;

import dev.alex.game.Game;
import dev.alex.game.Launcher;
import dev.alex.game.gfx.chessGfx.ImgS;
import dev.alex.game.pieces.*;
import dev.alex.game.tile.Tile;

public class GameState extends State {

	public boolean drawChoiceBlack = false;
	public boolean drawChoice = false;
	public BufferedImage changeImgTo;
	public boolean lastWasBlack = true;
	public boolean pawnChanged = false;
	public int width;
	public int height;
	public Graphics g;
	private Piece currentActor = PieceS.whiteKing;
	public static boolean makeDots = false;
	Piece piece;
	public int mouseX;
	public int mouseY;

	public void tick() {
		if (Game.km.esc)
			StateManager.setState(game.menuState);
		pieceDrag();
		currentActor.tick();

	}

	public void pieceDrag() {
		if (Game.mm.getLeftPressed()) {
			for (Piece piece : Piece.pieces) {
				if (piece.bounds.contains(Game.mm.getMouseX(), Game.mm.getMouseY()) && piece.isBlack != lastWasBlack) {
					Integer newPosX = null;
					Integer newPosY = null;
					makeDots = true;
					this.piece = piece;
					currentActor = piece;
					Game.mm.setLeftPressed(false);
					while (!Game.mm.getLeftPressed()) {
						Launcher.game.render();
						int bumpX = (Game.mm.getMouseX() % Tile.rectSize);
						newPosX = (Game.mm.getMouseX() - bumpX);
						int bumpY = (Game.mm.getMouseY() % Tile.rectSize);
						newPosY = (Game.mm.getMouseY() - bumpY);
						sleep();
					}
					if (newPosX != null && newPosY != null) {
						for (Tile t : Tile.tiles) {
							if (newPosX == t.x && newPosY == t.y && t.enterable) {
								piece.p.setX(newPosX);
								piece.p.setY(newPosY);
								if (piece.isPawn && (piece.isBlack && piece.p.getY() == 350) // Pawn Transform
										|| piece.isPawn && (!piece.isBlack && piece.p.getY() == 0)) {
									Rectangle boundsChooseKnight = new Rectangle(0, 0, 200, 200);
									Rectangle boundsChooseBishop = new Rectangle(200, 0, 200, 200);
									Rectangle boundsChooseRook = new Rectangle(0, 200, 200, 200);
									Rectangle boundsChooseQueen = new Rectangle(200, 200, 200, 200);
									Game.mm.setLeftPressed(false);
									pawnChanged = false;
									piece.setImg(null);
									drawChoice = true;
									if (piece.isBlack) {
										drawChoiceBlack = true;
									} else {
										drawChoiceBlack = false;
									}
									while (!Game.mm.getLeftPressed()) {
										Launcher.game.render();
										mouseX = Game.mm.getMouseX();
										mouseY = Game.mm.getMouseY();
										sleep();
									}
									drawChoice = false;
									if (piece.isBlack) {
										if (boundsChooseKnight.contains(mouseX, mouseY)) {
											System.out.println("knight");
											piece.setImg(ImgS.ImgBlackKnight);
											piece.setMakeDotsOf("knight");
										} else if (boundsChooseBishop.contains(mouseX, mouseY)) {
											System.out.println("bishop");
											piece.setImg(ImgS.ImgBlackBishop);
											piece.setMakeDotsOf("bishop");
										} else if (boundsChooseRook.contains(mouseX, mouseY)) {
											System.out.println("rook");
											piece.setImg(ImgS.ImgBlackRook);
											piece.setMakeDotsOf("rook");
										} else if (boundsChooseQueen.contains(mouseX, mouseY)) {
											System.out.println("queen");
											piece.setImg(ImgS.ImgBlackQueen);
											piece.setMakeDotsOf("queen");
										}
									} else if (!piece.isBlack) {
										if (boundsChooseKnight.contains(mouseX, mouseY)) {
											System.out.println("knight");
											piece.setImg(ImgS.ImgWhiteKnight);
											piece.setMakeDotsOf("knight");
										} else if (boundsChooseBishop.contains(mouseX, mouseY)) {
											System.out.println("bishop");
											piece.setImg(ImgS.ImgWhiteBishop);
											piece.setMakeDotsOf("bishop");
										} else if (boundsChooseRook.contains(mouseX, mouseY)) {
											System.out.println("rook");
											piece.setImg(ImgS.ImgWhiteRook);
											piece.setMakeDotsOf("rook");
										} else if (boundsChooseQueen.contains(mouseX, mouseY)) {
											System.out.println("queen");
											piece.setImg(ImgS.ImgWhiteQueen);
											piece.setMakeDotsOf("queen");
										}
									}
								} // Transform ende
								if (piece == PieceS.whiteKing && !piece.wasMoved && piece.p.getX() == Tile.rectSize
										&& piece.p.getY() == 7 * Tile.rectSize) {
									PieceS.whiteRook.p.setX(2 * Tile.rectSize);
								}
								if (piece == PieceS.blackKing && !piece.wasMoved && piece.p.getX() == Tile.rectSize
										&& piece.p.getY() == 0) {
									PieceS.blackRook.p.setX(2 * Tile.rectSize);
								}
								if (piece == PieceS.whiteKing && !piece.wasMoved && piece.p.getX() == 5 * Tile.rectSize
										&& piece.p.getY() == 7 * Tile.rectSize) {
									PieceS.whiteRook2.p.setX(4 * Tile.rectSize);
								}
								if (piece == PieceS.blackKing && !piece.wasMoved && piece.p.getX() == 5 * Tile.rectSize
										&& piece.p.getY() == 0) {
									PieceS.blackRook2.p.setX(4 * Tile.rectSize);
								}
								piece.wasMoved = true;
								if (lastWasBlack) {
									lastWasBlack = false;
								} else {
									lastWasBlack = true;
								}
								for (Piece p : Piece.pieces) {
									if (piece.p.getX() == p.p.getX() && piece.p.getY() == p.p.getY()
											&& piece.getId() != p.getId() && piece.isBlack != p.isBlack) {
										p.delete();
									}
								}
								t.enterable = false;
							}
						}
					}
					for (Tile t : Tile.tiles) {
						if (t.enterable) {
							t.enterable = false;
						}
					}
					makeDots = false;
					piece.render();
				}
			}
		}
	}

	private void sleep() {
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {

		}
	}

	public void render(Graphics g) {
		this.g = g;
		drawBoard();
		drawPieces();
		if (drawChoice) {
			g.setColor(new Color(200, 200, 200));
			g.fillRect(100, 100, 100, 100);
			g.fillRect(100, 200, 100, 100);
			g.fillRect(200, 100, 100, 100);
			g.fillRect(200, 200, 100, 100);
			g.setColor(new Color(0, 0, 0));
			g.drawRect(100, 100, 100, 100);
			g.drawRect(200, 100, 100, 100);
			g.drawRect(100, 200, 100, 100);
			g.drawRect(200, 200, 100, 100);
			if (drawChoiceBlack) {
				g.drawImage(ImgS.chooseBlackKnight, 100, 100, null);
				g.drawImage(ImgS.chooseBlackBishop, 200, 100, null);
				g.drawImage(ImgS.chooseBlackRook, 100, 200, null);
				g.drawImage(ImgS.chooseBlackQueen, 200, 200, null);
			} else {
				g.drawImage(ImgS.chooseWhiteKnight, 100, 100, null);
				g.drawImage(ImgS.chooseWhiteBishop, 200, 100, null);
				g.drawImage(ImgS.chooseWhiteRook, 100, 200, null);
				g.drawImage(ImgS.chooseWhiteQueen, 200, 200, null);
			}
		}
		if (makeDots) {
			if (piece != null) {
				piece.makeDots();
			}
		}
	}

	public void setCurrentActor(Piece newCurrentActor) {
		currentActor = newCurrentActor;
	}

	public Piece getCurrentActor() {
		return currentActor;
	}

	public GameState(int width, int height, Game game) {
		super(game);
		this.width = width;
		this.height = height;
	}

	private void drawPieces() {

		PieceS.whiteKing.render();
		PieceS.whiteQueen.render();
		PieceS.whiteBishop.render();
		PieceS.whiteBishop2.render();
		PieceS.whiteKnight.render();
		PieceS.whiteKnight2.render();
		PieceS.whiteRook.render();
		PieceS.whiteRook2.render();

		PieceS.whitePawn.render();
		PieceS.whitePawn2.render();
		PieceS.whitePawn3.render();
		PieceS.whitePawn4.render();
		PieceS.whitePawn5.render();
		PieceS.whitePawn6.render();
		PieceS.whitePawn7.render();
		PieceS.whitePawn8.render();

		PieceS.blackKing.render();
		PieceS.blackQueen.render();
		PieceS.blackBishop.render();
		PieceS.blackBishop2.render();
		PieceS.blackKnight.render();
		PieceS.blackKnight2.render();
		PieceS.blackRook.render();
		PieceS.blackRook2.render();

		PieceS.blackPawn.render();
		PieceS.blackPawn2.render();
		PieceS.blackPawn3.render();
		PieceS.blackPawn4.render();
		PieceS.blackPawn5.render();
		PieceS.blackPawn6.render();
		PieceS.blackPawn7.render();
		PieceS.blackPawn8.render();
	}

	public void drawBoard() {
		for (Tile t : Tile.tiles) {
			t.render(g);
		}
	}
} // Ende von Klasse