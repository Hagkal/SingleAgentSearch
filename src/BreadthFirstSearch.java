import java.util.*;

public class BreadthFirstSearch  extends ASearch
{
	// Define lists here ...
    private Queue<ASearchNode> m_openList;
    private HashSet<ASearchNode> m_opedAid;
    private AbstractSet<ASearchNode> m_closedList;

	
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
        m_openList = new LinkedList<>();
        m_opedAid = new HashSet<>();
        m_closedList = new HashSet<>();
	}

	@Override
	public ASearchNode getOpen
	(
		ASearchNode node
	) 
	{
	    ASearchNode toReturn = null;
        if (isOpen(node)) {
            m_opedAid.remove(node);
            toReturn = getNode(getIdx(node));
        }
		return toReturn;
	}

	@Override
	public boolean isOpen
	(
		ASearchNode node
	) 
	{
		return m_opedAid.contains(node);
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
		m_openList.add(node);
		m_opedAid.add(node);
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
		ASearchNode toreturn = m_openList.poll();
		m_opedAid.remove(toreturn);

		return toreturn;
	}


    /**
     * an aid method to retrieve nodes
     * @param node - the node to retrieve
     * @return - idx of the node if exists, -1 otherwise
     */
	private int getIdx(ASearchNode node){
        LinkedList list = (LinkedList) m_openList;
        return list.indexOf(node);
    }


    /**
     * aid method to retrieve the node from specific idx
     * @param idx - the idx
     * @return the node of that idx
     */
    private ASearchNode getNode(int idx){
        LinkedList list = (LinkedList) m_openList;
        return (ASearchNode) list.get(idx);
    }

}
