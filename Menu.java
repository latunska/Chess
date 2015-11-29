package ChessGame;

import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;

import javax.swing.*;
//import ChessGame.Listen;

public class Menu {
	protected JButton playGame;
	protected JButton optionPage;
	protected JButton exitToWindows;
	private JLabel fill;

	
	public Menu(JFrame menu){
//		menu=new JFrame();
		menu.setTitle("Chess");
		menu.setMinimumSize(new Dimension(300,300));;
		menu.setLocation(400,250);
		menu.setVisible(true);
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu.setLayout(new BorderLayout());
		//place panels in WEST border to place buttons
		Panel buttonPanel = new Panel(new GridLayout(4,4));
		//display
		ImageIcon playd = new ImageIcon("8TzKa4Kgc.png");
		Image im = playd.getImage();
		Image im2 = im.getScaledInstance(20, 20,0);
		 
		playGame = new JButton("Play Game");
		playGame.setName("playGame");
		playGame.setFont(new Font("Ariel", Font.BOLD,30));
		playGame.setIcon(new ImageIcon(im2));
		//place in button Panel
		optionPage = new JButton("Options");
		optionPage.setName("Options");
		optionPage.setFont(new Font("Ariel", Font.BOLD,30));
		//place in button Panel
		exitToWindows = new JButton("Exit to Desktop");
		exitToWindows.setName("Exit");
		exitToWindows.setFont(new Font("Ariel", Font.BOLD,30));

		//place in button Panel
		fill = new JLabel();
		fill.setForeground(Color.black);
		fill.setBackground(Color.black);
		fill.setOpaque(true);
		buttonPanel.add(fill);
		buttonPanel.add(playGame);
		buttonPanel.add(optionPage);
		buttonPanel.add(exitToWindows);
		menu.add (buttonPanel, BorderLayout.CENTER);
		menu.add (new JLabel(new ImageIcon("Chess.png")), BorderLayout.SOUTH);
		menu.pack();
	}	
}
