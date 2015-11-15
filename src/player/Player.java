package player;

import java.awt.Color;
import java.util.Arrays;

import ships.Ship;

public class Player {
	private String _name  = "";
	private Color _color;
	private Ship[] _ships;
	
	public Player(String name, Color color){
		_name = name;
		_color = color;	
	}
	
	public Color getColor() {return _color;}
	public void setColor(Color color) {_color = color;}
	
	public String getName() {return _name;}
	public void setColor(String name) {_name = name;}
	
	public Ship[] ships(){ return _ships;}
	
	public void Add(Ship ship){	
		if(_ships == null)
			_ships = new Ship[1];	
		else
			_ships = Arrays.copyOf(_ships, _ships.length + 1);
		
		_ships[_ships.length -1] = ship;
	}
	
	
}
