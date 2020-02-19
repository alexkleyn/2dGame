package dev.alex.game.states;

import java.awt.*;


import dev.alex.game.Game;
import dev.alex.game.Launcher;
import dev.alex.game.gfx.chessGfx.ImgS;
import dev.alex.game.gfx.chessGfx.pS;
import dev.alex.game.pieces.Piece;
import dev.alex.game.pieces.PieceS;
import dev.alex.game.tile.Tile;

public class GameState extends State {

    public boolean lastWasBlack = true;
    public int width;
    public int height;
    public Graphics g;
    private Piece currentActor = PieceS.whiteKing;
    public boolean makeDots = false;
    Piece piece;

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
                        //System.out.println("waiting");
                        sleep();
                    }
                    if (newPosX != null && newPosY != null) {
                        for (Tile t : Tile.tiles) {
                            if (newPosX == t.x && newPosY == t.y && t.enterable) {
                                piece.p.setX(newPosX);
                                piece.p.setY(newPosY);
                                if (piece == PieceS.whiteKing && !piece.wasMoved &&
                                		piece.p.getX() == Tile.rectSize && piece.p.getY() == 7*Tile.rectSize) {
                                	PieceS.whiteRook.p.setX(2*Tile.rectSize);
                                }
                                if (piece == PieceS.blackKing && !piece.wasMoved &&
                                		piece.p.getX() == Tile.rectSize && piece.p.getY() == 0) {
                                	PieceS.blackRook.p.setX(2*Tile.rectSize);
                                }
                                if (piece == PieceS.whiteKing && !piece.wasMoved &&
                                		piece.p.getX() == 5*Tile.rectSize && piece.p.getY() == 7*Tile.rectSize) {
                                	PieceS.whiteRook2.p.setX(4*Tile.rectSize);
                                }
                                if (piece == PieceS.blackKing && !piece.wasMoved &&
                                		piece.p.getX() == 5*Tile.rectSize && piece.p.getY() == 0) {
                                	PieceS.blackRook2.p.setX(4*Tile.rectSize);
                                }
                                piece.wasMoved = true;
                                if (lastWasBlack) {
                                    lastWasBlack = false;
                                } else {
                                    lastWasBlack = true;
                                }
                                for (Piece p : Piece.pieces) {
                                    if (piece.p.getX() == p.p.getX()
                                            && piece.p.getY() == p.p.getY()
                                            && piece.getId() != p.getId()
                                            && piece.isBlack != p.isBlack) {
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
        }
        catch (InterruptedException e) {

        }
    }

    public void render(Graphics g) {
        this.g = g;
        drawBoard();
        drawPieces();
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