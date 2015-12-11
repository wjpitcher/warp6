package gui.board;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import board.IBoard;
import board.INode;
import board.Node;

public class NodeGui extends GuiElement implements INode {
	private static final long serialVersionUID = 1L;

	private BufferedImage imgNormal;
	private BufferedImage imgMouseOver;
	
	public double X;
	public double Y;
	public INode _node;
	public boolean paintable = true;
	
	public NodeGui(int index, IBoard board, int X, int Y, double ratio){
		this(new Node(index, board.getNextNode(index), board.getBumpNode(index))
		   , X, Y, ratio);
	}	

	public NodeGui(int index, IBoard board, double X, double Y, double ratio){
		this(new Node(index, board.getNextNode(index), board.getBumpNode(index))
		   , X, Y, ratio);
	}	
	
	public NodeGui(INode node, int X, int Y, double ratio){
		super(X, Y, ratio);
		_node = node;
		setupImages();
	}	

	public NodeGui(INode node, double X, double Y, double ratio){
		super(X, Y, ratio);
		_node = node;
		setupImages();
	//	System.out.println("Node percent Constructor: " + this.toString());
	}	

	private void setupImages(){
		imgNormal =  new BufferedImage(25, 25, 1);
		Graphics g = imgNormal.getGraphics();
		
		g.setColor(Color.RED);
		g.fillOval(0, 0, 25, 25);
		
		g.setColor(Color.PINK);
		g.drawOval(0, 0, 25, 25);

		g.setColor(Color.BLACK);
		g.drawString(_node.index()+"", 4, 17);
		try {
			imgNormal =  ImageIO.read(new File("img\\Ship\\MediumshipRed.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		imgMouseOver =  new BufferedImage(25, 25, 1);
		g = imgMouseOver.getGraphics();
		g.setColor(Color.CYAN);
		g.fillOval(0, 0, 25, 25);
		
		g.setColor(Color.BLUE);
		g.drawOval(0, 0, 25, 25);
		
		g.setColor(Color.BLACK);
		g.drawString(_node.index()+ "", 4, 17);
		
		try {
			imgMouseOver =  ImageIO.read(new File("img\\Ship\\FastshipBlue.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void paint(Graphics g){
		if(paintable)
			super.paint(g);
		System.out.println(this + " Node "  );
	}
	
	@Override
	public BufferedImage getImage() {
		return imgNormal;
	}

	@Override
	public BufferedImage getMouseOverImage() {
		return imgMouseOver;
	}

	@Override
	public void clicked() {
		JOptionPane.showMessageDialog(this, "Node " + index() + " was clicked");
	}

	@Override
	public String toString(){
		return  index() + ": " + super.toString();
	}
	
	@Override
	public void setNext(INode value) {
		_node.setNext(value);
	}
	@Override
	public INode Next() {
		return _node.Next();
	}
	@Override
	public INode Bump() {
		return _node.Bump();
	}
	@Override
	public void setBump(INode value) {
		_node.setBump(value);
	}
	@Override
	public boolean isOccupied() {
		return _node.isOccupied();
	}
	@Override
	public void setOccupied(boolean value) {
		_node.setOccupied(value);
	}
	@Override
	public int index() {
		return _node.index();
	}
	@Override
	public boolean moveable(int moves) {
		return _node.moveable(moves);
	}
	@Override
	public INode move(int moves) {
		return _node.move(moves);
	}

}
