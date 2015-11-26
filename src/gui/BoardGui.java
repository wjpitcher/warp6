package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class BoardGui extends JPanel implements ActionListener {
	private int _boardHeight = -1;
	private int _boardWidth = -1;
	private int _boardX = -1;
	private int _boardY = -1;
	private int _panelHeight = -1;
	private int _panelWidth = -1;
	BufferedImage imgBoard;
	
	public BoardGui(){
		//_Board = new Board();
		
		try {
			imgBoard = ImageIO.read(new File("img/Warp6.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void paint(Graphics g){
		super.paint(g);
		ResizeBoard();
	
		g.drawImage(imgBoard, _boardX, _boardY, _boardWidth, _boardHeight ,null);
	}
	
	private void ResizeBoard(){

		// Check verify the dimensions changed 
		if(_panelHeight != this.getSize().height
		|| _panelWidth  != this.getSize().width)
		{		
			_panelHeight = this.getSize().height;
			_panelWidth  = this.getSize().width;

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
		}
		
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
