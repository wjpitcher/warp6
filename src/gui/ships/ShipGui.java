package gui.ships;

import ships.IShip;
import ships.MediumShip;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import board.INode;
import board.Node;
import gui.board.GuiElement;
import gui.board.NodeGui;

public  class ShipGui extends GuiElement implements IShip {
	private static final long serialVersionUID = 1L;
	private static final double RATIO = .255;
	private IShip _ship;
	
	public BufferedImage shipImage = null;
	
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
	public BufferedImage getImage() {
		if(shipImage == null){
			try {
				shipImage = ImageIO.read(new File("img\\Ship\\FastshipYellow.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return shipImage;
	}

	@Override
	public BufferedImage getMouseOverImage() {
		return getImage();
	}
	
	@Override
	public void paint(Graphics g){
		String test = "";
		/*
		for(int i = 0; i < Thread.currentThread().getStackTrace().length; i++ ){
			test += Thread.currentThread().getStackTrace()[i].toString() + "\n";
		}*/
		System.out.println(this + ": " + test );
		super.paint(g);
		
	}

	@Override
	public void paintComponent(Graphics g){
		String test = "";
		/*
		for(int i = 0; i < Thread.currentThread().getStackTrace().length; i++ ){
			test += Thread.currentThread().getStackTrace()[i].toString() + "\n";
		}*/
		System.out.println(this + " component: " + test );
	//	super.paint(g);
		
	}
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
