package gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class BoardGui extends JPanel 
implements MouseListener, MouseMotionListener {
	/*
	private int _boardHeight = -1;
	private int _boardWidth = -1;
	private int _boardX = -1;
	private int _boardY = -1;
	*/
	private int _panelHeight = -1;
	private int _panelWidth = -1;
	BufferedImage imgBoard;
	
	private NodesGui _nodes = new NodesGui();			
			
	public BoardGui(){
		//_Board = new Board();
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		try {
			imgBoard = ImageIO.read(new File("img/Warp6.png"));
			setPreferredSize(new Dimension(imgBoard.getWidth(), imgBoard.getHeight()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/*
	public int getboardHeight() { return _boardHeight; }
	public int getboardWidth() { return _boardWidth; }
	public int getboardX() { return _boardX; }
	public int getboardY() { return _boardY; }
	*/
	@Override
	public void paint(Graphics g){
		super.paint(g);

		ResizeBoard();
		
		//g.drawImage(imgBoard, _boardX, _boardY, _boardWidth, _boardHeight, null);
		g.drawImage(imgBoard, 0, 0
				  , (int)getSize().getWidth()
				  , (int)getSize().getHeight(), null);
		_nodes.draw(g, 0, 0);
	}
	 
	private void ResizeBoard(){

		// Check verify the dimensions changed 
		if(_panelHeight != getSize().height
		|| _panelWidth  != getSize().width)
		{		
			_panelHeight = getSize().height;
			_panelWidth  = getSize().width;
/*
			// determine the size of the board
			if(imgBoard.getWidth() > imgBoard.getHeight()){
				if (_panelWidth / _panelHeight
				 < imgBoard.getWidth() /  imgBoard.getHeight()){	
					_boardWidth = _panelWidth;
					_boardX = 0;
					
					_boardHeight = _panelWidth * imgBoard.getHeight()/ imgBoard.getWidth();
					_boardY = (_panelHeight - _boardHeight) / 2;
				}
				else{
					_boardHeight = _panelHeight;
					_boardY = 0; 
					_boardWidth = _panelHeight * imgBoard.getWidth()/ imgBoard.getHeight();
					_boardX = (_panelWidth - _boardWidth) / 2;
				}
			}
			else{
				if (_panelWidth / _panelHeight
				  > imgBoard.getWidth() /  imgBoard.getHeight()){	
						_boardWidth = _panelWidth;
						_boardX = 0;
						
						_boardHeight = _panelWidth * imgBoard.getHeight()/ imgBoard.getWidth();
						_boardY = (_panelHeight - _boardHeight) / 2;
					}
					else{
						_boardHeight = _panelHeight;
						_boardY = 0; 
						_boardWidth = _panelHeight * imgBoard.getWidth()/ imgBoard.getHeight();
						_boardX = (_panelWidth - _boardWidth) / 2;
					}
			}
	*/		
			_nodes.setSize(getSize());
			NodeGui.radius = (int)(.028 * _panelWidth);
			
		//	this.setPreferredSize(new Dimension(_boardX, _boardY));
		}
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		_nodes.Add(new NodeGui(e.getX(), e.getY(), getWidth(), getHeight()));
		_nodes.draw(this.getGraphics(), e.getX(), e.getY());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// Start Node Draw
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// Save node
	}

	@Override
	public void mouseDragged(MouseEvent e) {/* Not Used */}

	@Override
	public void mouseMoved(MouseEvent e) {
	//	System.out.println("(" + e.getX() + ", " + e.getY() + ")");
	}

	@Override
	public void mouseEntered(MouseEvent e)  { /* Not Used */ }

	@Override
	public void mouseExited(MouseEvent e) { /* Not Used */ }
}
