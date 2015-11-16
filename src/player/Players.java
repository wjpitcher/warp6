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
	
	public boolean setup(Board board){
		for(int i = 0; i < players.length; i++){
			try{
				players[i].ships = fleet.generateFleet();
			} catch(Exception e) {
				System.out.println(i + ": " + e.toString());
				return false;
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
