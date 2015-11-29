package gui;

import java.awt.Color;
import java.awt.Graphics;

public class NodeGui {
	public static int radius = 0;
	
	public double X;
	public double Y;

	public NodeGui(int X, int Y, int width, int height){
		setLoc(X, Y, width, height);
	}	

	public NodeGui(double X, double Y){
		setLoc(X, Y);
	}	

	public void setLoc(int X, int Y, int width, int height){
		setLoc((double) X / width, (double) Y / height);
	}	
	
	public void setLoc(double X, double Y){
		this.X = X;
		this.Y = Y;
	}	

	public boolean MouseOver(int X, int Y, int width, int height ){
		return MouseOver(X, Y, width, height, radius);
	}
	
	public boolean MouseOver(int X, int Y, int width, int height, int radius){
		int nodeX = (int)(this.X * width);
		int nodeY = (int)(this.Y * height);
		
		return radius < Math.sqrt((nodeX - X) * (nodeX - X)
				                 + (nodeY - Y) * (nodeY - Y));
	}
	 
	public void  draw(Graphics g, int X, int Y, int width, int height, int radius){
		int nodeX = (int)(this.X * width);
		int nodeY = (int)(this.Y * height);
		
		Color originalColor = g.getColor();
		
		if(MouseOver(X, Y, width, height))
			g.setColor(Color.BLUE);
		else 
			g.setColor(Color.RED);
		
		g.fillOval(nodeX - radius / 2
				 , nodeY - radius / 2
				 , radius, radius);

		if(MouseOver(X, Y, width, height))
			g.setColor(Color.PINK);
		else 
			g.setColor(Color.CYAN);

		g.drawOval(nodeX - radius / 2
				 , nodeY - radius / 2
				 , radius, radius);
		
		g.setColor(originalColor);
		System.out.println(this.toString() 
			           + " Actual: (" + nodeX + ", " + nodeY + ")"
			           + " Board: (" + width + ", " + height + ")");
	}
	
	@Override
	public String toString(){
		return X + " " + Y ;
	}
}
