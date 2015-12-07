package player;

import java.awt.Color;
import java.util.Arrays;

import ships.IShip;
import ships.Ship;

public class Player implements IPlayer {
	private String _name  = "";
	private Color _color;
	public  IShip[] ships = {};
	
	public Player(String name, Color color){
		_name = name;
		_color = color;	
	}
	
	@Override
	public Color getColor() {return _color;}
	
	@Override
	public void setColor(Color color) {_color = color;}
	
	@Override
	public String getName() {return _name;}
	
	@Override
	public void setColor(String name) {_name = name;}
	
	@Override
	public void Add(IShip ship){	
		if(ships == null)
			ships = new Ship[1];	
		else
			ships = Arrays.copyOf(ships, ships.length + 1);
		
		ships[ships.length -1] = ship;
	}
	
	@Override
	 public IShip[] warpedShips(){
		 IShip[] warpships = {};
		 
		 for(int i = 0; i < ships.length; i++ ){
			 if(ships[i].getIndex() == 0 ){
				 warpships = Arrays.copyOf(warpships, warpships.length +1);
				 warpships[warpships.length -1] = ships[i];
			 }
		 }
		 
		 return warpships;
	 }

	@Override
	public IShip[] getShips() {
		return ships;
	}
	
	@Override
	public void setShips(IShip[] ships) {
		this.ships = ships;
	}
}
