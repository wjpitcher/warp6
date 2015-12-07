package player;

public interface IPlayers {

	public void Add(IPlayer player);
	
	public boolean setup(int maxNode);
	
	public IPlayer[] getPlayers();
	
	public IPlayer getActivePlayers();

	public IPlayer NextPlayer();
	
	public boolean isNodeOpen(int index);
}
