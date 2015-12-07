package gui.board;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import board.INode;

public class NodesGui {
	private double _radius  = .028;
	private NodeGui[] _nodes = new NodeGui[1];
	private int _lastNode = 0;
	private BoardGui _board;

	public NodesGui(){
		this(126);
	}
	
	public NodesGui(int nodes){
		this(new BoardGui(), nodes);
	}
	
	public NodesGui(String fileName){
		this(new BoardGui(), fileName);
	}
	public NodesGui(BoardGui board, int nodes){
		_board = board;
		_nodes = new NodeGui[nodes];
	}
	
	public NodesGui(BoardGui board, String fileName){
		_board = board;
		loadNodes(fileName);
	}
	
	public void setRadius(int radius){
		_radius = radius;
		
		for(int i = 0; i < _nodes.length; i++)
			_nodes[i].ratio = radius;
	}
	
	public double getRadius(){
		return _radius;
	}
	
	public void Add(NodeGui node){
		if(_nodes.length == _lastNode)
			_nodes = Arrays.copyOf(_nodes, _nodes.length * 2);
		_board.add(node);
		_nodes[_lastNode] = node;
		_lastNode++;
	}

	public void loadNodes(String fileName){
		 // FileReader reads text files in the default encoding.
        try {
        	double X;
        	double Y;
        	int index = 0;
			@SuppressWarnings("resource")
			Scanner fileReader = new Scanner(new File(fileName));
			
			while(fileReader.hasNext()){
				X = fileReader.nextDouble();
				Y = fileReader.nextDouble();
				Add(new NodeGui(index, (BoardGui) _board, X, Y, _radius));
				index++;
			}
				
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public INode[] getNodes(){
		return _nodes;
	}
}
