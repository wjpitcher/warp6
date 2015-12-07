package player;

import java.awt.Color;
import ships.IShip;

public interface IPlayer {
	
	public Color getColor();
	public void setColor(Color color);
	
	public String getName();
	public void setColor(String name);
		
	public void Add(IShip ship);	
	public IShip[] getShips();	
	public void setShips(IShip[] ships);	
	
	public IShip[] warpedShips();
}
