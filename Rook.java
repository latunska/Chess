
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
public class Rook implements Piece{
	//rook1.move(rook1.obstruction())
	//if(obstruction!=
	private Side side;

	private int row;
	private int column;
	private int value;
	private BufferedImage img;
	
	/*
	 * Constructor sets side, localized board position Unique Identity
	 * 
	 */
	Rook(Side side, int col, int row) {
		this.side = side;
		this.row = row;
		this.column = col;
		this.value = 5;
		img = null;
		if (side == Side.White) {
			try {
				img = ImageIO.read(new File("whiterook.png"));
			} catch (IOException e) {
				System.out.println("file not found");
			}
		} else {
			try {
				img = ImageIO.read(new File("blackrook.png"));
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

	public boolean move(int posCol, int posRow,  Side[][] mine) {

		if(moveTst(posCol,posRow,mine)){
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
		g.drawImage(img, column*62, row*62, null);
		
	}

	@Override
	public BufferedImage getImg() {
		// TODO Auto-generated method stub
		return img;
	}

	@Override
	public boolean moveTst(int posCol, int posRow, Side[][] mine) {
		int r;
		int c;
		if(row==posRow && column<posCol){
			for( c=column+1;c<=posCol;c++){
				if (mine[c][posRow] != Side.Empty && c<posCol ) {
					return false; 
				}
				else if (!attack(mine[c][posRow])){
					return false;
				}
			}

				return true;
			
		}	
		else if(row==posRow && column>posCol){
			for( c=column-1;c>=posCol ;c--){
				if (mine[c][posRow] != Side.Empty && c>posCol ) {
					return false; 
				}
				else if (!attack(mine[c][posRow])){
					return false;
				}
			}	

				return true;
			
		}
			
		 if(row>posRow && column==posCol){
			for( r=row-1;r>=posRow ;r--){
				if (mine[posCol][r] != Side.Empty && r>posRow ) {
					
					return false; 
				}
				else if (!attack(mine[posCol][r])){
					return false;
				} 
			}
	

				return true;
			
		}
		else if(row<posRow && column==posCol){
			for( r=row+1;r<=posRow ;r++){
				if (mine[posCol][r] != Side.Empty && r<posRow ) {
					return false; 
				}
				else if (!attack(mine[posCol][r])){
					return false;
				} 
			}

			return true;
		}
		return false;
	}
}

