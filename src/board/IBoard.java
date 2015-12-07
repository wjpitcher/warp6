package board;

public interface IBoard {
	
	public INode firstAvailableNode();

	public INode getNode(int index);
	
	public void setNodes(INode[] nodes);
	public INode[] getNodes();

	public INode getBumpNode(int index);
	
	public INode getNextNode(int index);
	
	public int getBumpIndex(int index);

	public int getRing(int index);

	public int maxIndex(int ringNumber);
	
}
