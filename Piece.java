package ChessGame;

import java.awt.Graphics;
import java.awt.Image;

public interface Piece {
	public boolean move(int posCol, int posRow,  Side[][] mine);
	public void draw(Graphics g);
	
	public Side getSide();

	public int getRow();
	
	public int getColumn();
	public boolean moveTst(int posCol, int posRow,  Side[][] mine);

	public int getValue();
	public Image getImg();
	
}
