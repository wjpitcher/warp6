package board;

public class Node {
	private Node _next;
	private Node _bump;
	private boolean _occupied = false;	
	private int _index;

	public Node(int index, Node next, Node bump){
		_index = index;
		_next = next;
		_bump = bump;
	}
	
	public Node Next(){
		return _next;
	}
	
	public void setNext(Node value){
		_next = value;
	}
	
	public Node Bump(){
		return _bump;
	}
	
	public void setBump(Node value){
		_bump = value;
	}
	
	public boolean isOccupied(){ return _occupied;}
	public void setOccupied(boolean value){ _occupied = value;}
	
	public int index(){
		return _index;
	}
	
    public boolean moveable(int moves){
    	return _index - moves >= 0;
    }
    
    public Node move(int moves){
    	Node node = Next();
	    
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
	  