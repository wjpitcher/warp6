package gui.ships;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import gui.board.BoardGui;
import gui.board.NodeGui;
import ships.MediumShip;
import ships.SlowShip;

public class MediumShipGui extends ShipGui {
	private static final long serialVersionUID = 1L;
	
	public BufferedImage baseshipImage;
	public BufferedImage shipImage;
	public BufferedImage shipOverImage;

	public MediumShipGui(Color playerColor, NodeGui node){
		super(new MediumShip(node), node);
		setShipColor(playerColor);
	}
	
	public MediumShipGui(Color playerColor, BoardGui board, int index){
		super(new MediumShip(), board, index);
		setShipColor(playerColor);
	}
	
	public void setShipColor(Color playerColor){
		try {
			if(playerColor == Color.BLUE)
				baseshipImage = ImageIO.read(new File("img\\Ship\\MediumshipBlue.png"));
			else if(playerColor == Color.RED)
				baseshipImage = ImageIO.read(new File("img\\Ship\\MediumshipRed.png")); 
			else if(playerColor == Color.YELLOW)
				baseshipImage = ImageIO.read(new File("img\\Ship\\MediumshipYellow.png")); 
			else if(playerColor == Color.GREEN)
				baseshipImage = ImageIO.read(new File("img\\Ship\\MediumshipGreen.png")); 
		} catch (IOException e) {
			e.printStackTrace();
		}
		updateSpeed();
	}
	
	@Override
	protected void updateSpeed(){
		shipImage = baseshipImage;
		Graphics g = shipImage.getGraphics();
		g.drawImage(getSpeedNumberImage(), 0, 0, null);
		shipOverImage = shipImage;
	}
	
	@Override
	public BufferedImage getImage() {
		return shipImage;
	}

	@Override
	public BufferedImage getMouseOverImage() {
		return shipOverImage;
	}
}
