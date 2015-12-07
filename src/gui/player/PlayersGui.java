package gui.player;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JPanel;

import player.IPlayer;
import player.IPlayers;
import player.Players;

@SuppressWarnings("serial")
public class PlayersGui extends JPanel implements IPlayers{
	private IPlayers _players = null;

	public PlayersGui(IPlayers players){
		this.setLayout(new FlowLayout());
		_players = new Players();
		setPlayers(players);
		this.setPreferredSize(new Dimension(10, 30));
	}
	

	public PlayersGui(){
		this.setLayout(new FlowLayout());
		_players = new Players();
		this.setPreferredSize(new Dimension(10, 30));
	}
	
	public void setPlayers(IPlayers players){
		
		_players = new Players();
		
		for(int i = 0; i < players.getPlayers().length; i++)
			this.Add(new PlayerGui(players.getPlayers()[i])); 
		
		// ((PlayerGui) _players.getPlayers()).setActive(true);
	}
	
	@Override
	public IPlayer NextPlayer(){
		return _players.NextPlayer();	
	}

	@Override
	public void Add(IPlayer player) {
		_players.Add(player);
		this.add((PlayerGui)player);
	}

	@Override
	public boolean setup(int maxNode) {
		return _players.setup(maxNode);
	}

	@Override
	public boolean isNodeOpen(int index) {
		return _players.isNodeOpen(index);
	}

	@Override
	public IPlayer[] getPlayers() {
		return _players.getPlayers();
	}

	@Override
	public IPlayer getActivePlayers() {	
		return _players.getActivePlayers();
	}
}
