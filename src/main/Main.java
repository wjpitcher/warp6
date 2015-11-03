package main;
import board.*;
import ships.*;

public class Main {

	public static void main(String[] args) {
		Tests tests = new Tests();
		System.out.println(tests.runTests());
		

	}
	
	public static void test1(){
		board warpBoard = new board(100);
		Ship ship = new MediumShip(warpBoard.firstAvailableNode());
		
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


	public static void test2(){
		board warpBoard = new board(100);
		Ship ship = new MediumShip(warpBoard.firstAvailableNode());
		
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
