package ChessGame;

import java.awt.Graphics;
import java.awt.Image;

public interface Piece {
	/**
	 * Moves the piece
	 */
	public boolean move(int posCol, int posRow,  Side[][] mine);
	/**
	 * Override for drawing image.
	 */
	public void draw(Graphics g);
	/**
	 * Returns the side a piece is on
	 */
	public Side getSide();
	/**
	 * Returns the row a piece is in
	 */
	public int getRow();
	/**
	 * Returns the column of a piece
	 */
	public int getColumn();
	/**
	 * Returns if the selected piece has a valid move
	 */
	public boolean moveTst(int posCol, int posRow,  Side[][] mine);
	/**
	 * Returns the integer value of a piece
	 */
	public int getValue();
	/**
	 * returns the piece icon
	 */
	public Image getImg();
	/**
	 * returns if a piece has moved used in checking for castling
	 */
	public boolean isMoved();
	
}
