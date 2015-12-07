package test;

import board.Board;
import ships.IShip;

public class ShipTest implements Test {

	@Override
	public TestResult runTest() {
		TestResult test = new TestResult("Ship Move");
		
		try{
			testMoveShip("Slow", test);			
		}catch(Exception e){
			test.setException(e);
		}
		
		try{
			testMoveShip("Medium", test);			
		}catch(Exception e){
			test.setException(e);
		}
		
		try{
			testMoveShip("Fast", test);			
		}catch(Exception e){
			test.setException(e);
			e.printStackTrace();
		}
		
		return test;
	}	

	public void testMoveShip(String shipType, TestResult test) throws Exception{
		test.addComment(shipType + " - Move Test: "); 
		
		for(int i = 0; i < 100; i++){
			moveShip(ships.Fleet.getShip(shipType), test);

			if(!test.getResult())
				break;
		}
	}
	
	public void moveShip(IShip ship, TestResult test){
		test.setResult(true);

		// Board warpBoard = new Board(100);
		ship.move();
		
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

		}catch(Exception e){
			test.addComment("Error: (" + ship.getIndex() + ")" + e.getMessage());
			test.setException(e);
		}
	}
}