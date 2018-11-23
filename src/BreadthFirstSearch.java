import java.util.*;

public class BreadthFirstSearch  extends ASearch
{
	// Define lists here ...
    private ArrayList<ASearchNode> m_openList;
    private ArrayList<ASearchNode> m_closedList;

	
	@Override
	public String getSolverName() 
	{
		return "BFS";
	}

	@Override
	public ASearchNode createSearchRoot
	(
		IProblemState problemState
	) 
	{
		ASearchNode newNode = new BlindSearchNode(problemState);
		return newNode;
	}
	
	@Override
	public void initLists() 
	{
        m_openList = new ArrayList<>();
        m_closedList = new ArrayList<>();
	}

	@Override
	public ASearchNode getOpen
	(
		ASearchNode node
	) 
	{
		int idx = m_openList.indexOf(node);
		return idx == -1 ? null : m_openList.get(idx);
	}

	@Override
	public boolean isOpen
	(
		ASearchNode node
	) 
	{
		return m_openList.contains(node);
	}
	
	@Override
	public boolean isClosed
	(
		ASearchNode node
	) 
	{
		return m_closedList.contains(node);
	}

	@Override
	public void addToOpen
	(
		ASearchNode node
	) 
	{
			m_openList.remove(node);
			m_openList.add(node);
	}

	@Override
	public void addToClosed
	(
		ASearchNode node
	) 
	{
        m_closedList.add(node);
	}

	@Override
	public int openSize() 
	{
		return m_openList.size();
	}

	@Override
	public ASearchNode getBest() 
	{
		return m_openList.remove(0);
	}

}
