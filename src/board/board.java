package board;

public class Board {
	private int _nodeCount;
	private Node[] _map;

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
	
	public Node firstAvailableNode(){
		Node firstNode = _map[_nodeCount - 1];
		
		while(firstNode.isOccupied())
			firstNode = firstNode.move(1);
		
		return firstNode;
	}
	
	public int getBumpIndex(int index){
		int ring = getRing(index);
		return (index + Math.max((ring - 2), 0) )/ring + (ring -1)* 3;
	}

	public int getRing(int index){
		int previous = 0;
		int ring = 0;
		
		while(index > (ring * 6) + previous ){
			previous += ring * 6;
			ring++;
		}
		
		return ring;
	}

	public int maxIndex(int ringCount){
		int max = 0;
		
		for(int i = 1; i <= ringCount; i++){
			max += i * 6;
		}
		
		return max;
	}
	
	
}

