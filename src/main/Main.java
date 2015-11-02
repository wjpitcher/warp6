package main;
import board.*;
import ships.Ship;

public class Main {

	public static void main(String[] args) {
		test1();
		

	}
	
	public static void test1(){
		board warpBoard = new board(100);
		Ship ship = new Ship(4,1, warpBoard.firstAvailableNode());
		
		System.out.println("Ship Speed:" + ship.getSpeed());
		
		while(ship.getIndex() > 0 ){
			if(ship.movable()){
				ship.move();
				System.out.println("Ship moved to: " + ship.getIndex());
			}
			else{
				ship.decrement();
				System.out.println("Ship reduced speed to " + ship.getSpeed());
			}
		}
	}

}
