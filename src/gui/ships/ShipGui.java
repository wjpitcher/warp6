package gui.ships;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.geom.AffineTransform;

import javax.swing.JComponent;
import javax.swing.JPanel;

import ships.Ship;
public abstract class ShipGui extends JComponent {
	private double _rotation = 0.0;
	private double _X = 0.0;
	private double _Y = 0.0;
	
	public abstract Ship getShip();
	
	protected abstract Image buildShipImage();
	
	public void setRotation(double radians){
		_rotation = radians;
	}
	
	public void setRotation(Point nextNode){
		_rotation = Math.atan((nextNode.getX() - _X)
		                    / (nextNode.getY() - _Y));
	}
	
	public double getRotation(){
		return _rotation;
	}
	
	public Image getShipImage(int width, int height, double scale){
		return buildShipImage().getScaledInstance((int)(width * scale)
				                                 ,(int)(height * scale)
				                                 ,Image.SCALE_DEFAULT);
	}
	
	public Image getShipRotImage(int width, int height, double scale){
		return getShipImage(width, height,  scale);
	}
	
	//@Override
	public void draw(Graphics g, int width, int height, double scale){
		/*
		AffineTransform rot = new AffineTransform();
		Image shipImage = getShipImage(width, height,  scale);
	    
		Graphics2D g2d = (Graphics2D) g;
	    

	    rot.rotate(getRotation(), shipImage.getWidth(null), shipImage.getHeight(null));
	    g2d.drawImage(shipImage, rot, null);
	    */


		
		g.drawImage(getShipImage(width, height, scale)
				  , (int)(_X * width),(int) (_Y * height), null);
	}
	

	@Override
	public void paint(Graphics g){
		this.setPreferredSize(new Dimension(buildShipImage().getWidth(null), buildShipImage().getHeight(null)));

		g.drawImage(buildShipImage(), (this.getWidth() - buildShipImage().getWidth(null)) / 2
				             , (this.getHeight() - buildShipImage().getHeight(null)) / 2
				             , null);
	}
	
}
