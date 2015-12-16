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
import gui.ships.MediumShipGui;
import gui.ships.ShipGui;
import gui.ships.SlowShipGui;
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
		
		newPlayer = new Player("Player2", new Color(0xFF0000));
		playerslist.Add(new PlayerGui(newPlayer));
		
		newPlayer = new Player("Player3", new Color(0x28FF19));
		playerslist.Add(new PlayerGui(newPlayer));
		
		this.add( BorderLayout.NORTH,  playerslist );
		
		board.add(new SlowShipGui(Color.blue, board, 126));
		board.add(new MediumShipGui(Color.red, board, 125));
		board.add(new SlowShipGui(Color.green, board, 124));
		
		board.add(new FastShipGui(Color.blue, board, 123));
		board.add(new SlowShipGui(Color.red, board, 122));
		board.add(new MediumShipGui(Color.green, board, 121));
		
		board.add(new SlowShipGui(Color.blue, board, 120));
		board.add(new FastShipGui(Color.red, board, 119));
		board.add(new SlowShipGui(Color.green, board, 118));
		
		board.add(new MediumShipGui(Color.blue, board, 117));
		board.add(new SlowShipGui(Color.red, board, 116));
		board.add(new FastShipGui(Color.green, board, 115));
		
		board.add(new SlowShipGui(Color.blue, board, 114));
		board.add(new MediumShipGui(Color.red, board, 113));
		board.add(new SlowShipGui(Color.green, board, 112));
		
		board.add(new FastShipGui(Color.blue, board, 111));
		board.add(new MediumShipGui(Color.red, board, 110));
		board.add(new SlowShipGui(Color.green, board, 109));
		
		board.add(new MediumShipGui(Color.blue, board, 108));
		board.add(new SlowShipGui(Color.red, board, 107));
		board.add(new MediumShipGui(Color.green, board, 106));		
		
		board.add(new SlowShipGui(Color.blue, board, 105));
		board.add(new FastShipGui(Color.red, board, 104));
		board.add(new MediumShipGui(Color.green, board, 103));		

		board.add(new MediumShipGui(Color.blue, board, 102));
		board.add(new SlowShipGui(Color.red, board, 101));
		board.add(new FastShipGui(Color.green, board, 100));		
	
		this.add( "Center", boardPanel);

		
		this.setIconImage(new ImageIcon("img/Warp6Icon.png").getImage());
		
		this.setVisible(setVisible);
	}
	
	
}
