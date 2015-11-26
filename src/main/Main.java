package main;
import board.*;
import gui.MainForm;
import ships.*;
import test.Tests;

public class Main {

	public static void main(String[] args) {
		Tests tests = new Tests();

		System.out.println(tests.runTests());
		
		MainForm form = new MainForm(true);
		
	}
}
