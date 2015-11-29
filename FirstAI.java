package ChessGame;

import java.util.Random;
import java.util.Vector;

public class FirstAI implements AI {
	private Vector<Movement> possible;
	
	public FirstAI(){
		
	}
	
	@Override
	public Movement makeMove(Piece[][] bord,Side[][] n) {
		// TODO Auto-generated method stub
		possible=new Vector<Movement>();
		Game bestBoard;
		Random generator = new Random();
		bestBoard=new Game(bord,n);
//Loops through the board to attempt to find all valid
		for(int c=0;c<8;c++){
			for (int r=0;r<8;r++){
				if(bord[c][r]!=null && bord[c][r].getSide()==Side.Black){
				//Found a piece, can it make a valid move?
				//must..test..everything!
					for (int j=0;j<8;j++){
						for(int k=0;k<8;k++){
							if (bord[c][r].moveTst(j, k, n)){
								possible.add(new Movement(c,r,j,k,bord[c][r]));
//								System.out.println(possible.get(possible.size()-1).getStartX()+" "+ possible.get(possible.size()-1).getStartY()+" : "+possible.get(possible.size()-1).getEndX()+" "+possible.get(possible.size()-1).getEndY()+" Movement Value");
//								System.out.println(c+" "+r+" : "+j+" "+k+" ");
//								System.out.println(" ");
							}
						}
					}
				}
			}
		}
		int index = generator.nextInt(possible.size());
		int i=0;
		while(!(index<possible.size())){
			index = generator.nextInt(possible.size());
			i++;
			System.out.println("loop"+i);
		}
		Movement choice = possible.get(index);
//		System.out.println(index+" "+ possible.get(index).getStartX()+" "+possible.get(index).getStartY()+" choice");
		return choice;
	}
}
