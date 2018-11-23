import java.util.*;

public class UniformCostSearch   extends ASearch
{
	// Define lists here ...
	private PriorityQueue<ASearchNode> m_openList;
	private ArrayList<ASearchNode> m_closedList;
	
	@Override
	public String getSolverName() 
	{
		return "UCS";
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
		m_closedList = new ArrayList<>();
		m_openList = new PriorityQueue<>(new Comparator<ASearchNode>() {
			@Override
			public int compare(ASearchNode o1, ASearchNode o2) {
				return (int)(o1.getF() - o2.getF());
			}
		});
	}

	@Override
	public ASearchNode getOpen
	(
		ASearchNode node
	) 
	{
		for (ASearchNode aM_openList : m_openList) {
			if (aM_openList.equals(node))
				return aM_openList;
		}
		return null;
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

		return m_openList.poll();
	}

}
