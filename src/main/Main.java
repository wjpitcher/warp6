package main;
import board.*;
import ships.ship;

public class Main {

	public static void main(String[] args) {
		test1();
		

	}
	
	public static void test1(){
		board warpBoard = new board(100);
		Node Ship = warpBoard.firstAvailableNode();
		
		while(Ship.moveable(1) )
			System.out.println(Ship.index());
			Ship = Ship.move(1);
			
	}

}
