import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PureHeuristicSearch  extends ASearch
{
	// Define lists here ...
	private PriorityQueue<ASearchNode> m_openList;
	private ArrayList<ASearchNode> m_closeList;
	
	@Override
	public String getSolverName() 
	{
		return "PHS";
	}

	@Override
	public ASearchNode createSearchRoot
	(
		IProblemState problemState
	) 
	{
		ASearchNode newNode = new HeuristicSearchNode(problemState);
		return newNode;
	}
	
	@Override
	public void initLists() 
	{
		m_openList = new PriorityQueue<>(new Comparator<ASearchNode>() {
			@Override
			public int compare(ASearchNode o1, ASearchNode o2) {
				if (o1.getH() > o2.getH())
					return 1;
				else if (o1.getH() < o2.getH())
					return -1;
				return 0;
			}
		});
		m_closeList = new ArrayList<>();
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
		return m_closeList.contains(node);
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
		m_closeList.add(node);
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