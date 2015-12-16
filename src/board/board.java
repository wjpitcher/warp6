package board;

public class Board implements IBoard {
	private int _nodeCount;
	private INode[] _map;

	public Board(){
		this(126);	
	}
	
	public Board(int nodeCount){
		_nodeCount = nodeCount;
		_map = new Node[_nodeCount];
		_map[0] = new Node(0,null, null);
		
		for(int i = 1; i < _nodeCount; i++){
			_map[i] = new Node(i, _map[i -1], _map[getBumpIndex(i)]);
		}		
	}
	
	@Override
	public INode firstAvailableNode(){
		INode firstNode = _map[_nodeCount - 1];
		
		while(firstNode.isOccupied())
			firstNode = firstNode.move(1);
		
		return firstNode;
	}
	private static int[] bump = {0, 0, 0, 0, 0, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7
				               , 8, 9, 9, 10, 11, 11, 12, 13, 13, 14, 15, 15, 16, 17, 17, 18
				               , 19, 19, 20, 21, 22, 22, 23, 24, 25, 25, 26, 27, 28, 28, 29, 30
				               , 31, 31, 32, 33, 34, 34, 35, 36, 37, 37, 38, 39, 40, 41, 41, 42
				               , 43, 44, 45, 45, 46, 47, 48, 49, 49, 50, 51, 52, 53, 53, 54, 55
				               , 56, 57, 57, 58, 59, 60, 61, 61, 62, 63, 64, 65, 66, 66, 67, 68
				               , 69, 70, 71, 71, 72, 73, 74, 75, 76, 76, 77, 78, 79, 80, 81, 81
				               , 82, 83, 84, 85, 86, 86, 87, 88, 89, 90};
	
	@Override
	public int getBumpIndex(int index){
		return bump[index];
		// The following expression should have produced the proper bump index.  
		// until it is fixed it has been replaced with a lookuptable. 
		/* 
		int ring = getRing(index);
		return (index + Math.max((ring - 2), 0) )/ring + (ring -1)* 3;
		*/
	}
	
	@Override
	public int getRing(int index){
		int previous = 0;
		int ring = 0;
		
		while(index > (ring * 6) + previous ){
			previous += ring * 6;
			ring++;
		}
		
		return ring;
	}
	
	@Override
	public int maxIndex(int ringNumber){
		int max = 0;
		
		for(int i = 1; i <= ringNumber; i++){
			max += i * 6;
		}
		
		return max;
	}

	@Override
	public INode getNode(int index) {
		
		return _map[index];
	}

	@Override
	public INode getBumpNode(int index) {
		if(index > 0)
			return _map[getBumpIndex(index)];
		else
			return null;
	}

	@Override
	public INode getNextNode(int index) {
		if(index > 0)
			return _map[index -1];
		else
			return null;
	}
	

	@Override
	public void setNodes(INode[] nodes) {
		_map = nodes;
	}

	@Override
	public INode[] getNodes() {
		return _map;
	}
}

