package board;

public class Node implements INode {
	private INode _next;
	private INode _bump;
	private boolean _occupied = false;	
	private int _index;

	public Node(int index, INode next, INode bump){
		_index = index;
		_next = next;
		_bump = bump;
	}
	
	@Override
	public INode Next(){
		return _next;
	}
	
	@Override
	public void setNext(INode value){
		_next = value;
	}

	@Override
	public INode Bump(){
		return _bump;
	}

	@Override
	public void setBump(INode value){
		_bump = value;
	}

	@Override
	public boolean isOccupied(){ return _occupied;}

	@Override
	public void setOccupied(boolean value){ _occupied = value;}
	
	@Override
	public int index(){
		return _index;
	}

	@Override
    public boolean moveable(int moves){
    	return _index - moves >= 0;
    }

	@Override
    public INode move(int moves){
    	INode node = Next();
	    
    	if(moveable(moves)){
	    	for(int i = 0; i< moves - 1; i++)
	    		node = node.Next();
	    	
	    	while(node.isOccupied())
	    		node = node.Bump();
	    }
	    else 
	    	node = null;
	    
	    return node;
    }
}
	  