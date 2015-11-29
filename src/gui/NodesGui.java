package gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Arrays;

public class NodesGui {

	private NodeGui[] _nodes = new NodeGui[1];
	private int _lastNode = 0;
	private Dimension _dim = new Dimension();
	private Point _loc = new Point();
	
	public NodesGui(){
		this(126);
	}
	
	public NodesGui(int nodes){
		_nodes = new NodeGui[nodes];
	}
	
	public void setRadius(int radius){
		NodeGui.radius = radius;
	}
	
	public void Add(NodeGui node){
		System.out.println(node.toString());
		if(_nodes.length == _lastNode)
			_nodes = Arrays.copyOf(_nodes, _nodes.length * 2);
	
		_nodes[_lastNode] = node;
		_lastNode++;
	}
	

	public void setSize(int width, int height){
		_dim.setSize(width, height);
	}
	
	public void setSize(Dimension constrolSize){
		_dim = constrolSize;
	}
	
	public void setLoc(int x, int y){
		_loc.setLocation(x, y);
	}
	
	public void draw(Graphics g){
	
		draw(g, _loc.x, _loc.y, _dim.width, _dim.height, NodeGui.radius);
	}

	public void draw(Graphics g, int width, int height){
	
		draw(g, _loc.x, _loc.y, width, height, NodeGui.radius);
	}
	
	public void draw(Graphics g, int X, int Y
			       , int width, int height, int radius){
	
		for(int i = 0; i < _lastNode; i++){
			// if(_nodes[i].MouseOver(X, Y, radius)){
				_nodes[i].draw(g, X, Y, width, height, radius);
				System.out.println(i + ": " + _nodes[i]);
			//}
		}
	}
}
