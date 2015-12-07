package board;

public interface INode {
	public void setNext(INode value);
	
	public INode Next();
	
	public INode Bump();
	
	public void setBump(INode value);
	
	public boolean isOccupied();
	
	public void setOccupied(boolean value);
	
	public int index();
	
    public boolean moveable(int moves);
    
    public INode move(int moves);
}
