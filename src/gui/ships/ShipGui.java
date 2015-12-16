package gui.ships;

import ships.IShip;
import ships.MediumShip;

import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import board.INode;
import board.Node;
import gui.board.BoardGui;
import gui.board.GuiElement;
import gui.board.NodeGui;

public abstract class ShipGui extends GuiElement implements IShip{
	private static final long serialVersionUID = 1L;
	private static final double RATIO = .05;
	private IShip _ship;
	private static BufferedImage[] numberImages = null;
	private BoardGui _board ;
	
	public BufferedImage shipImage = null;
	
	public ShipGui(IShip ship, NodeGui node){
		super(node.X, node.Y, RATIO);
		ship.setLocation(node);
		populateNumberImages();
		_ship = ship;
	}
	public ShipGui(IShip ship, BoardGui board, int index){
		super(((NodeGui)board.getNode(index)).X
			, ((NodeGui)board.getNode(index)).Y, RATIO);
		board.getNode(index).setOccupied(true);
		_board = board;
		ship.setLocation(board.getNode(index));
		ship.setIndex(index);
		populateNumberImages();
		_ship = ship;
	}
	 
	/*
	public ShipGui(IShip ship, int X, int Y){
		super(X, Y, RATIO);
		populateNumberImages();
		_ship = ship;
	}
	
	public ShipGui(IShip ship, double X, double Y){
		super(X, Y, RATIO);
		populateNumberImages();
		_ship = ship;
	}
	*/
	public IShip getShip(){
		return _ship;
	}

	private void populateNumberImages(){
		if(numberImages == null) {	
			numberImages = new BufferedImage[10];
			
			for( int i = 0; i < 10; i++){
				try {
					numberImages[i] = ImageIO.read(new File("img\\Ship\\num" + i + ".png"));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	@Override
	public void clicked(){
		System.out.println("Move");
		move();
		repaint();
	}
	
	public BufferedImage getSpeedNumberImage(){
		if(getShip() == null)
			return getNumberImage(0);
		else
			return getNumberImage(getShip().getSpeed());
	}
	
	public BufferedImage getNumberImage(int number){
		return numberImages[number];
	}
	
	protected abstract void updateSpeed();
	// Ship Methods
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
	public INode getNode(){ return _ship.getNode(); }
	
	@Override
	public boolean increment() {
		boolean incremented = _ship.increment();
		updateSpeed();
		return incremented;	
	}
	@Override
	public boolean decrement() {
		boolean decrement = _ship.decrement();
		updateSpeed();
		return decrement;
	}
	@Override
	public void move() {
		System.out.println("Before: " + _ship.getNode().index() + " (" + X + ", " + Y + ")"  );
		_ship.move();
		

		if(_ship.getNode().index() == 0)
			this.setVisible(false);
		
		X = ((NodeGui)_ship.getNode()).X;
		Y = ((NodeGui)_ship.getNode()).Y;
		
		updateSpeed();
	}
}
