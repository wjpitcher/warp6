package player;

import java.util.Arrays;

import board.Board;
import ships.*;

public class Players {
	public Player[] players = {};
	
	private Fleet fleet;
	
	public Players(){
		fleet = new Fleet();
		fleet.add("Fast",2);
		fleet.add("Medium",3);
		fleet.add("Slow",4);
	}
	
	public void Add(Player player){	
		if(players == null)
			players = new Player[1];	
		else
			players = Arrays.copyOf(players, players.length + 1);
		
		players[players.length -1] = player;
	}
	
	public boolean setup(int maxNode){
		for(int i = 0; i < players.length; i++){
		
			try {
				players[i].ships = fleet.generateFleet();
			} catch (Exception e) {
				System.out.println(e.toString());
				return false;
			}
			for(int j = 0; j < players[i].ships.length; j++){
				// maxnode - current Ship Index * the number of players 
				//         - current Players Index 
				players[i].ships[j].setIndex(maxNode - j * players.length - i);
			}
		}
	
		return true;
	}
	
	public boolean isNodeOpen(int index){
		
		for (int i = 0; i < players.length; i++)
			for(int j = 0; j < players[i].ships.length; j++)
				if(players[i].ships[j].getIndex() == index)
					return false;
		
		return true;
	}

}
