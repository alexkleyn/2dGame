package dev.alex.game.pieces;

import java.awt.Color;
import java.awt.image.BufferedImage;

import dev.alex.game.Game;
import dev.alex.game.gfx.chessGfx.ImgS;
import dev.alex.game.gfx.chessGfx.Position;
import dev.alex.game.tile.Tile;


public class WhitePawn extends WhitePiece {
	
	public WhitePawn(BufferedImage img, Position p, int id) {
		super(img, p, id);
		isPawn = true;
	}
	
	@Override
	public void makeDots() {
		if (makeDotsOf.equals("pawn"))
			makeDotsPawn();
		else if (makeDotsOf.equals("knight"))
			makeDotsKnight();
		else if (makeDotsOf.equals("bishop"))
			makeDotsBishop();
		else if (makeDotsOf.equals("rook"))
			makeDotsRook();
		else if (makeDotsOf.equals("queen"))
			makeDotsQueen();
	}
	
	public void makeDotsPawn() {
		boolean isOccupied = false;
		boolean isOccupied2 = false;
		Game.g.setColor(Color.red);
		for(Piece p : Piece.pieces) {
			if(p.p.getX() == this.p.getX() - Tile.rectSize && p.p.getY() == this.p.getY() - Tile.rectSize && p.isBlack != this.isBlack) {
				renderDot(this.p.getX() - Tile.rectSize, this.p.getY() - Tile.rectSize);
			}
			if(p.p.getX() == this.p.getX() + Tile.rectSize && p.p.getY() == this.p.getY() - Tile.rectSize && p.isBlack != this.isBlack) {
				renderDot(this.p.getX() + Tile.rectSize, this.p.getY() - Tile.rectSize);
			}
			if(this.p.getX() == p.p.getX() && this.p.getY() - Tile.rectSize == p.p.getY()) {
				isOccupied = true;
			}
			if(this.p.getX() == p.p.getX() && this.p.getY() - 2*Tile.rectSize == p.p.getY()) {
				isOccupied2 = true;
			}
		}
		if(!isOccupied)
			renderDot(p.getX(), p.getY() - Tile.rectSize);
		if(p.getY() == 6*Tile.rectSize && !isOccupied2 && !isOccupied)
			renderDot(p.getX(), p.getY() - 2*Tile.rectSize);
		isOccupied = false;
		isOccupied2 = false;
	}
	
	public void makeDotsQueen() {
		Game.g.setColor(Color.red);
		for(int x = this.p.getX(); x < width; x += Tile.rectSize) {
			renderDot(x, this.p.getY());
			if(isPieceObstructing(this, x, p.getY())) {
				break;
			}
		}
		for(int x = this.p.getX(); x > -Tile.rectSize; x -= Tile.rectSize) {
			renderDot(x, this.p.getY());
			if(isPieceObstructing(this, x, p.getY())) {
				break;
			}
		}
		
		
		for(int y = this.p.getY(); y < width; y+= Tile.rectSize) {
			renderDot(this.p.getX(), y);
			if(isPieceObstructing(this, p.getX(), y)) {
				break;
			}
		}
		for(int y = this.p.getY(); y > -Tile.rectSize; y-= Tile.rectSize) {
			renderDot(this.p.getX(), y);
			if(isPieceObstructing(this, p.getX(), y)) {
				break;
			}
		}

		//Diagonalen
		for (int x = p.getX(), Y = p.getY(); x < width && Y < height; x += Tile.rectSize) {
			renderDot(x, Y);
			if(isPieceObstructing(this, x, Y)) {
				break;
			}
			Y += Tile.rectSize;
		}
		for (int x = p.getX(), Y = p.getY(); x > -Tile.rectSize && Y > -Tile.rectSize; x -= Tile.rectSize) {
			renderDot(x, Y);
			if(isPieceObstructing(this, x, Y)) {
				break;
			}
			Y -= Tile.rectSize;
		}
		for (int x = p.getX(), Y = p.getY(); x > -Tile.rectSize && Y < height; x -= Tile.rectSize) {
			renderDot(x, Y);
			if(isPieceObstructing(this, x, Y)) {
				break;
			}
			Y += Tile.rectSize;
		}
		for (int x = p.getX(), Y = p.getY(); x < width && Y > -Tile.rectSize; x += Tile.rectSize) {
			renderDot(x, Y);
			if(isPieceObstructing(this, x, Y)) {
				break;
			}
			Y -= Tile.rectSize;
		}
	}
	
	public void makeDotsRook() {
        Game.g.setColor(Color.red);
        for (int x = this.p.getX(); x < width; x += Tile.rectSize) {
            renderDot(x, this.p.getY());
            if (isPieceObstructing(this, x, p.getY())) {
                break;
            }
        }
        for (int x = this.p.getX(); x > -Tile.rectSize; x -= Tile.rectSize) {
            renderDot(x, this.p.getY());
	        if(isPieceObstructing(this, x, p.getY())) {
		        break;
	        }
        }


        for (int y = this.p.getY(); y < width; y += Tile.rectSize) {
            renderDot(this.p.getX(), y);
	        if(isPieceObstructing(this, p.getX(), y)) {
		        break;
	        }
        }
        for (int y = this.p.getY(); y > -Tile.rectSize; y -= Tile.rectSize) {
            renderDot(this.p.getX(), y);
	        if(isPieceObstructing(this, p.getX(), y)) {
		        break;
	        }
        }
    }
	
	public void makeDotsKnight() {
		Game.g.setColor(Color.red);
		renderDot(p.getX() + 2*Tile.rectSize, p.getY() + Tile.rectSize);
		renderDot(p.getX() + 2*Tile.rectSize, p.getY() - Tile.rectSize);
		
		renderDot(p.getX() - 2*Tile.rectSize, p.getY() + Tile.rectSize);
		renderDot(p.getX() - 2*Tile.rectSize, p.getY() - Tile.rectSize);
		
		renderDot(p.getX() + Tile.rectSize, p.getY() + 2*Tile.rectSize);
		renderDot(p.getX() - Tile.rectSize, p.getY() + 2*Tile.rectSize);
		
		renderDot(p.getX() + Tile.rectSize, p.getY() - 2*Tile.rectSize);
		renderDot(p.getX() - Tile.rectSize, p.getY() - 2*Tile.rectSize);
	}
	
	public void makeDotsBishop() {
		Game.g.setColor(Color.red);
		//Diagonalen
		//Unten rechts
		for(int x = p.getX() + Tile.rectSize, Y = p.getY() + Tile.rectSize; x < width && Y < height; x += Tile.rectSize) {
			renderDot(x, Y);
			if(isPieceObstructing(this, x, Y)) {
				break;
			}
			Y += Tile.rectSize;
		}
		//Oben links
		for(int x = p.getX() - Tile.rectSize, Y = p.getY() -Tile.rectSize; x > -Tile.rectSize && Y > -Tile.rectSize; x -= Tile.rectSize) {
			renderDot(x, Y);
			if(isPieceObstructing(this, x, Y)) {
				break;
			}
			Y -= Tile.rectSize;
		}
		//Unten links
		for(int x = p.getX() - Tile.rectSize, Y = p.getY() + Tile.rectSize; x > -Tile.rectSize && Y < height; x -= Tile.rectSize) {
			renderDot(x, Y);
			if(isPieceObstructing(this, x, Y)) {
				break;
			}
			Y += Tile.rectSize;
		}
		//Oben rechts
		for(int x = p.getX() + Tile.rectSize, Y = p.getY() - Tile.rectSize; x < width && Y > -Tile.rectSize; x += Tile.rectSize) {
			renderDot(x, Y);
			if(isPieceObstructing(this, x, Y)) {
				break;
			}
			Y -= Tile.rectSize;
		}
	}
	
	/////////////////////////////////////////////////////////////////////
	
	public void loadEnterableTiles() {
		resetEnterableTiles();
		if (makeDotsOf.equals("pawn"))
			loadEnterableTilesPawn();
		else if (makeDotsOf.equals("knight"))
			loadEnterableTilesKnight();
		else if (makeDotsOf.equals("bishop"))
			loadEnterableTilesBishop();
		else if (makeDotsOf.equals("rook"))
			loadEnterableTilesRook();
		else if (makeDotsOf.equals("queen"))
			loadEnterableTilesQueen();
	}
	
	public void loadEnterableTilesPawn() {
		addEnterableTile(p.getX() + 50, p.getY() - 50);
		addEnterableTile(p.getX() - 50, p.getY() - 50);
	}
	
	public void loadEnterableTilesQueen() {
		Game.g.setColor(Color.red);
		for(int x = this.p.getX(); x < width; x += Tile.rectSize) {
			addEnterableTile(x, this.p.getY());
			if(isPieceObstructing(this, x, p.getY())) {
				break;
			}
		}
		for(int x = this.p.getX(); x > -Tile.rectSize; x -= Tile.rectSize) {
			addEnterableTile(x, this.p.getY());
			if(isPieceObstructing(this, x, p.getY())) {
				break;
			}
		}
		
		
		for(int y = this.p.getY(); y < width; y+= Tile.rectSize) {
			addEnterableTile(this.p.getX(), y);
			if(isPieceObstructing(this, p.getX(), y)) {
				break;
			}
		}
		for(int y = this.p.getY(); y > -Tile.rectSize; y-= Tile.rectSize) {
			addEnterableTile(this.p.getX(), y);
			if(isPieceObstructing(this, p.getX(), y)) {
				break;
			}
		}

		//Diagonalen
		for (int x = p.getX(), Y = p.getY(); x < width && Y < height; x += Tile.rectSize) {
			addEnterableTile(x, Y);
			if(isPieceObstructing(this, x, Y)) {
				break;
			}
			Y += Tile.rectSize;
		}
		for (int x = p.getX(), Y = p.getY(); x > -Tile.rectSize && Y > -Tile.rectSize; x -= Tile.rectSize) {
			addEnterableTile(x, Y);
			if(isPieceObstructing(this, x, Y)) {
				break;
			}
			Y -= Tile.rectSize;
		}
		for (int x = p.getX(), Y = p.getY(); x > -Tile.rectSize && Y < height; x -= Tile.rectSize) {
			addEnterableTile(x, Y);
			if(isPieceObstructing(this, x, Y)) {
				break;
			}
			Y += Tile.rectSize;
		}
		for (int x = p.getX(), Y = p.getY(); x < width && Y > -Tile.rectSize; x += Tile.rectSize) {
			addEnterableTile(x, Y);
			if(isPieceObstructing(this, x, Y)) {
				break;
			}
			Y -= Tile.rectSize;
		}
	}
	
	public void loadEnterableTilesRook() {
        Game.g.setColor(Color.red);
        for (int x = this.p.getX(); x < width; x += Tile.rectSize) {
            addEnterableTile(x, this.p.getY());
            if (isPieceObstructing(this, x, p.getY())) {
                break;
            }
        }
        for (int x = this.p.getX(); x > -Tile.rectSize; x -= Tile.rectSize) {
            addEnterableTile(x, this.p.getY());
	        if(isPieceObstructing(this, x, p.getY())) {
		        break;
	        }
        }


        for (int y = this.p.getY(); y < width; y += Tile.rectSize) {
            addEnterableTile(this.p.getX(), y);
	        if(isPieceObstructing(this, p.getX(), y)) {
		        break;
	        }
        }
        for (int y = this.p.getY(); y > -Tile.rectSize; y -= Tile.rectSize) {
            addEnterableTile(this.p.getX(), y);
	        if(isPieceObstructing(this, p.getX(), y)) {
		        break;
	        }
        }
    }
	
	public void loadEnterableTilesKnight() {
		Game.g.setColor(Color.red);
		addEnterableTile(p.getX() + 2*Tile.rectSize, p.getY() + Tile.rectSize);
		addEnterableTile(p.getX() + 2*Tile.rectSize, p.getY() - Tile.rectSize);
		
		addEnterableTile(p.getX() - 2*Tile.rectSize, p.getY() + Tile.rectSize);
		addEnterableTile(p.getX() - 2*Tile.rectSize, p.getY() - Tile.rectSize);
		
		addEnterableTile(p.getX() + Tile.rectSize, p.getY() + 2*Tile.rectSize);
		addEnterableTile(p.getX() - Tile.rectSize, p.getY() + 2*Tile.rectSize);
		
		addEnterableTile(p.getX() + Tile.rectSize, p.getY() - 2*Tile.rectSize);
		addEnterableTile(p.getX() - Tile.rectSize, p.getY() - 2*Tile.rectSize);
	}
	
	public void loadEnterableTilesBishop() {
		Game.g.setColor(Color.red);
		//Diagonalen
		//Unten rechts
		for(int x = p.getX() + Tile.rectSize, Y = p.getY() + Tile.rectSize; x < width && Y < height; x += Tile.rectSize) {
			addEnterableTile(x, Y);
			if(isPieceObstructing(this, x, Y)) {
				break;
			}
			Y += Tile.rectSize;
		}
		//Oben links
		for(int x = p.getX() - Tile.rectSize, Y = p.getY() -Tile.rectSize; x > -Tile.rectSize && Y > -Tile.rectSize; x -= Tile.rectSize) {
			addEnterableTile(x, Y);
			if(isPieceObstructing(this, x, Y)) {
				break;
			}
			Y -= Tile.rectSize;
		}
		//Unten links
		for(int x = p.getX() - Tile.rectSize, Y = p.getY() + Tile.rectSize; x > -Tile.rectSize && Y < height; x -= Tile.rectSize) {
			addEnterableTile(x, Y);
			if(isPieceObstructing(this, x, Y)) {
				break;
			}
			Y += Tile.rectSize;
		}
		//Oben rechts
		for(int x = p.getX() + Tile.rectSize, Y = p.getY() - Tile.rectSize; x < width && Y > -Tile.rectSize; x += Tile.rectSize) {
			addEnterableTile(x, Y);
			if(isPieceObstructing(this, x, Y)) {
				break;
			}
			Y -= Tile.rectSize;
		}
	}

}