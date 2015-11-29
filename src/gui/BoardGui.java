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
	private int _panelHeight = -1;
	private int _panelWidth = -1;
	BufferedImage imgBoard;
	
	private NodesGui _nodes = new NodesGui("coord.txt");			
			
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

	@Override
	public void paint(Graphics g){
		super.paint(g);

		ResizeBoard();
		
		g.drawImage(imgBoard, 0, 0
				  ,  _panelWidth
				  ,  _panelHeight, null);
		_nodes.draw(g);
	}
	 
	private void ResizeBoard(){

		// Check verify the dimensions changed 
		if(_panelHeight != getSize().height
		|| _panelWidth  != getSize().width)
		{		
			_panelHeight = getSize().height;
			_panelWidth  = getSize().width;
			
			_nodes.setSize(getSize());
			NodeGui.radius = (int)(.028 * _panelWidth);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		_nodes.setLoc(e.getX(), e.getY());
		_nodes.Add(new NodeGui(e.getX(), e.getY(), _panelWidth, _panelHeight));
		_nodes.draw(this.getGraphics());
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
