package ChessGame;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.*;

import javax.swing.*;

public class Listen implements ActionListener{
	JFrame m;
	public void actionPerformed(ActionEvent e){
		while (!(e.getSource() instanceof Component));
		if (((Component) e.getSource()).getName()=="playGame"){

			m= new JFrame();
			m.setName("Chess");
			//unlocked
//			m.setMinimumSize(new Dimension(512,534));
			//locked
			m.setMinimumSize(new Dimension(500,524));
			m.setResizable(false);
			m.setLocation(400,200);
			m.setVisible(true);
			m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			m.add(new ChessBoard(m));
			m.pack();
			new ChessGame(m);
		}
		else if (((Component) e.getSource()).getName()=="Options"){
			JOptionPane.showMessageDialog(null, "Options Page still not yet released at this time");
		}
		else if(((Component) e.getSource()).getName()=="Exit"){
			System.exit(0);
		}
		
	}
}
