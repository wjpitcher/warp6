package gui.ships;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import gui.board.BoardGui;
import gui.board.NodeGui;
import ships.IShip;
import ships.SlowShip;


public class SlowShipGui extends ShipGui {
	private static final long serialVersionUID = 1L;

	public BufferedImage baseshipImage;
	public BufferedImage shipImage;
	public BufferedImage shipOverImage;

	public SlowShipGui(Color playerColor, NodeGui node){
		super(new SlowShip(node), node);
		setShipColor(playerColor);
	}
	public SlowShipGui(Color playerColor, BoardGui board, int index){
		super(new SlowShip(), board, index);
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
				baseshipImage = ImageIO.read(new File("img\\Ship\\SlowshipBlue.png"));
			else if(playerColor == Color.RED)
				baseshipImage = ImageIO.read(new File("img\\Ship\\SlowshipRed.png")); 
			else if(playerColor == Color.YELLOW)
				baseshipImage = ImageIO.read(new File("img\\Ship\\SlowshipYellow.png")); 
			else if(playerColor == Color.GREEN)
				baseshipImage = ImageIO.read(new File("img\\Ship\\SlowshipGreen.png")); 
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
