package test;

import board.Board;

public class JumpTest implements Test {

	@Override
	public TestResult runTest() {
		return testTranslateRing(new Board(100));
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
	
	public TestResult testTranslateRing(Board newBoard){
		TestResult test = new TestResult("Translate ring");
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

		return test;
	}

}
