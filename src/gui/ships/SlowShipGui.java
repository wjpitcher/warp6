package gui.ships;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import gui.board.NodeGui;
import ships.SlowShip;


public class SlowShipGui extends ShipGui {
	private static final long serialVersionUID = 1L;

	public BufferedImage shipImage;

	public SlowShipGui(Color playerColor, NodeGui node){
		super(new SlowShip(node), node);
		setShipColor(playerColor);
	}
	/*
	public SlowShipGui(SlowShip slowShip, Color playerColor){
		super(slowShip, 0, 0);
		setShipColor(playerColor);
	}
	*/
	public void setShipColor(Color playerColor){
		try {
			if(playerColor == Color.BLUE)
				shipImage = ImageIO.read(new File("img\\Ship\\SlowshipBlue.png"));
			else if(playerColor == Color.RED)
				shipImage = ImageIO.read(new File("img\\Ship\\SlowshipRed.png")); 
			else if(playerColor == Color.YELLOW)
				shipImage = ImageIO.read(new File("img\\Ship\\SlowshipYellow.png")); 
			else if(playerColor == Color.GREEN)
				shipImage = ImageIO.read(new File("img\\Ship\\SlowshipGreen.png")); 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public BufferedImage getImage() {
		return shipImage;
	}

	@Override
	public BufferedImage getMouseOverImage() {
		return shipImage;
	}
}
