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
	
	public PlayersGui(){
		this(new Players());
	}
	
	public PlayersGui(IPlayers players){
		this.setLayout(new FlowLayout());
		setPlayers(players);
		this.setPreferredSize(new Dimension(10, 32));
	}
	
	public void setPlayers(IPlayers players){
		
		_players =  players;
		
		for(int i = 0; i < players.getPlayers().length; i++)
			this.Add(new PlayerGui(players.getPlayers()[i])); 
		
		if(players.getPlayers().length > 0 )
		 ((PlayerGui) _players.getPlayers()[0]).setActive(true);
	}
	
	@Override
	public IPlayer NextPlayer(){
		return _players.NextPlayer();	
	}

	@Override
	public void Add(IPlayer player) {
		
		if(!(player instanceof PlayerGui))
			player = new PlayerGui(player);
		
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
