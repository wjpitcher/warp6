package test;

import java.awt.Color;

import player.Player;
import player.Players;
// import board.Board;

public class PlayTest implements Test{
	
	
	@Override
	public TestResult runTest() {
		TestResult result = new TestResult("Playthrough Test");
		playTest(result);
		return result;
	}
	
	private void playTest(TestResult result){

		Players players = new Players();
		//Board board = new Board(126);
		
		players.Add(new Player("P1", Color.GREEN));
		players.Add(new Player("P2", Color.RED));
		players.Add(new Player("P3", Color.BLUE));
		players.Add(new Player("P4", Color.YELLOW));
				
		if(players.setup(126)){
			for(int i = 0; i < players.players.length; i++){
				if(players.players[i].getShips().length != 9){
					result.addComment(players.players[i].getName() + ": " + players.players[i].getShips());
					result.setResult(false);
				}
			}

			int indexsum = 0;
			int indexprevsum = 0;
			for(int i = 0; i < players.players.length; i++){
				indexsum = 0;
				for(int j = 0; j < players.players[i].getShips().length; j++){
					/*
					System.out.println( players.players[i].getName() + ": "
							          + players.players[i].getShips()[j].getIndex() + " "
						              + players.players[i].getShips()[j].getClass() + " "
					                  );
					*/                  
					indexsum += players.players[i].getShips()[j].getIndex();
				}
			}
		}
		else
			result.setResult(false);
	}

}
