package player;

import java.util.Arrays;
import ships.*;

public class Players implements IPlayers{
	public IPlayer[] players = {};
	public int activePlayer = 0;
	private Fleet fleet;
	
	public Players(){
		fleet = new Fleet();
		fleet.add("Fast",2);
		fleet.add("Medium",3);
		fleet.add("Slow",4);
	}
	
	public void Add(IPlayer player){	
		if(players == null)
			players = new IPlayer[1];	
		else
			players = Arrays.copyOf(players, players.length + 1);
		
		players[players.length -1] = player;
	}
	
	public boolean setup(int maxNode){
		for(int i = 0; i < players.length; i++){
		
			try {
				players[i].setShips(fleet.generateFleet());
			} catch (Exception e) {
				System.out.println(e.toString());
				return false;
			}
			for(int j = 0; j < players[i].getShips().length; j++){
				// maxnode - current Ship Index * the number of players 
				//         - current Players Index 
				players[i].getShips()[j].setIndex(maxNode - j * players.length - i);
			}
		}
	
		return true;
	}
	
	public boolean isNodeOpen(int index){
		
		for (int i = 0; i < players.length; i++)
			for(int j = 0; j < players[i].getShips().length; j++)
				if(players[i].getShips()[j].getIndex() == index)
					return false;
		
		return true;
	}

	@Override
	public IPlayer[] getPlayers() {
		
		return players;
	}

	@Override
	public IPlayer getActivePlayers() {
		return players[activePlayer];
	}

	@Override
	public IPlayer NextPlayer() {
		return players[++activePlayer % players.length];
	}

}
