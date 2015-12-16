package ships;

import board.INode;

public interface IShip {

	public int getMaxSpeed();
	public String getType();
	
	public int getSpeed();
	
	public int getPoints();
	
	public boolean incrementable();
	public boolean decrementable();
	
	public boolean movable();

	public int getIndex();

	public void setIndex(int index);

	public void setLocation(INode newLocation);
	public INode getNode();
	public boolean increment();

	public boolean decrement();
	
	public void move();
	
}
