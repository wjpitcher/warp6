package main;

import board.board;
import ships.*;

public class Tests {

	public String runTests(){
		String result = "";

		result += testMoveShip("SlowShip");
		result += testMoveShip("MediumShip");
		result += testMoveShip("FastShip");
		result += testMaxIndex(new board(100));

		result += testTranslateRing(new board(100));
		
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
		result = shipType + " - Move Test: ";
		
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

	public int[] createTranslateRingKey(){
		int[] rings = {0, 0, 0, 0, 0, 0, 
				1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 9, 9, 10, 11, 11, 12, 13, 13, 14, 15, 15, 16, 17, 17, 
				18, 19, 19, 20, 21, 22, 22, 23, 24, 25, 25, 26, 27, 28, 28, 29, 30, 31, 31, 32, 33, 34, 34, 35, 36, 
				37, 37, 38, 39, 40, 41, 41, 42, 43, 44, 45, 45, 46, 47, 48, 49, 49, 50, 51, 52, 53, 53, 54, 55, 56, 
				57, 57, 58, 59, 60, 61, 61, 62, 63, 64, 65, 66, 66, 67, 68, 69, 70, 71, 71, 72, 73, 74, 75, 76, 76, 
				77, 78, 79, 80, 81, 81, 82, 83, 84, 85, 86, 86, 87, 88, 89, 90};
		return rings;
	}
	public String testTranslateRing(board newBoard){
		TestResult test = new TestResult();
		try{
			int[] rings = createMaxIndexKey();
			test.setResult(true);
			
			for(int i = 1; i < rings.length; i++ ){
				if(rings[i] != newBoard.maxIndex(i)){
					test.addComment("Ring: " + i + " returned: " + newBoard.maxIndex(i) + " Expected: " + rings[i]);
					test.setResult(false);
				}				
			}
		} catch(Exception e){
			test.setException(e);
		}

		if(!test.getResult())
			return "Translate Ring Fail\n" + test.report();
		else
			return "Translate Ring Pass\n";
	}

	public int[] createMaxIndexKey(){ return createMaxIndexKey(6, 6); }
	public int[] createMaxIndexKey(int maxRing, int ringSize){
		int[] rings = {0, 6, 18, 36, 60, 90, 126};
		
		/*
		rings = new int[maxRing+1];
		rings[0] = 0;
		for(int i = 1; i < rings.length; i++ )
			rings[i] = rings[i -1] + ringSize * i ;
		*/		
		return rings;

	}
	
	public String testMaxIndex(board testboard){ return testMaxIndex(testboard, 6, 6); }	
	public String testMaxIndex(board testboard, int maxRing, int ringSize){
		TestResult test = new TestResult();
		int[] rings = null;
		test.setResult(true);
		test.addComment("Get first Node: " + testboard.firstAvailableNode().index());
		
		try{
			rings = createMaxIndexKey(); //maxRing, ringSize
			for(int i = 1; i < rings.length; i++ ){
				if(rings[i] != testboard.maxIndex(i)){
					test.addComment("Ring: " + i + " returned: " + testboard.maxIndex(i) + " Expected: " + rings[i]);
					test.setResult(false);
				}
				else {
					test.addComment("Ring: " + i + " returned: " + testboard.maxIndex(i) + " passed");
				}
			}
		}
		catch(Exception e){
			test.addComment("Failed to complete the test");
			test.setException(e);
		}

		if(!test.getResult())
			return "Max Index Fail\n" + test.report();
		else
			return "Max Index Pass\n";
	}

}

