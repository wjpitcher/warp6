package ships;

import java.awt.Color;
import java.util.Arrays;
import java.util.Random;

import ships.Ship;

public class Fleet {
	public String[] manifest = {} ;
	
	public void add(String shipType){	
		manifest = Arrays.copyOf(manifest, manifest.length + 1);
		
		manifest[manifest.length -1] = shipType;
	}
	
	public void add(String shipType, int qty){	
		manifest = Arrays.copyOf(manifest, manifest.length + qty);
		
		for(int i = manifest.length - qty ; i < manifest.length ; i++)
			manifest[i] = shipType;
	}
	
	public Ship[] generateFleet() throws Exception{
		Ship[] fleet = new Ship[manifest.length] ;
		Random rand = new Random();
		int index;
		
		for(int i = 0; i < manifest.length; i++){
			index = rand.nextInt(manifest.length);
						
			for(int j = 0; fleet[index] != null && j < fleet.length ; j++) 
				index = (index + 1) % fleet.length;
			
			if(fleet[index] == null)
				fleet[index] = getShip(manifest[i]);
			else
				throw new Exception("Ship count exceeds fleet");
		}
		
		return fleet;
	}
	
	public static Ship getShip(String shipType) throws Exception{
		if(shipType == "Fast")
			return new FastShip();
		else if(shipType == "Medium")
			return new MediumShip();
		else if(shipType == "Slow")
			return new SlowShip();
		else
			throw new Exception("Invalid Ship: " + shipType);
	}
}
