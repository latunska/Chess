
package ChessGame;

import java.awt.*;
import java.awt.image.BufferedImage;
//import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * @author Alex Latunski
 *
 */
public class Bishop implements Piece {
	// obstruction
	// if (obstruction&&side!=side.this)attack()
	private Side side;
	private int row;
	private int column;
	private int value;
	private BufferedImage img;

	/**
	 * @return the image
	 */
	public BufferedImage getImg() {
		return img;
	}

	/*
	 * Constructor sets side, localized board position Unique Identity
	 * 
	 */
	Bishop(Side side, int col, int row) {
		this.side = side;
		this.row = row;
		this.column = col;
		this.value = 4;
		img = null;
		if (side == Side.White) {
			try {
				img = ImageIO.read(new File("whitebishop.png"));
			} catch (IOException e) {
				System.out.println("file not found");
			}
		} else {
			try {
				img = ImageIO.read(new File("blackbishop.png"));
			} catch (IOException e) {
				System.out.println("filenotfound");
			}
		}
	}

	private boolean attack(Side mine) {
		if (side != mine) {
			return true;

		} else
			return false;

	}

	public boolean move(int posCol, int posRow, Side[][] mine) {
		if(moveTst(posCol,posRow,mine)){
			row = posRow;
			column = posCol;
			return true;
		}
		else{
			return false;
		}
		// if the iteration number is the same checks value otherwise, NEXT!
		
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
	public boolean moveTst(int posCol, int posRow, Side[][] mine) {
		int c;
		int r;
		if (row < posRow && column < posCol && ((posRow - row) == (posCol - column))) {
			for (r = row + 1; r <= posRow; r++) {
				for (c = column + 1; c <= posCol; c++) {
					if ((r - row) == (c - column)) {
						if (mine[c][r] != Side.Empty && r < posRow && c < posCol) {
							return false;
						} else if (!attack(mine[c][r])) {
							return false;
						}
					}
				}
			}


			return true;
		} else if (row < posRow && column > posCol && ((posRow - row) == (column - posCol))) {
			for (r = row + 1; r <= posRow; r++) {
				for (c = column - 1; c >= posCol; c--) {
					if ((r - row) == (column - c)) {
						if (mine[c][r] != Side.Empty && r < posRow && c > posCol) {
							return false;
						} else if (!attack(mine[c][r])) {
							return false;
						}
					}
				}
			}


			return true;

		} else if (row > posRow && column < posCol && ((row - posRow) == (posCol - column))) {
			for (r = row - 1; r >= posRow; r--) {
				for (c = column + 1; c <= posCol; c++) {
					if ((row - r) == (c - column)) {
						if (mine[c][r] != Side.Empty && r > posRow && c < posCol) {
							return false;
						} else if (!attack(mine[c][r])) {
							return false;
						}
					}
				}
			}

			return true;
		} else if (row > posRow && column > posCol && ((row - posRow) == (column - posCol))) {
			for (r = row - 1; r >= posRow; r--) {
				for (c = column - 1; c >= posCol; c--) {
					if ((row - r) == (column - c)) {
						if (mine[c][r] != Side.Empty && r > posRow && c > posCol) {
							return false;
						} else if (!attack(mine[c][r])) {
							return false;
						}
					}
				}
			}


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
