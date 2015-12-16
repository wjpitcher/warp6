package gui.board;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import board.Board;
import board.IBoard;
import board.INode;
import gui.ships.FastShipGui;
import gui.ships.MediumShipGui;
import gui.ships.ShipGui;
import gui.ships.SlowShipGui;

public class BoardGui extends JPanel 
 implements IBoard {
	private static final long serialVersionUID = 1L;

	private int _panelHeight = -1;
	private int _panelWidth = -1;
	private BufferedImage imgBoard;
	private NodesGui _nodes;			
	private IBoard _board;
	
	public BoardGui(){
		this(new Board());
	}
	
	public BoardGui(IBoard board){
		_board = board;
		
		//this.setLayout(null);

		try {
			imgBoard = ImageIO.read(new File("img/Warp6.png"));
			setPreferredSize(new Dimension(imgBoard.getWidth(), imgBoard.getHeight()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		_nodes = new NodesGui(this, "coord.txt");	

		_board.setNodes(_nodes.getNodes());	
		for(int i = 0 ; i < _nodes.getNodes().length; i++){
			if(_nodes.getNodes()[i] != null){	
				this.add((NodeGui) _nodes.getNodes()[i]);
			}
		}
	}

	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);	

		// Check verify the dimensions changed 
		if(_panelHeight != getSize().height
		|| _panelWidth  != getSize().width)
		{		
			_panelHeight = getSize().height;
			_panelWidth  = getSize().width;
		}
	
		// Draw the Board image with the new Dimensions
		g.drawImage(imgBoard, 0, 0
				  , _panelWidth
				  , _panelHeight, null);
	}
	 
	@Override
	public INode firstAvailableNode() {
		return _board.firstAvailableNode();
	}

	@Override
	public int getBumpIndex(int index) {
		return _board.getBumpIndex(index);
	}

	@Override
	public int getRing(int index) {
		return _board.getRing(index);
	}

	@Override
	public int maxIndex(int ringNumber) {
		return _board.maxIndex(ringNumber);
	}

	@Override
	public INode getNode(int index) {
		return _board.getNode(index);
	}

	@Override
	public INode getBumpNode(int index) {
		return _board.getBumpNode(index);
	}

	@Override
	public INode getNextNode(int index) {
		return _board.getNextNode(index);
	}

	@Override
	public void setNodes(INode[] nodes) {
		 _board.setNodes(nodes);
	}

	@Override
	public INode[] getNodes() {
		return _board.getNodes();
	}
}
