package gui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import gui.board.BoardGui;
import layoutMangers.SingleFitLayout;

@SuppressWarnings("serial")
public class MainForm extends JFrame {

	public MainForm(boolean setVisible){
		super("Warp 6");
		JPanel boardPanel = new JPanel();
		boardPanel.setLayout(new SingleFitLayout());
		boardPanel.add(new BoardGui());
		
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
		this.setLayout( new BorderLayout() );
		setSize(500, 500);
		player.Players playerslist  = new player.Players();
		playerslist.Add(new player.Player("Player1", Color.CYAN));
		playerslist.Add(new player.Player("Player2", Color.PINK));
		playerslist.Add(new player.Player("Player3", Color.ORANGE));
		this.add( BorderLayout.NORTH,  new gui.player.PlayersGui(playerslist) );
	//	this.add( "South",  new JButton( "South" ) );
		//this.add( "East",   new JButton( "East" ) );
	//	this.add( "West",   new JButton( "West" ) );
		this.add( "Center", boardPanel);
		this.setIconImage(new ImageIcon("img/Warp6Icon.png").getImage());
		
		this.setVisible(setVisible);
	}
}
