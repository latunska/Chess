package ChessGame;

import javax.swing.*;



public class ChessGame  {
	
		private static JFrame m=null;
		private static JFrame gameBoard=null;
		
		public ChessGame(JFrame k){
			gameBoard=k;
			
		}

	
	public static void main(String[] args) {
		if(gameBoard==null){
			m=new JFrame();
			Menu opt =new Menu(m);
			opt.playGame.addActionListener(new Listen());
			opt.exitToWindows.addActionListener(new Listen());
			opt.optionPage.addActionListener(new Listen());
					
		}
		//never reached
		else{
			System.out.println("Hello");
try{
				
				m.dispose();
			}	
			catch(Throwable NullPointerException){
				System.out.println(m+" ");
			}
			finally{
				
			}	
		}
	}
	




}
