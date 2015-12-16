package gui.ships;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import gui.board.BoardGui;
import gui.board.NodeGui;
import ships.FastShip;
import ships.SlowShip;

public class FastShipGui extends ShipGui {
	private static final long serialVersionUID = 1L;
	
	public BufferedImage baseshipImage;
	public BufferedImage shipImage;
	public BufferedImage shipOverImage;

	public FastShipGui(Color playerColor, NodeGui node){
		super(new FastShip(node), node);
		setShipColor(playerColor);
	}

	public FastShipGui(Color playerColor, BoardGui board, int index){
		super(new FastShip(), board, index);
		setShipColor(playerColor);
	}
	
	public void setShipColor(Color playerColor){
		try {
			if(playerColor == Color.BLUE)
				baseshipImage = ImageIO.read(new File("img\\Ship\\FastshipBlue.png"));
			else if(playerColor == Color.RED)
				baseshipImage = ImageIO.read(new File("img\\Ship\\FastshipRed.png")); 
			else if(playerColor == Color.YELLOW)
				baseshipImage = ImageIO.read(new File("img\\Ship\\FastshipYellow.png")); 
			else if(playerColor == Color.GREEN)
				baseshipImage = ImageIO.read(new File("img\\Ship\\FastshipGreen.png")); 
		} catch (IOException e) {
			e.printStackTrace();
		}
		updateSpeed();
	}

	@Override
	public BufferedImage getImage() {
		return shipImage;
	}

	@Override
	public BufferedImage getMouseOverImage() {
		return shipOverImage;
	}
	
	@Override
	protected void updateSpeed(){
		shipImage = baseshipImage;
		Graphics g = shipImage.getGraphics();
		g.drawImage(getSpeedNumberImage(), 0, 0, null);
		shipOverImage = shipImage;
	}
}
