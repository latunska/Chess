/**
 * The knight class moves in a L shape in all directions.
 * primary variables set at creation 
 */
package ChessGame;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


/**
 * @author Alex Latunski
 *
 */
public class Knight implements Piece{
	private Side side;
	private int row;
	private int column;
	private int value;
	private BufferedImage img;
	
	/*
	 * Constructor sets side, localized board position Unique Identity
	 * 
	 */
	Knight(Side side, int col, int row) {
		this.side = side;
		this.row = row;
		this.column = col;
		this.value = 3;
		img = null;
		if (side == Side.White) {
			try {
				img = ImageIO.read(new File("whiteknight.png"));
			} catch (IOException e) {
				System.out.println("file not found");
			}
		} else {
			try {
				img = ImageIO.read(new File("blackknight.png"));
			} catch (IOException e) {
				System.out.println("filenotfound");
			}
		}
	}

	private boolean attack( Side mine) {
		if ( side != mine) {
			return true;
		} else
			return false;

	}

	public boolean move(int posCol,int posRow, Side[][] mine) {
		
			if (moveTst(posCol, posRow,  mine)){
					row=posRow;
					column=posCol;
					return true;
				}
		return false;
	}

	/**
	 * @return the side
	 */
	public Side getSide() {
		return side;
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
		if (attack( mine[posCol][posRow])) {
			if (((row - posRow) == 2 || (row - posRow) == -2)
					&& ((column - posCol) == 1 || (column - posCol)
						== -1)){		
					return true; 
				
			} else if (((row - posRow) == 1 || (row - posRow) == -1)
					&& ((column - posCol) == 2 || (column - posCol)
						== -2)) {
					return true;
			}
		}
		return false;
	}

	@Override
	public boolean isMoved() {
		// TODO Auto-generated method stub
		return false;
	}
}
