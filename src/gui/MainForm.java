package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import board.Board;
import gui.board.BoardGui;
import gui.board.NodeGui;
import gui.player.PlayerGui;
import gui.player.PlayersGui;
import gui.ships.FastShipGui;
import gui.ships.ShipGui;
import layoutMangers.SingleFitLayout;
import player.Player;

@SuppressWarnings("serial")
public class MainForm extends JFrame {

	public MainForm(boolean setVisible){
		super("Warp 6");
		BoardGui board = new BoardGui();
		JPanel boardPanel = new JPanel();
		boardPanel.setLayout(new SingleFitLayout());
		boardPanel.add(board);
		PlayersGui playerslist =  new PlayersGui();

		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
		this.setLayout( new BorderLayout() );
		// java - get screen size using the Toolkit class
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int formsize = Math.min(screenSize.width
				             , screenSize.height)/4 * 3;
		
		setSize(formsize, formsize);
		
	
		Player newPlayer = new Player("Player1", new Color(0x0C9EFF));
		playerslist.Add(new PlayerGui(newPlayer));
		
		playerslist.Add(new PlayerGui("Player2", new Color(0xFF0000)));
		
		playerslist.Add(new PlayerGui("Player3",new  Color(0x28FF19)));
		
		this.add( BorderLayout.NORTH,  playerslist );
		
		this.add( "Center", boardPanel);
/*
	JPanel elemTest = new JPanel();
		elemTest.setSize(new Dimension(100, 100));
		elemTest.setPreferredSize(new Dimension(100, 100));
		elemTest.setBackground(Color.PINK);
		elemTest.add(new PlayerGui("Player2", Color.red));
		System.out.println(elemTest.getComponent(0).getX() + ", " + elemTest.getComponent(0).getY() + ", "
				         + elemTest.getComponent(0).getWidth() + ", " + elemTest.getComponent(0).getHeight() + elemTest.getComponent(0).getBackground()) ;
		//	elemTest.add(new ShipGui(null, .25, .75));
		
	//	elemTest.add(new ShipGui(null, 50, 50));
		//elemTest.add(new NodeGui(1, new Board(), .5, .5, .25));	
	//	this.add( "East", elemTest);
		/*	
	
		this.add( "East", elemTest);
	
	*/	
		
		this.setIconImage(new ImageIcon("img/Warp6Icon.png").getImage());
		
		this.setVisible(setVisible);
	}
}
