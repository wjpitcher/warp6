package gui.ships;

import java.awt.Color;
import java.util.Random;

import gui.board.BoardGui;
import gui.board.NodeGui;
import ships.Fleet;
import ships.IShip;

public class FleetGui extends Fleet {
	private Color shipColor;
	private BoardGui board;
	
	public FleetGui(Color shipColor, BoardGui board){
		this.shipColor  = shipColor;
		this.board = board;
	}

	public IShip[] generateFleet() throws Exception{
		IShip[] fleet = new IShip[manifest.length] ;
		Random rand = new Random();
		int index;
		
		for(int i = 0; i < manifest.length; i++){
			index = rand.nextInt(manifest.length);
			
			// gets a random Ship using
			for(int j = 0; fleet[index] != null && j < fleet.length ; j++) 
				index = (index + 1) % fleet.length;
			
			if(fleet[index] == null)
				fleet[index] = getShip(manifest[i], (NodeGui)board.getNode(index));
			else
				throw new Exception("Ship count exceeds fleet");
		}
		
		return fleet;
	}
	
	public IShip getShip(String shipType, NodeGui node) throws Exception{
		if(shipType == "Fast")
			return new FastShipGui(shipColor, node);
		else if(shipType == "Medium")
			return new MediumShipGui(shipColor, node);
		else if(shipType == "Slow")
			return new SlowShipGui(shipColor, node);
		else
			throw new Exception("Invalid Ship: " + shipType);
	}
}
