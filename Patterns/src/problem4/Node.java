package problem4;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * A plain node in a directed graph. All it stores is an integer ID number and
 * its list of successor nodes. For each successor node v, there is an edge in
 * the graph from this node to v.
 */
public class Node {

	private int id;

	private Set<Node> successors = new LinkedHashSet<>();

	public Node(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String toString() {
		return "Node[" + id + "]";
	}

	void addSuccessor(Node that) {
		successors.add(that);
	}

	public Iterator<Node> getSuccessorIter() {
		return successors.iterator();
	}
}
