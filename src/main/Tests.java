package main;

import board.board;
import ships.*;

public class Tests {

	public String runTests(){
		String result = "";

		result += testMoveShip("SlowShip");
		result += testMoveShip("MediumShip");
		result += testMoveShip("FastShip");
		
		return result;
	}
	
	public Ship getShip(String ShipName){
		if(ShipName == "SlowShip") return new SlowShip();
		else if (ShipName == "MediumShip") return new MediumShip();
		else if (ShipName == "FastShip") return new FastShip();
		else { System.out.println(ShipName + " doesn't exist"); return null;}
	}
	
	public String testMoveShip(String shipType){
		String result = "";
		TestResult test = null;
		result = shipType + ": ";
		
		for(int i = 0; i < 100; i++){
			test = moveShip(getShip(shipType));

			if(!test.getResult())
				break;
		}
		
		if(!test.getResult())
			result += "Fail\n" + test.report();
		else
			result += "Pass\n";
		return result;
	}
	
	public TestResult moveShip(Ship ship){
		TestResult test = new TestResult();
		test.setResult(true);

		board warpBoard = new board(100);
		ship.setLocation(warpBoard.firstAvailableNode());
		
		try{
			test.addComment("Ship Speed:" + ship.getSpeed());
			
			while(ship.getIndex() > 0 ){
				if(ship.movable()){
					ship.move();
					test.addComment("Ship moved to: " + ship.getIndex());
				}
				else{
					ship.decrement();
					test.addComment("Ship reduced speed to " + ship.getSpeed());
				}
			}				
			test.setResult(ship.getIndex() == 0 );
			return test;

		}catch(Exception e){
			test.addComment("Error: (" + ship.getIndex() + ")" + e.getMessage());
			test.setException(e);
			return test;
		}
	}
}

