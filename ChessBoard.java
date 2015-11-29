package ChessGame;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class ChessBoard extends JComponent{
	private JButton[][] face;
	private static final long serialVersionUID = 1L;
	private Game game;
	private boolean hasPiece=false;
	private Point start,end;
	private JPanel front;
	private ImageIcon pie;
	private JFrame b;
	
	public ChessBoard(JFrame a) {
		b=a;
		game = new Game();
		end=new Point();
		start= new Point();
	    
	    face=new JButton[8][8];
		
	    front=new JPanel();
	    front.setLayout(new GridLayout(8,8,0,0));
	    front.setVisible(true);
	    front.setSize(new Dimension(62*8,62*8));
	    boolean black=false;
	    //Because grid Layout adds left to right row before column
	    for(int r=0;r<8;r++){
	    	black= !black;
	    	for(int c=0;c<8;c++){
	    		black= !black;
	    		//sets picture 
	    		if(game.getPiece(c, r)!=null){
	    		pie= new ImageIcon(game.getPiece(c,r).getImg());
	    		face[c][r]= new JButton(pie);
	    		}
	    		else{
	    			face[c][r]= new JButton();
	    		}
	    		//sets base color
	    		if(black){
	    			face[c][r].setBackground(Color.DARK_GRAY);
	    		}
	    		else{
	    			face[c][r].setBackground(Color.white);
	    		}
//	    		face[c][r].setName(c+r+"");
	    		face[c][r].addActionListener(new HiddenFace());
	    		front.add(face[c][r]);
	    	}
	    }
	    
	    a.add(front); 
	}
	/** 
	 * Should this go inside it's own separate class?
	 **/
	public class HiddenFace implements ActionListener{

		public void actionPerformed(ActionEvent e){
			//Loops through every piece on the board
			if(game.checkWin()){
				JOptionPane.showMessageDialog(null, game.getTurn()+" Wins");
				b.dispose();
			}
			for(int c=0;c<8;c++){
				for(int r=0;r<8;r++){
					//Looks for the selected piece
					if(face[c][r]==e.getSource()){
						if(!hasPiece){
							start.setLocation(c,r);
							//checks for a valid piece then highlights it
							if(game.getPiece(start.x,start.y)!=null){
//								System.out.println("Select");
								hasPiece=true;
								face[start.x][start.y].setBorder(BorderFactory.createLineBorder(Color.red));
							}
							if(game.checkWin()){
								JOptionPane.showMessageDialog(null, game.getTurn()+" Wins");
								b.dispose();
							}
						}
						else{
							end.setLocation(c,r);
							//checks if the piece was selected twice
							if(start.x==end.x && start.y ==end.y){
								System.out.println("reset");
								hasPiece=false;
								face[start.x][start.y].setBorder(null);
							}
							//tests if the move is valid
							else if(game.movePiece(start.x,start.y,  end.x,  end.y)){
								hasPiece=false;
								//Finalizes player move
								face[end.x][end.y].setIcon(face[start.x][start.y].getIcon());
								face[start.x][start.y].setIcon(null);
								face[start.x][start.y].setBorder(null);
								if(game.checkWin()){
									JOptionPane.showMessageDialog(null, game.getTurn()+" Wins");
									b.dispose();
								}
								//AI call
								//getMix returns the object that is the ai from the game.
								Movement tmp= game.getMix().makeMove(game.getBoard(), game.getSides());
		
//								System.out.println(tmp.getStartX()+" "+tmp.getStartY()+" sent choice start values");
//								System.out.println(tmp.getEndX()+" "+tmp.getEndY()+" sent choice end values");
//								System.out.println(game.getPiece(tmp.getStartX(),tmp.getStartY())+" sent choice piece");
								
								
								game.movePiece(tmp.getStartX(),tmp.getStartY(),  tmp.getEndX(), tmp.getEndY());
								face[tmp.getEndX()][tmp.getEndY()].setIcon(face[tmp.getStartX()][tmp.getStartY()].getIcon());
								face[tmp.getStartX()][tmp.getStartY()].setIcon(null);

								// Only called if a valid move was made...else problems
								if(game.checkWin()){
									JOptionPane.showMessageDialog(null, game.getTurn()+" Wins");
									b.dispose();
								}
							
//								game.test(game.getBoard());			
							}
							else{
								System.out.println("Invalid move");
								hasPiece=false;
								face[start.x][start.y].setBorder(null);
								if(game.checkWin()){
									JOptionPane.showMessageDialog(null, game.getTurn()+" Wins");
									b.dispose();
								}
							}
						
					}

				}
				
			}

		}
		//Loop to show valid moves else ignore
		for(int c=0;c<8;c++){
			for(int r=0;r<8;r++){
				if(hasPiece && game.getPiece( start.x,start.y)!=null && game.getPiece( start.x, start.y).moveTst(c, r, game.getSides())) {
					face[c][r].setBorder(BorderFactory.createLineBorder(Color.green));
					}
				else if(start.x ==c && start.y ==r){
				}
				else if(!hasPiece){
					face[c][r].setBorder(null);
				}

			}
		}

	}

}

}
