package player;

import java.awt.Color;
import java.util.Arrays;

import ships.Ship;

public class Player {
	private String _name  = "";
	private Color _color;
	public  Ship[] ships = {};
	
	public Player(String name, Color color){
		_name = name;
		_color = color;	
	}
	
	public Color getColor() {return _color;}
	public void setColor(Color color) {_color = color;}
	
	public String getName() {return _name;}
	public void setColor(String name) {_name = name;}
		
	public void Add(Ship ship){	
		if(ships == null)
			ships = new Ship[1];	
		else
			ships = Arrays.copyOf(ships, ships.length + 1);
		
		ships[ships.length -1] = ship;
	}
	
	 public Ship[] warpedShips(){
		 Ship[] warpships = {};
		 
		 for(int i = 0; i < ships.length; i++ ){
			 if(ships[i].getIndex() == 0 ){
				 warpships = Arrays.copyOf(warpships, warpships.length +1);
				 warpships[warpships.length -1] = ships[i];
			 }
		 }
		 
		 return warpships;
	 }
	
}
