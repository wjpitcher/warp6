package gui.board;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;
import javax.swing.event.MouseInputListener;

public abstract class GuiElement extends JComponent implements MouseMotionListener, MouseInputListener{
	private static final long serialVersionUID = 1L;
	public double X;
	public double Y;
	public double ratio;
	private boolean _isMouseOver;
	
	public GuiElement(int X, int Y, double ratio){
		this.ratio = ratio;
		setLoc(X, Y);
	}	

	public GuiElement(double X, double Y, double ratio){
		this.ratio  = ratio;
		setLoc(X, Y);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}
	
	public void setLoc(int X, int Y){
		if(getParent() != null)
			setLoc((double) X / getParent().getWidth(), (double) Y / getParent().getHeight());
	}	
	
	public void setLoc(double X, double Y){
		this.X = X;
		this.Y = Y;
	}	
	
	@Override
	public void paint(Graphics g){
		int smallestratio = Math.min(getParent().getWidth()  / this.getSize().width
				                   , getParent().getHeight() / this.getSize().height);
		
		this.setSize((int)(this.getSize().width  * smallestratio * ratio)
				   , (int)(this.getSize().height * smallestratio * ratio));
		
		this.setLocation((int)(X * getParent().getWidth() - this.getSize().width / 2)
				       , (int)(Y * getParent().getHeight() - this.getSize().height / 2));

	
		if(_isMouseOver)
			g.drawImage(getMouseOverImage(), 0,0, this.getWidth(), this.getHeight(), null);
		else	
			g.drawImage(getImage(), 0,0, this.getWidth(), this.getHeight(), null);
	}

	public abstract BufferedImage getImage();
	
	public abstract BufferedImage getMouseOverImage();
	
	public void clicked(){}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		clicked();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		_isMouseOver = true;
		this.paint(this.getGraphics());
	}

	@Override
	public void mouseExited(MouseEvent e) {
		_isMouseOver = false;
		this.paint(this.getGraphics());
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {/* Not used */}

	@Override
	public void mouseMoved(MouseEvent e) {/* Not used */}

	@Override
	public void mousePressed(MouseEvent e) {/* Not used */}

	@Override
	public void mouseReleased(MouseEvent e) {/* Not used */}
}
