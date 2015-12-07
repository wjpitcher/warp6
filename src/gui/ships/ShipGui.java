package gui.ships;

import ships.IShip;
import board.INode;
import gui.board.GuiElement;
import gui.board.NodeGui;

public abstract class ShipGui extends GuiElement implements IShip {
	private static final long serialVersionUID = 1L;
	private static final double RATIO = .3;
	private IShip _ship;
	
	public ShipGui(IShip ship, NodeGui node){
		super(node.X, node.Y, RATIO);
		_ship = ship;
	}
	
	public ShipGui(IShip ship, int X, int Y){
		super(X, Y, RATIO);
		_ship = ship;
	}
	
	public ShipGui(IShip ship, double X, double Y){
		super(X, Y, RATIO);
		_ship = ship;
	}
	
	public IShip getShip(){
		return _ship;
	}
		
	@Override
	public int getMaxSpeed() {
		return _ship.getMaxSpeed();
	}
	
	@Override
	public String getType() {
		return _ship.getType();
	}
	
	@Override
	public int getSpeed() {
		return _ship.getSpeed();
	}
	
	@Override
	public int getPoints() {
		return _ship.getPoints();
	}
	@Override
	public boolean incrementable() {
		return _ship.incrementable();
	}
	@Override
	public boolean decrementable() {
		return _ship.decrementable();
	}
	@Override
	public boolean movable() {
		return _ship.movable();
	}
	@Override
	public int getIndex() {
		return _ship.getIndex();
	}
	
	@Override
	public void setIndex(int index) {
		_ship.setIndex(index);
	}
	
	@Override
	public void setLocation(INode newLocation) {
		_ship.setLocation(newLocation);
	}
	
	@Override
	public boolean increment() {
		return _ship.increment();
	}
	@Override
	public boolean decrement() {
		return _ship.decrement();
	}
	@Override
	public void move() {
		_ship.move();		
	}
}
