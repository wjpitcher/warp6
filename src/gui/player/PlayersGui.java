package gui.player;

import java.awt.FlowLayout;
import javax.swing.JPanel;

import player.Players;

@SuppressWarnings("serial")
public class PlayersGui extends javax.swing.JPanel {
	private Players _players = null;
	private int ActivePlayer = 0;
	
	public PlayersGui(player.Players players){

		setPlayers(players);
		//this.setLayout( new FlowLayout() );

	}
	
	public void setPlayers(Players players){
		_players = players;
		for(int i = 0; i < players.players.length; i++){
			this.add(new PlayerGui(players.players[i]));
		}
		
		((PlayerGui) getComponent(ActivePlayer)).setActive(true);
	}
	
	public void NextPlayer(){

		((PlayerGui) getComponent(ActivePlayer)).setActive(false);
		
		ActivePlayer = (ActivePlayer + 1) % getComponentCount();

		((PlayerGui) getComponent(ActivePlayer)).setActive(true);
	}
}
