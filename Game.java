package ChessGame;
/**
 * @author Alex
 *
 */
public class Game {
	//movement is the change in position old to new.
	// Each piece type is called only once.
	//if  bishop queen rook pawn.attack knight move ==king.space check
	//if king!=valid move game over
	//board is an [8][8] grid of type Side

//	private static final long serialVersionUID = -1L;
	private Piece [][] board;
	private Side[][] sides;
	/**
	 * @return the sides
	 */
	public Side[][] getSides() {
		return sides;
	}
	private Side turn;
	private FirstAI mix;
//	private int column;
//	private int row;
//	private double[][] aiBoard;
	

	/**
	 * @return the mix
	 */
	public FirstAI getMix() {
		return mix;
	}
	/**********************************************************************
	 * Primary Constructor
	 * Sets up the initial board
	 **********************************************************************/
	public Game(){
//8 by 8 game boards 
		board= new Piece [8][8];
		sides= new Side [8][8];
		turn = Side.White;
//		 aiBoard = new double[8][8];
		 
//loops through to give each space on the board a starting value
		for (int c=0;c<8;c++){
			for(int r=0;r<8;r++){
				board[c][r]=null;
				sides[c][r]=Side.Empty;
			}

//SETS THE STARTING LOCATION OF PAWNS AND GENERATES THE PIECES
			board[c][6]= new Pawn(Side.White,c,6);
			board[c][1]= new Pawn(Side.Black,c,1);
			sides[c][6]= Side.White;
			sides[c][7]= Side.White;
			sides[c][0]= Side.Black;
			sides[c][1]= Side.Black;
			
		}
//PLACES THE STARTING White POSITIONS
			board[7][0]=new Rook(Side.Black,7,0);
			board[6][0]=new Knight(Side.Black,6,0);
			board[5][0]=new Bishop(Side.Black,5,0);
			board[3][0]=new Queen(Side.Black,3,0);
			board[4][0]=new King(Side.Black,4,0);
			board[2][0]=new Bishop(Side.Black,2,0);
			board[1][0]=new Knight(Side.Black,1,0);
			board[0][0]=new Rook(Side.Black,0,0);

//PLACES THE STARTING Black POSITIONS 
			board[7][7]=new Rook(Side.White,7,7);
			board[6][7]=new Knight(Side.White,6,7);
			board[5][7]=new Bishop(Side.White,5,7);
			board[3][7]=new Queen(Side.White,3,7);
			board[4][7]=new King(Side.White,4,7);
			board[2][7]=new Bishop(Side.White,2,7);
			board[1][7]=new Knight(Side.White,1,7);
			board[0][7]=new Rook(Side.White,0,7);

//Call the AI
			mix=new FirstAI();

//FOR PURPOSES OF TESTING PRINTS EACH ROW
//				test( board);
		}
/**
	 * @return the board
	 */
	public Piece[][] getBoard() {
		return board;
	}
/**********************************************************************
 * Secondary constructor to evaluate possible AI moves
 * Need To Implement a switch for AI going first in 3rd Release
 **********************************************************************/
	public  Game(Piece[][] startBoard,Side [][] temp){
		// makes a duplicate board for planning moves

		board= startBoard;
		sides=temp;
//			turn=who;
//FOR PURPOSES OF TESTING PRINTS EACH ROW
//		test( board);
	}
	
	/**********************************************************************
	 * Moves the selected piece to a selected square.
	 * starting position -> end position
	 * @param int
	 * @param int
	 * @param int
	 * @param int
	 * @return Boolean
	 **********************************************************************/
	public Boolean movePiece(int startCol,int startRow,int endCol,int endRow){
		// terminates if null
		if(board[startCol][startRow] ==null){
			return false;
		}
		if(turn==board[startCol][startRow].getSide()){
		//gets a specific piece then asks if it can move to a specified square
			if(board[startCol][startRow].move(endCol, endRow, sides)){
				board[endCol][endRow]=board[startCol][startRow];
				board[startCol][startRow]=null;
				sides[startCol][startRow]=Side.Empty;
				sides[endCol][endRow]=board[endCol][endRow].getSide();
				advTurn();
				return true;
			}
			else if(board[startCol][startRow] ==null){
				
			}
		}
		
		return false;
	}
	/**********************************************************************
	 * Advances the turn to the next player.
	 **********************************************************************/
	private void advTurn(){
		if(turn==Side.White){
			turn=Side.Black;
		}
		else if(turn==Side.Black){
			turn=Side.White;
		}
	}
	/**********************************************************************
	 * Returns a numerical output of the board.
	 * @Peram Piece[][]
	 **********************************************************************/
	public static void test(Piece[][] board){
		//FOR PURPOSES OF TESTING PRINTS EACH ROW
		for (int row2=0;row2<8;row2++){
			for (int col=0;col<8;col++){
				if (col== 0 ){
					System.out.println();
				}
				if(board[col][row2]!=null){
					System.out.print(board[col][row2].getValue()+" ");
				}
				else{
					System.out.print("0 ");
				}
				
			}
		}

	}

	/***********************************************************************
	 * @return the piece value
	 **********************************************************************/
	public int getPieceVal(int col, int row) {
		if(board[col][row]!=null){
			return board[col][row].getValue();
		}
		return 0;
		
	}
	/***********************************************************************
	 * @return the piece 
	 **********************************************************************/
	public Piece getPiece(int col, int row) {
			return board[col][row];
	}
	/**********************************************************************
	 * Checks for a winning state and then ends the game if found
	 **********************************************************************/
	public boolean checkWin(){
		boolean win = true;
		//White just moved
		if(turn !=Side.White){
			for(int c=0;c<8 && win==true;c++){
				for(int r=0;r<8 && win==true;r++){
					if(board[c][r]!=null){
						if( board[c][r].getValue()==10 && board[c][r].getSide()==Side.Black)
							return false;
					}
				}
			}
			turn =Side.White;
		}
		//Black just moved
		else if(turn !=Side.Black){
			for(int c=0;c<8&&win==true;c++){
				for(int r=0;r<8&&win==true;r++){
					if(board[c][r]!=null){
						if(board[c][r].getValue()==10 && board[c][r].getSide()==Side.White){
							return false;
						}
					}
				}
			}
			turn =Side.Black;
		}
		//ends the game as "empty" will never have a turn.
		//turn=Side.Empty;
		return true;
	}
	
	/**
	 * @return the turn
	 */
	public Side getTurn() {
		return turn;
	}
	/**********************************************************************
	 * System testing
	 **********************************************************************/
	public static void main(String[] args){
		Game test;
		int col=0;
		int row=3;
		test=new Game();
		test.movePiece(1, 7, 2, 5);		//white
		if(test.checkWin())
			System.out.println("Game");
		test.movePiece(0, 1, col, row);	//Black
		if(test.checkWin())
			System.out.println("Game");
		test.movePiece(1, 6, 1, 5);		//White
		if(test.checkWin())
			System.out.println("Game");
		test.movePiece(0, 3, 0, 4);		//Black
		if(test.checkWin())
			System.out.println("Game");
		test.movePiece(2, 5, 0, 4);		//White
		if(test.checkWin())
			System.out.println("Game");
		test.movePiece(0, 0, 0, 4);		//Black
		if(test.checkWin())
			System.out.println("Game");
		test.movePiece(0, 6, 0, 5);		//White
		if(test.checkWin())
			System.out.println("Game");
		test.movePiece(0, 4, 7, 4);		//Black
		if(test.checkWin())
			System.out.println("Game");
		test.movePiece(0, 5, 0, 4);		//White
		if(test.checkWin())
			System.out.println("Game");
		test.movePiece(7, 4, 0, 4);		//Black
		if(test.checkWin())
			System.out.println("Game");
		test.movePiece(0, 7, 0, 4);		//White
		if(test.checkWin())
			System.out.println("Game");
		test.movePiece(1, 0, 2, 2);		//Black
		if(test.checkWin())
			System.out.println("Game");
		test.movePiece(0, 4, 0, 0);		//White
		if(test.checkWin())
			System.out.println("Game");
		test.movePiece(3, 1, 3, 3);		//Black
		if(test.checkWin())
			System.out.println("Game5");
		test.movePiece(0, 0, 1, 0);		//White
		if(test.checkWin())
			System.out.println("Game4");
		test.movePiece(3, 0, 3, 1);		//Black
		if(test.checkWin())
			System.out.println("Game3");
		test.movePiece(1, 0, 2, 0);		//White
		if(test.checkWin())
			System.out.println("Game2");
		test.movePiece(3, 1, 7, 5);		//Black
		if(test.checkWin())
			System.out.println("Game1");
		test.movePiece(2, 0, 4, 0);		//White
		//test(board);
		if(test.checkWin())
			System.out.println("Game6");
		test.movePiece(1, 1, 1, 2);		//Black
		System.out.println();
		//test(board);
		return ;
	}

}