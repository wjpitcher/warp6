package player;

import java.awt.Color;

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
		Ship[] ships;
		
		if(_ships == null)
			ships = new Ship[1];
		else
			ships = new Ship[_ships.length + 1];
		
		ships = _ships.clone();
		ships[ships.length -1] = ship;
		_ships = ships;
	}
	
	
}