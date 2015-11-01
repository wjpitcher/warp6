package board;

public class board {
	private int _nodeCount;
	private Node[] _map;
	
	public board(int nodeCount){
		_nodeCount = nodeCount;
		_map = new Node[_nodeCount];
		_map[0] = new Node(0,null, null);
		
		for(int i = 1; i < _nodeCount; i++){
			_map[i] = new Node(i, _map[i -1], _map[getBumpIndex(i)]);
		}		
	}
	
	public Node firstAvailableNode(){
		Node firstNode = _map[_nodeCount - 1];
		
		while(firstNode.isOccupied())
			firstNode = firstNode.move(1);
		
		return firstNode;
	}
	
	private int getBumpIndex(int index){
		return 0;
	}

}

