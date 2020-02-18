package dev.alex.game.pieces;

import dev.alex.game.gfx.chessGfx.ImgS;
import dev.alex.game.gfx.chessGfx.pS;

public class PieceS {

    public static Piece whiteKing = new WhiteKing(ImgS.ImgWhiteKing, pS.pWhiteKing, 0);
    public static Piece whiteQueen = new WhiteQueen(ImgS.ImgWhiteQueen, pS.pWhiteQueen, 1);
    public static Piece whiteBishop = new WhiteBishop(ImgS.ImgWhiteBishop, pS.pWhiteBishop, 2);
    public static Piece whiteBishop2 = new WhiteBishop(ImgS.ImgWhiteBishop, pS.pWhiteBishop2, 3);
    public static Piece whiteKnight = new WhiteKnight(ImgS.ImgWhiteKnight, pS.pWhiteKnight, 4);
    public static Piece whiteKnight2 = new WhiteKnight(ImgS.ImgWhiteKnight, pS.pWhiteKnight2, 5);
    public static Piece whiteRook = new WhiteRook(ImgS.ImgWhiteRook, pS.pWhiteRook, 6);
    public static Piece whiteRook2 = new WhiteRook(ImgS.ImgWhiteRook, pS.pWhiteRook2, 7);

//    public static Piece whitePawns[] = new Piece[;]

    public static Piece whitePawn = new WhitePawn(ImgS.ImgWhitePawn, pS.pWhitePawn, 8);
    public static Piece whitePawn2 = new WhitePawn(ImgS.ImgWhitePawn, pS.pWhitePawn2, 9);
    public static Piece whitePawn3 = new WhitePawn(ImgS.ImgWhitePawn, pS.pWhitePawn3, 10);
    public static Piece whitePawn4 = new WhitePawn(ImgS.ImgWhitePawn, pS.pWhitePawn4, 11);
    public static Piece whitePawn5 = new WhitePawn(ImgS.ImgWhitePawn, pS.pWhitePawn5, 12);
    public static Piece whitePawn6 = new WhitePawn(ImgS.ImgWhitePawn, pS.pWhitePawn6, 13);
    public static Piece whitePawn7 = new WhitePawn(ImgS.ImgWhitePawn, pS.pWhitePawn7, 14);
    public static Piece whitePawn8 = new WhitePawn(ImgS.ImgWhitePawn, pS.pWhitePawn8, 15);

    public static Piece blackKing = new BlackKing(ImgS.ImgBlackKing, pS.pBlackKing, 16);
    public static Piece blackQueen = new BlackQueen(ImgS.ImgBlackQueen, pS.pBlackQueen, 17);
    public static Piece blackBishop = new BlackBishop(ImgS.ImgBlackBishop, pS.pBlackBishop, 18);
    public static Piece blackBishop2 = new BlackBishop(ImgS.ImgBlackBishop, pS.pBlackBishop2, 19);
    public static Piece blackKnight = new BlackKnight(ImgS.ImgBlackKnight, pS.pBlackKnight, 20);
    public static Piece blackKnight2 = new BlackKnight(ImgS.ImgBlackKnight, pS.pBlackKnight2, 21);
    public static Piece blackRook = new BlackRook(ImgS.ImgBlackRook, pS.pBlackRook, 22);
    public static Piece blackRook2 = new BlackRook(ImgS.ImgBlackRook, pS.pBlackRook2, 23);

    public static Piece blackPawn = new BlackPawn(ImgS.ImgBlackPawn, pS.pBlackPawn, 24);
    public static Piece blackPawn2 = new BlackPawn(ImgS.ImgBlackPawn, pS.pBlackPawn2, 25);
    public static Piece blackPawn3 = new BlackPawn(ImgS.ImgBlackPawn, pS.pBlackPawn3, 26);
    public static Piece blackPawn4 = new BlackPawn(ImgS.ImgBlackPawn, pS.pBlackPawn4, 27);
    public static Piece blackPawn5 = new BlackPawn(ImgS.ImgBlackPawn, pS.pBlackPawn5, 28);
    public static Piece blackPawn6 = new BlackPawn(ImgS.ImgBlackPawn, pS.pBlackPawn6, 29);
    public static Piece blackPawn7 = new BlackPawn(ImgS.ImgBlackPawn, pS.pBlackPawn7, 30);
    public static Piece blackPawn8 = new BlackPawn(ImgS.ImgBlackPawn, pS.pBlackPawn8, 31);

    public static void loadAll() {
    	whiteKing = new WhiteKing(ImgS.ImgWhiteKing, pS.pWhiteKing, 0);
        whiteQueen = new WhiteQueen(ImgS.ImgWhiteQueen, pS.pWhiteQueen, 1);
        whiteBishop = new WhiteBishop(ImgS.ImgWhiteBishop, pS.pWhiteBishop, 2);
        whiteBishop2 = new WhiteBishop(ImgS.ImgWhiteBishop, pS.pWhiteBishop2, 3);
        whiteKnight = new WhiteKnight(ImgS.ImgWhiteKnight, pS.pWhiteKnight, 4);
        whiteKnight2 = new WhiteKnight(ImgS.ImgWhiteKnight, pS.pWhiteKnight2, 5);
        whiteRook = new WhiteRook(ImgS.ImgWhiteRook, pS.pWhiteRook, 6);
        whiteRook2 = new WhiteRook(ImgS.ImgWhiteRook, pS.pWhiteRook2, 7);


        whitePawn = new WhitePawn(ImgS.ImgWhitePawn, pS.pWhitePawn, 8);
        whitePawn2 = new WhitePawn(ImgS.ImgWhitePawn, pS.pWhitePawn2, 9);
        whitePawn3 = new WhitePawn(ImgS.ImgWhitePawn, pS.pWhitePawn3, 10);
        whitePawn4 = new WhitePawn(ImgS.ImgWhitePawn, pS.pWhitePawn4, 11);
        whitePawn5 = new WhitePawn(ImgS.ImgWhitePawn, pS.pWhitePawn5, 12);
        whitePawn6 = new WhitePawn(ImgS.ImgWhitePawn, pS.pWhitePawn6, 13);
        whitePawn7 = new WhitePawn(ImgS.ImgWhitePawn, pS.pWhitePawn7, 14);
        whitePawn8 = new WhitePawn(ImgS.ImgWhitePawn, pS.pWhitePawn8, 15);

        blackKing = new BlackKing(ImgS.ImgBlackKing, pS.pBlackKing, 16);
        blackQueen = new BlackQueen(ImgS.ImgBlackQueen, pS.pBlackQueen, 17);
        blackBishop = new BlackBishop(ImgS.ImgBlackBishop, pS.pBlackBishop, 18);
        blackBishop2 = new BlackBishop(ImgS.ImgBlackBishop, pS.pBlackBishop2, 19);
        blackKnight = new BlackKnight(ImgS.ImgBlackKnight, pS.pBlackKnight, 20);
        blackKnight2 = new BlackKnight(ImgS.ImgBlackKnight, pS.pBlackKnight2, 21);
        blackRook = new BlackRook(ImgS.ImgBlackRook, pS.pBlackRook, 22);
        blackRook2 = new BlackRook(ImgS.ImgBlackRook, pS.pBlackRook2, 23);

        blackPawn = new BlackPawn(ImgS.ImgBlackPawn, pS.pBlackPawn, 24);
        blackPawn2 = new BlackPawn(ImgS.ImgBlackPawn, pS.pBlackPawn2, 25);
        blackPawn3 = new BlackPawn(ImgS.ImgBlackPawn, pS.pBlackPawn3, 26);
        blackPawn4 = new BlackPawn(ImgS.ImgBlackPawn, pS.pBlackPawn4, 27);
        blackPawn5 = new BlackPawn(ImgS.ImgBlackPawn, pS.pBlackPawn5, 28);
        blackPawn6 = new BlackPawn(ImgS.ImgBlackPawn, pS.pBlackPawn6, 29);
        blackPawn7 = new BlackPawn(ImgS.ImgBlackPawn, pS.pBlackPawn7, 30);
        blackPawn8 = new BlackPawn(ImgS.ImgBlackPawn, pS.pBlackPawn8, 31);
    }
//    static {
//        for (int i = 0; i < 8; i++) {
//            Piece pawn = new whitePawn(ImgS.ImgWhitePawn, pS.pWhitePawn, i + 8);
//            whitePawns[i] = pawn;
//        }
//    }

//    public static Piece getWhitePawn(int index){
//    	return whitePawns[index];
//    }

}
