package gui.ships;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import gui.board.NodeGui;
import ships.FastShip;

public class FastShipGui extends ShipGui {
	private static final long serialVersionUID = 1L;

	public BufferedImage shipImage;

	public FastShipGui(Color playerColor, int X, int Y){
		super(new FastShip(), X, Y);
		setShipColor(playerColor);
	}

	public FastShipGui(Color playerColor, double X, double Y){
		super(new FastShip(), X, Y);
		setShipColor(playerColor);
	}

	public FastShipGui(Color playerColor, NodeGui node){
		super(new FastShip(node), node);
		setShipColor(playerColor);
	}

	public void setShipColor(Color playerColor){
		try {
			if(playerColor == Color.BLUE)
				shipImage = ImageIO.read(new File("img\\Ship\\FastshipBlue.png"));
			else if(playerColor == Color.RED)
				shipImage = ImageIO.read(new File("img\\Ship\\FastshipRed.png")); 
			else if(playerColor == Color.YELLOW)
				shipImage = ImageIO.read(new File("img\\Ship\\FastshipYellow.png")); 
			else if(playerColor == Color.GREEN)
				shipImage = ImageIO.read(new File("img\\Ship\\FastshipGreen.png")); 
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
