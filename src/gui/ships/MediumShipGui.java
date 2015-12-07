package gui.ships;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import board.INode;
import gui.board.NodeGui;
import ships.MediumShip;

public class MediumShipGui extends ShipGui {
	private static final long serialVersionUID = 1L;

	public BufferedImage shipImage;

	public MediumShipGui(Color playerColor, NodeGui node){
		super(new MediumShip(node), node);
		setShipColor(playerColor);
	}
/*
	public MediumShipGui(MediumShip mediumShip, Color playerColor){
		super(mediumShip, 0, 0);
		setShipColor(playerColor);
	}
	*/
	public void setShipColor(Color playerColor){
		try {
			if(playerColor == Color.BLUE)
				shipImage = ImageIO.read(new File("img\\Ship\\MediumShipBlue.png"));
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
/*
	@Override
	public void setLocation(INode newLocation) {
		super.setLocation(newLocation);
		
	}
*/
	@Override
	public BufferedImage getImage() {
		return shipImage;
	}

	@Override
	public BufferedImage getMouseOverImage() {
		return shipImage;
	}
}
