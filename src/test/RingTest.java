package test;

import board.Board;

public class RingTest implements Test{

	@Override
	public TestResult runTest() {
		return testMaxIndex(new Board(100));
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
	
	public TestResult testMaxIndex(Board testboard){ return testMaxIndex(testboard, 6, 6); }	
	public TestResult testMaxIndex(Board testboard, int maxRing, int ringSize){
		TestResult test = new TestResult("MaxIndex");
		int[] rings = null;
		test.setResult(true);
		test.addComment("Get first Node: " + testboard.firstAvailableNode().index());
		
		try{
			rings = createMaxIndexKey(); //maxRing, ringSize
			for(int i = 1; i < rings.length; i++ ){
				if(rings[i] != testboard.maxIndex(i)){
					test.addComment("Ring: " + i + " returned: " + testboard.maxIndex(i) + " Expected: " + rings[i]);
					test.setResult(false);
				}
				else {
					test.addComment("Ring: " + i + " returned: " + testboard.maxIndex(i) + " passed");
				}
			}
		}
		catch(Exception e){
			test.addComment("Failed to complete the test");
			test.setException(e);
		}

		return test;
	}
}
