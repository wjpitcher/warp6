package main;
import board.*;
import ships.*;
import test.Tests;

public class Main {

	public static void main(String[] args) {
		Tests tests = new Tests();

		System.out.println(tests.runTests());
	}
	
	public static void test1(){
		Board warpBoard = new Board(100);
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
		Board warpBoard = new Board(100);
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
