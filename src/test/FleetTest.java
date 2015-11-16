package test;

import java.awt.Color;
import java.util.Arrays;

import board.Board;
import player.*;
import ships.Fleet;
import ships.Ship;

public class FleetTest implements Test{

	@Override
	public TestResult runTest() {
		TestResult result  = new TestResult("Fleet setup");
		manifestTest(result);
		manifestMultipleAddTest(result);
		fleetTest(result);
		playersTest(result);
		
		return result;
		
	}

	private void manifestMultipleAddTest(TestResult result){
		 Fleet fleet = new Fleet();
		 try{ 
				fleet.add("Fast",2);
				fleet.add("Medium",3);
				fleet.add("Slow",4);

				if(!Arrays.toString(fleet.manifest).equals("[Fast, Fast, Medium, Medium, Medium, Slow, Slow, Slow, Slow]")){
					result.addComment("Invalid Manifest: " + Arrays.toString(fleet.manifest));		
					result.setResult(false);
				}
				else
					result.addComment("Manifest multiple add: Passed"); 	
				
		 } catch (Exception e){
			result.setException(e);
		 }
	}
	
	private void manifestTest(TestResult result){
		 Fleet fleet = new Fleet();
		 try{ 
			fleet.add("Fast");
			fleet.add("Medium");
			fleet.add("Slow");

			if(!Arrays.toString(fleet.manifest).equals("[Fast, Medium, Slow]")){
				result.addComment("Invalid Manifest: " + Arrays.toString(fleet.manifest));	
				result.setResult(false);
			}
			else
				result.addComment("Manifest add: Passed"); 	
		 } catch (Exception e){
			result.setException(e);
		 }
	}

	
	private void fleetTest(TestResult result){
		Fleet fleet = new Fleet();

		fleet.add("Fast",2);
		fleet.add("Medium",3);
		fleet.add("Slow",4);
		
		try{ 
			Ship[] fleets = fleet.generateFleet();
			if(fleets.length != 9)
				if(result.getResult()){
					result.addComment("Invalid length:" + fleets.length );
					result.setResult(false);
				}
			
		 } catch (Exception e){
			result.setException(e);
		 }
	}
	
	private void playersTest(TestResult result){

		Players players = new Players();
		players.Add(new Player("P1", Color.GREEN));
		players.Add(new Player("P2", Color.RED));
		players.Add(new Player("P3", Color.BLUE));
		players.Add(new Player("P4", Color.YELLOW));
				
		if(players.setup(new Board(126))){
			for(int i = 0; i < players.players.length; i++){
				if(players.players[i].ships.length != 9){
					result.addComment(players.players[i].getName() + ": " + players.players[i].ships);
					result.setResult(false);
				}
			}
		}
		else
			result.setResult(false);
	}

}
