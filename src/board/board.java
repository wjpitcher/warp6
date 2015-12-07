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
	
	@Override
	public int getBumpIndex(int index){
		int ring = getRing(index);
		return (index + Math.max((ring - 2), 0) )/ring + (ring -1)* 3;
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

