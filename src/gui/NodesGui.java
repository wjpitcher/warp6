package gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

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
	
	public NodesGui(String fileName){
		loadNodes(fileName);
	}
	
	public void setRadius(int radius){
		NodeGui.radius = radius;
	}
	
	public void Add(NodeGui node){
		System.out.println("Add: " + node.toString());
		
		if(_nodes.length == _lastNode)
			_nodes = Arrays.copyOf(_nodes, _nodes.length * 2);
	
		_nodes[_lastNode] = node;
		_lastNode++;
	}

	public void loadNodes(String fileName){
		 // FileReader reads text files in the default encoding.
        try {
        	double X;
        	double Y;
			@SuppressWarnings("resource")
			Scanner fileReader = new Scanner(new File(fileName));
			
			while(fileReader.hasNext()){
				X = fileReader.nextDouble();
				Y = fileReader.nextDouble();
				
				Add(new NodeGui(X, Y));
			}
				
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
        
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
	
	public void draw(Graphics g, int X, int Y
			       , int width, int height, int radius){
	
		for(int i = 0; i < _lastNode; i++){
			// if(_nodes[i].MouseOver(X, Y, radius)){
				System.out.println(_nodes[i]);
				_nodes[i].draw(g, X, Y, width, height, radius);
			//}
		}
	}
}
