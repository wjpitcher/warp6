package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.lang.model.element.Element;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import board.Board;
import board.Node;
import gui.board.BoardGui;
import gui.board.GuiElement;
import gui.board.NodeGui;
import gui.player.PlayerGui;
import gui.player.PlayersGui;
import gui.ships.FastShipGui;
import layoutMangers.SingleFitLayout;
import player.Player;
import ships.FastShip;

@SuppressWarnings("serial")
public class MainForm extends JFrame {

	public MainForm(boolean setVisible){
		super("Warp 6");
		JPanel boardPanel = new JPanel();
		boardPanel.setLayout(new SingleFitLayout());
		boardPanel.add(new BoardGui());
		PlayersGui playerslist =  new PlayersGui();

		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
		this.setLayout( new BorderLayout() );
		setSize(500, 500);
		// player.Players playerslist  = new player.Players();
		System.out.println("test1");
		Player newPlayer = new Player("Player1", Color.blue);
		playerslist.Add(new PlayerGui(newPlayer));
		System.out.println("test2");
		playerslist.Add(new PlayerGui("Player2", Color.red));
		System.out.println("test3");
		playerslist.Add(new PlayerGui("Player3", Color.green));
		System.out.println("test4");
		this.add( BorderLayout.NORTH,  playerslist );
		System.out.println("test1");
		this.add( "Center", boardPanel);

		JPanel elemTest = new JPanel();
		elemTest.setSize(new Dimension(100, 100));
		elemTest.setPreferredSize(new Dimension(100, 100));
		elemTest.add(new FastShipGui(Color.blue, new NodeGui(1, new Board(), 25, 25, 25.0)));
		elemTest.add(new NodeGui(1, new Board(), .5, .5, .25));	
		this.add( "East", elemTest);
	/*	

		this.add( "East", elemTest);
	*/	
		
		
		this.setIconImage(new ImageIcon("img/Warp6Icon.png").getImage());
		
		this.setVisible(setVisible);
	}
}
