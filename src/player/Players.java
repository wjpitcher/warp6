package player;

import java.util.Arrays;
import java.util.Random;

import ships.*;

public class Players {
	private Player[] _players = {};
	
	private Fleet fleet;
	
	public Players(){
		fleet = new Fleet();
		fleet.add("Fast",2);
		fleet.add("Medium",3);
		fleet.add("Slow",4);
	}
	
	public void Add(Player player){	
		if(_players == null)
			_players = new Player[1];	
		else
			_players = Arrays.copyOf(_players, _players.length + 1);
		
		_players[_players.length -1] = player;
	}
	
	public void setup(){
		Ship[][] ships = new Ship[_players.length][9];

		for(int i = 0; i < _players.length; i++){
			for(int j = 0; j < ships[_players.length].length; j++){
				ships[i] = fleet.generateFleet(shipColor)
			}
		}
	}
	
	public boolean isNodeOpen(int index){
		
		for (int i = 0; i < _players.length; i++)
			for(int j = 0; j < _players[i].ships().length; j++)
				if(_players[i].ships()[j].getIndex() == index)
					return false;
		
		return true;
	}
}
