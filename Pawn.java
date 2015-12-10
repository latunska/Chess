package ChessGame;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


/**
 * @author Alex Latunski
 * 
 *
 */
public class Pawn implements Piece{
	// move turn if =0 move -- up to 2
	// attack opportunities
	private int row;
	private int column;
	private BufferedImage img;
	private int value;
	private Side side;

	Pawn(Side side, int col, int row) {
		this.side = side;
		this.row = row;
		this.column = col;
		this.value = 1;
		img = null;
		if (side == Side.White) {
			try {
				img = ImageIO.read(new File("whitepawn.png"));
			} catch (IOException e) {
				System.out.println("file not found");
			}
		} else {
			try {
				img = ImageIO.read(new File("blackpawn.png"));
			} catch (IOException e) {
				System.out.println("file not found");
			}
		}
	}

	/*
	 * Attack Pattern for Pawns not coded for EnPassant
	 */
	private boolean attack(Side mine) {
		if (mine != Side.Empty && side != mine) {
			return true;
		} else
			return false;

	}

	public boolean move(int posCol, int posRow,  Side[][] mine) {
		if(moveTst(posCol,posRow,mine)){
			row=posRow;
			column=posCol;
			return true;
		}
		return false;
	}

	/**
	 * @return the row
	 */
	public int getRow() {
		return row;
	}

	/**
	 * @return the column
	 */
	public int getColumn() {
		return column;
	}

	/**
	 * @return the side
	 */
	public Side getSide() {
		return side;
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(img, column*62, row*62, null);
	}

	@Override
	public BufferedImage getImg() {
		// TODO Auto-generated method stub
		return img;
	}

	@Override
	public boolean moveTst(int posCol, int posRow, Side[][] mine) {
		// checks piece is in starting space, checks the side,
		//makes sure the space moving into is empty
		if (row == 1 && side==Side.Black && posRow == 3 && mine[posCol][posRow] ==Side.Empty && posCol==column) {
			
			return true;
		}
		else if (row == 6 && side==Side.White && posRow == 4 && mine[posCol][posRow] ==Side.Empty && posCol == column) {
			
			return true;
		}
		else if (column==posCol &&mine[posCol][posRow]==Side.Empty && (((posRow-row==1)&& side==Side.Black)||
					((posRow-row==-1)&& side==Side.White))){
			return true;
		}
		// checks to ensure you move left/right then checks if it is 
		// only 1 space, finally checks if it is a valid attack 
		else if (column != posCol && (((posCol-column)==1) ||
					((posCol-column)==-1)) && (((posRow-row)==1 && side==Side.Black)||
						((posRow-row)==-1 && side==Side.White)) && attack(mine[posCol][posRow]))
							{
			return true;
		}
		return false;
	}

	@Override
	public boolean isMoved() {
		// TODO Auto-generated method stub
		return false;
	}
}
