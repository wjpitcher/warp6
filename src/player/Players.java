package player;

import java.util.Arrays;

import ships.Ship;

public class Players {
	private Player[] _players = {};
	
	public void Add(Player player){	
		if(_players == null)
			_players = new Player[1];	
		else
			_players = Arrays.copyOf(_players, _players.length + 1);
		
		_players[_players.length -1] = player;
	}
	
	public boolean isNodeOpen(int index){
		
		for (int i = 0; i < _players.length; i++)
			for(int j = 0; j < _players[i].ships().length; j++)
				if(_players[i].ships()[j].getIndex() == index)
					return false;
		
		return true;
	}
}
