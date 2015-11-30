package gui.ships;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import ships.Ship;

public class MediumShipGui extends ShipGui {
	private static final long serialVersionUID = 1L;

	public BufferedImage shipImage;
	private ships.FastShip ship; 
	
	public MediumShipGui(Color playerColor){
		setShipColor(playerColor);
	}
	
	public void setShipColor(Color playerColor){
		try {
			if(playerColor == Color.BLUE)
				shipImage = ImageIO.read(new File("img\\Ship\\MediumshipBlue.png"));
			else if(playerColor == Color.RED)
				shipImage = ImageIO.read(new File("img\\Ship\\MediumshipRed.png")); 
			else if(playerColor == Color.YELLOW)
				shipImage = ImageIO.read(new File("img\\Ship\\MediumshipYellow.png")); 
			else if(playerColor == Color.GREEN)
				shipImage = ImageIO.read(new File("img\\Ship\\MediumshipGreen.png")); 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Ship getShip() {
		return ship;
	}

	@Override
	protected Image buildShipImage() {
		return shipImage;
	}
}
