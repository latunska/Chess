package ChessGame;

import static org.junit.Assert.*;

import org.junit.Test;

public class ChessTest1 {

	@Test
	public void findPawn() {
		Game game=new Game();
		Object a= game.getPiece(0,1);
//		System.out.println(a.getClass());
		assertEquals(((Piece) a).getSide(),Side.Black);

	}
	@Test
	public void findKing() {
		Game game=new Game();
		Object a= game.getPiece(4,0);
		System.out.println();
		System.out.println(a.getClass());
		System.out.println(((Piece) a).getValue());
		assertEquals(((Piece) a).getValue(),10);

	}
	
	@Test
	public void findRook() {
		Game game=new Game();
		Object a= game.getPiece(0,0);
//		System.out.println(a.getClass());
		
		assertEquals(((Piece) a).getSide(),Side.Black);

	}
	@Test
	public void findKnight() {
		Game game=new Game();
		Object a= game.getPiece(6,0);
//		System.out.println(a.getClass());
		assertEquals(((Piece) a).getSide(),Side.Black);

	}
	@Test
	public void getterpawn() {
		Pawn k1=new Pawn(Side.White,3,5);
		assertEquals(k1.getColumn(), 3);
		assertEquals(k1.getRow(), 5);
		assertEquals(k1.getSide(), Side.White);
		assertEquals(k1.getValue(), 1);
	}
	@Test
	public void getterKnight() {
		Knight k1=new Knight(Side.White,3,5);
		assertEquals(k1.getColumn(), 3);
		assertEquals(k1.getRow(), 5);
		assertEquals(k1.getSide(), Side.White);
		assertEquals(k1.getValue(), 3);
	}
	@Test
	public void getterRook() {
		Rook k1=new Rook(Side.White,3,5);
		assertEquals(k1.getColumn(), 3);
		assertEquals(k1.getRow(), 5);
		assertEquals(k1.getSide(), Side.White);
		assertEquals(k1.getValue(), 5);
	}
	@Test
	public void getterBishop() {
		Bishop k1=new Bishop(Side.White,3,5);
		assertEquals(k1.getColumn(), 3);
		assertEquals(k1.getRow(), 5);
		assertEquals(k1.getSide(), Side.White);
		assertEquals(k1.getValue(), 4);
	}
	@Test
	public void getterQueen() {
		Queen k1=new Queen(Side.White,3,5);
		assertEquals(k1.getColumn(), 3);
		assertEquals(k1.getRow(), 5);
		assertEquals(k1.getSide(), Side.White);
		assertEquals(k1.getValue(), 9);
	}
	@Test
	public void getterKing() {
		King k1=new King(Side.White,3,5);
		assertEquals(k1.getColumn(), 3);
		assertEquals(k1.getRow(), 5);
		assertEquals(k1.getSide(), Side.White);
		assertEquals(k1.getValue(), 10);
	}
	@Test
	public void King() {
		Side[][] side;
		side =new Side[8][8];
		for(int c=0;c<8;c++){
			for(int r=0;r<8;r++)
				side[c][r]=Side.Empty;
		}
		King k1=new King(Side.White,3,5);
		assertEquals(k1.move(3, 4,side), true);
		assertEquals(k1.move(3, 3, side),true);
		assertEquals(k1.move(2, 2, side),true);
		assertEquals(k1.move(1, 1,side), true);
		assertEquals(k1.move(0, 3,side), false);
		assertEquals(k1.move(1, 6,side), false);
	}
	@Test
	public void testKnightMove1() {
		Side[][] side;
		side =new Side[6][6];
		for(int c=0;c<6;c++){
			for(int r=0;r<6;r++)
				side[c][r]=Side.Empty;
		}
		Knight k1=new Knight(Side.White,3,5);
		
		assertEquals(k1.move(4, 3,side), true);

		
	}
	@Test
	public void testKnightMove2() {
		Side[][] side;
		side =new Side[6][6];
		for(int c=0;c<6;c++){
			for(int r=0;r<6;r++)
				side[c][r]=Side.Empty;
		}
		Knight k1=new Knight(Side.White,3,5);
		assertEquals(k1.move(5, 4,side), true);
		
	}
	@Test
	public void testKnightMove3() {
		Side[][] side;
		side =new Side[8][8];
		for(int c=0;c<8;c++){
			for(int r=0;r<8;r++)
				side[c][r]=Side.Empty;
		}
		Knight k1=new Knight(Side.White,3,5);
		assertEquals(k1.move(5, 6,side), true);
		
	}
	@Test
	public void testKnightMove4() {
		Side[][] side;
		side =new Side[8][8];
		for(int c=0;c<8;c++){
			for(int r=0;r<8;r++)
				side[c][r]=Side.Empty;
		}
		Knight k1=new Knight(Side.White,3,5);
		assertEquals(k1.move(4, 7,side), true);
		
	}
	@Test
	public void testKnightMove5() {
		Side[][] side;
		side =new Side[8][8];
		for(int c=0;c<8;c++){
			for(int r=0;r<8;r++)
				side[c][r]=Side.Empty;
		}
		Knight k1=new Knight(Side.White,3,5);
		assertEquals(k1.move(2, 7,side), true);
		
	}
	@Test
	public void testKnightMove6() {
		Side[][] side;
		side =new Side[8][8];
		for(int c=0;c<8;c++){
			for(int r=0;r<8;r++)
				side[c][r]=Side.Empty;
		}
		Knight k1=new Knight(Side.White,3,5);
		assertEquals(k1.move(1, 6,side), true);
		
	}
	@Test
	public void testKnightMove7() {
		Side[][] side;
		side =new Side[6][6];
		for(int c=0;c<6;c++){
			for(int r=0;r<6;r++)
			side[c][r]=Side.Empty;
		}
		Knight k1=new Knight(Side.White,3,5);
		assertEquals(k1.move(1, 4,side), true);
		
	}
	@Test
	public void testKnightMove8() {
		Side[][] side;
		side =new Side[6][6];
		for(int c=0;c<6;c++){
			for(int r=0;r<6;r++)
			side[c][r]=Side.Empty;
		}
		Knight k1=new Knight(Side.White,3,5);
		assertEquals(k1.move(2, 3,side), true);
		
	}
	@Test
	public void testKnightMove9() {
		Side[][] side;
		side =new Side[6][6];
		for(int c=0;c<6;c++){
			for(int r=0;r<6;r++)
			side[c][r]=Side.Empty;
		}
		Knight k1=new Knight(Side.White,3,5);
		assertEquals(k1.move(2, 4,side), false);
		
	}
	@Test
	public void testKnightMove10() {
		Side[][] side;
		side =new Side[6][6];
		for(int c=0;c<6;c++){
			for(int r=0;r<6;r++)
			side[c][r]=Side.Empty;
		}
		Knight k1=new Knight(Side.White,3,5);
		k1.move(2, 3,side);
		assertEquals(k1.move(1, 1,side), true);
		
	}
	@Test
	public void testPawnMove1() {
		Side[][] side;
		side =new Side[8][8];
		side[2][2]=Side.Empty;
		Pawn p1=new Pawn(Side.White,2,1);
		assertEquals(p1.move(2, 2,side), true);
	}
	@Test
	public void testPawnMove2() {
		Side[][] side;
		side =new Side[8][8];
		side[2][3]=Side.Empty;
		Pawn p1=new Pawn(Side.Black,2,1);
		assertEquals(p1.move(2, 3,side), true);
	}
	@Test
	public void testPawnMove3() {
		Pawn p1=new Pawn(Side.White,2,2);
		Side[][] side;
		side =new Side[8][8];
		side[2][4]=Side.Empty;
		assertEquals(p1.move(2, 4,side), false);
	}
	@Test
	public void testPawnMove4() {
		Side[][] side;
		side =new Side[8][8];
		side[2][2]=Side.Black;
		Pawn p1=new Pawn(Side.White,2,1);

		assertEquals(p1.move(2, 2,side), false);
	}
	@Test
	public void testPawnMove5() {
		Side[][] side;
		side =new Side[8][8];
		side[3][2]=Side.Black;
		Pawn p1=new Pawn(Side.White,2,1);

		assertEquals(p1.move(3, 2,side), true);
	}
	@Test
	public void testPawnMove6() {
		Side[][] side;
		side =new Side[8][8];
		side[1][2]=Side.Black;
		Pawn p1=new Pawn(Side.White,2,1);

		assertEquals(p1.move(1, 2,side), true);
	}
	@Test
	public void testPawnMove7() {
		Side[][] side;
		side =new Side[8][8];
		side[1][2]=Side.White;
		Pawn p1=new Pawn(Side.White,2,1);
		
		assertEquals(p1.move(1, 2,side), false);
	}
	@Test
	public void testPawnMove8() {
		Side[][] side;
		side =new Side[8][8];
		side[1][2]=Side.Empty;
		Pawn p1=new Pawn(Side.White,2,1);
		assertEquals(p1.move(1, 2,side), false);
	}
	@Test
	public void testPawnMove9() {
		Side[][] side;
		side =new Side[8][8];
		side[2][5]=Side.Empty;
		Pawn p1=new Pawn(Side.Black,2,6);
		assertEquals(p1.move(2, 5,side), true);
	}
	@Test
	public void testPawnMove10() {
		Side[][] side;
		side =new Side[8][8];
		side[2][4]=Side.Empty;
		Pawn p1=new Pawn(Side.White,2,6);
		assertEquals(p1.move(2, 4,side), true);
	}
	@Test
	public void testPawnMove11() {
		Side[][] side;
		side =new Side[8][8];
		side[2][3]=Side.Empty;
		Pawn p1=new Pawn(Side.Black,2,6);
		assertEquals(p1.move(2, 3,side), false);
	}
	@Test
	public void testPawnMove12() {
		Side[][] side;
		side =new Side[8][8];
		side[2][3]=Side.Empty;
		Pawn p1=new Pawn(Side.White,2,1);
		assertEquals(p1.move(2, 3,side), false);
	}

@Test
public void testPawnMove13() {
	Side[][] side;
	side =new Side[8][8];
	side[2][2]=Side.Black;
	Pawn p1=new Pawn(Side.White,2,1);
	Pawn p2=new Pawn(Side.Black,2,2);
	assertEquals(p1.move(2, 3,side), false);
	assertEquals(p2.getSide(), Side.Black);
}
@Test
public void testPawnMove14() {
	Side[][] side;
	side =new Side[8][8];
	side[2][4]=Side.Empty;
	Pawn p1=new Pawn(Side.White,2,6);
	assertEquals(p1.move(2, 4,side), true);
}
@Test
public void testPawnMove15() {
	Side[][] side;
	side =new Side[6][6];
	side[2][4]=Side.White;
	Pawn p1=new Pawn(Side.Black,2,6);
	assertEquals(p1.move(2, 4,side), false);
}
@Test
public void testPawnMove16() {
	Side[][] side;
	side =new Side[6][6];
	for(int c=0;c<6;c++){
		for(int r=0;r<6;r++)
		side[c][r]=Side.Empty;
	}
	side[2][4]=Side.White;
	Pawn p1=new Pawn(Side.White,2,6);
	assertEquals(p1.move(2, 4,side), false);
}
@Test
public void testPawnMove17() {
	Side[][] side;
	side =new Side[6][6];
	for(int c=0;c<6;c++){
		for(int r=0;r<6;r++)
		side[c][r]=Side.Empty;
	}
	Pawn p1=new Pawn(Side.Black,2,6);
	side[1][5]=Side.Black;
	assertEquals(p1.move(1, 5,side), false);
	side[1][5]=Side.White;
	assertEquals(p1.move(1, 5,side), true);
	side[1][2]=Side.White;
	assertEquals(p1.move(1, 2,side), false);
}
@Test
public void testQueenMove1() {
	Side[][] side;
	side =new Side[6][6];
	for(int c=0;c<6;c++){
		for(int r=0;r<6;r++)
		side[c][r]=Side.Empty;
	}
	Queen q1=new Queen(Side.White,0,0);
	side[3][0]=Side.Black;
	assertEquals(q1.move(4, 0,side), false);
}
@Test
public void testQueenMove2() {
	Side[][] side;
	side =new Side[6][6];
	for(int c=0;c<6;c++){
		for(int r=0;r<6;r++)
		side[c][r]=Side.Empty;
	}
	Queen q1=new Queen(Side.White,0,0);
	side[4][0]=Side.Black;
	assertEquals(q1.move(4, 0,side), true);
}
@Test
public void testQueenMove3() {
	Side[][] side;
	side =new Side[6][6];
	for(int c=0;c<6;c++){
		for(int r=0;r<6;r++)
		side[c][r]=Side.Empty;
	}
	Queen q1=new Queen(Side.White,0,0);
	side[5][0]=Side.Black;
	assertEquals(q1.move(4, 0,side), true);
}
@Test
public void testQueenMove4() {
	Side[][] side;
	side =new Side[8][8];
	for(int c=0;c<8;c++){
		for(int r=0;r<8;r++)
		side[c][r]=Side.Empty;
	}
	Queen q1=new Queen(Side.White,7,7);
	side[3][7]=Side.Black;
	assertEquals(q1.move(0, 7,side), false);
}
@Test
public void testQueenMove5() {
	Side[][] side;
	side =new Side[8][8];
	for(int c=0;c<8;c++){
		for(int r=0;r<8;r++)
		side[c][r]=Side.Empty;
	}
	Queen q1=new Queen(Side.White,7,7);
	side[3][7]=Side.Black;
	assertEquals(q1.move(4, 7,side), true);
}
@Test
public void testQueenMove6() {
	Side[][] side;
	side =new Side[8][8];
	for(int c=0;c<8;c++){
		for(int r=0;r<8;r++)
		side[c][r]=Side.Empty;
	}
	Queen q1=new Queen(Side.White,7,7);
	side[3][7]=Side.Black;
	assertEquals(q1.move(3, 7,side), true);
}
@Test
public void testQueenMove7() {
	Side[][] side;
	side =new Side[8][8];
	for(int c=0;c<8;c++){
		for(int r=0;r<8;r++)
		side[c][r]=Side.Empty;
	}
	Queen q1=new Queen(Side.White,7,7);
	side[3][7]=Side.White;
	assertEquals(q1.move(3, 7,side), false);
}
@Test
public void testQueenMove8() {
	Side[][] side;
	side =new Side[8][8];
	for(int c=0;c<8;c++){
		for(int r=0;r<8;r++)
		side[c][r]=Side.Empty;
	}
	Queen q1=new Queen(Side.White,7,7);
	side[7][3]=Side.White;
	assertEquals(q1.move(7, 3,side), false);
}
@Test
public void testQueenMove9() {
	Side[][] side;
	side =new Side[8][8];
	for(int c=0;c<8;c++){
		for(int r=0;r<8;r++)
		side[c][r]=Side.Empty;
	}
	Queen q1=new Queen(Side.White,7,0);
	side[7][3]=Side.White;
	assertEquals(q1.move(7, 3,side), false);
}
@Test
public void testQueenMove10() {
	Side[][] side;
	side =new Side[8][8];
	for(int c=0;c<8;c++){
		for(int r=0;r<8;r++)
		side[c][r]=Side.Empty;
	}
	Queen q1=new Queen(Side.White,7,7);
	side[7][3]=Side.Black;
	assertEquals(q1.move(7, 3,side), true);
}
@Test
public void testQueenMove11() {
	Side[][] side;
	side =new Side[8][8];
	for(int c=0;c<8;c++){
		for(int r=0;r<8;r++)
		side[c][r]=Side.Empty;
	}
	Queen q1=new Queen(Side.White,7,7);
	side[7][3]=Side.White;
	assertEquals(q1.move(7, 3,side), false);
}
@Test
public void testQueenMove12() {
	Side[][] side;
	side =new Side[8][8];
	for(int c=0;c<8;c++){
		for(int r=0;r<8;r++)
		side[c][r]=Side.Empty;
	}
	Queen q1=new Queen(Side.White,0,0);
	side[7][3]=Side.White;
	assertEquals(q1.move(7, 7,side), true);
}
@Test
public void testQueenMove13() {
	Side[][] side;
	side =new Side[8][8];
	for(int c=0;c<8;c++){
		for(int r=0;r<8;r++)
		side[c][r]=Side.Empty;
	}
	Queen q1=new Queen(Side.White,0,0);
	side[7][6]=Side.White;
	assertEquals(q1.move(7, 7,side), true);
}
@Test
public void testQueenMove14() {
	Side[][] side;
	side =new Side[8][8];
	for(int c=0;c<8;c++){
		for(int r=0;r<8;r++)
		side[c][r]=Side.Empty;
	}
	Queen q1=new Queen(Side.White,0,0);
	side[7][7]=Side.Black;
	side[1][1] = Side.White;
	assertEquals(q1.move(7, 7,side), false);
}
@Test
public void testQueenMove15() {
	Side[][] side;
	side =new Side[8][8];
	for(int c=0;c<8;c++){
		for(int r=0;r<8;r++)
		side[c][r]=Side.Empty;
	}
	Queen q1=new Queen(Side.White,7,0);
	side[7][3]=Side.White;
	assertEquals(q1.move(0, 7,side), true);
}
@Test
public void testQueenMove16() {
	Side[][] side;
	side =new Side[8][8];
	for(int c=0;c<8;c++){
		for(int r=0;r<8;r++)
		side[c][r]=Side.Empty;
	}
	Queen q1=new Queen(Side.White,0,7);
//	side[7][6]=Side.White;
	assertEquals(q1.move(7, 0,side), true);
}
@Test
public void testQueenMove17() {
	Side[][] side;
	side =new Side[8][8];
	for(int c=0;c<8;c++){
		for(int r=0;r<8;r++)
		side[c][r]=Side.Empty;
	}
	Queen q1=new Queen(Side.White,0,0);
	side[7][7]=Side.Black;
	side[1][1] = Side.White;
	assertEquals(q1.move(7, 7,side), false);
}
@Test
public void testRook1() {
	Side[][] side;
	side =new Side[8][8];
	for(int c=0;c<8;c++){
		for(int r=0;r<8;r++)
		side[c][r]=Side.Empty;
	}
	Rook r1=new Rook(Side.White,0,0);
	side[7][7]=Side.Black;

	assertEquals(r1.move(7, 7,side), false);
}
@Test
public void testRook2() {
	Side[][] side;
	side =new Side[8][8];
	for(int c=0;c<8;c++){
		for(int r=0;r<8;r++)
		side[c][r]=Side.Empty;
	}
	Rook r1=new Rook(Side.White,0,0);
	side[0][7]=Side.White;

	assertEquals(r1.move(0, 7,side), false);
}
@Test
public void testRook3() {
	Side[][] side;
	side =new Side[8][8];
	for(int c=0;c<8;c++){
		for(int r=0;r<8;r++)
		side[c][r]=Side.Empty;
	}
	Rook r1=new Rook(Side.White,0,0);
	r1.move(7, 0,side);
	r1.move(7, 7,side);
	r1.move(0, 7,side);
	r1.move(7, 0,side);
	r1.move(7, 7,side);
	r1.move(7, 0,side);
	assertEquals(r1.move(0, 0,side), true);
}
@Test
public void testBishop1() {
	Side[][] side;
	side =new Side[8][8];
	for(int c=0;c<8;c++){
		for(int r=0;r<8;r++)
		side[c][r]=Side.Empty;
	}
	Bishop r1=new Bishop(Side.White,0,0);
	r1.move(3, 3,side);
	r1.move(6, 0,side);
	r1.move(0, 6,side);
	r1.move(7, 2,side);
	r1.move(3, 3,side);
	r1.move(4, 4,side);
	assertEquals(r1.move(0, 0,side), true);
}

}

