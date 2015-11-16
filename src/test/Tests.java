package test;

public class Tests {

	public String runTests(){
		String result = "";

		result += new ShipTest().runTest().toString(); // testMoveShip("SlowShip");

		result += new RingTest().runTest().toString(); 

		result += new JumpTest().runTest().toString(); 
		
		result += new FleetTest().runTest().toString(); 
		
		return result;
	}
}

