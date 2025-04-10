package problem4;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;

/** A directed graph, in which nodes are instances of class {@link Node}. */
public class DirectedGraph {

	/** The nodes which occur in this directed graph, in order of their IDs. */
	private ArrayList<Node> nodes = new ArrayList<>();

	/** Constructs a new empty graph. */
	public DirectedGraph() {
	}

	/**
	 * Adds a node to the graph. The new node has no outgoing (or incoming)
	 * edges.
	 * 
	 * @return the new node
	 */
	public Node addNode() {
		Node node = new Node(nodes.size());
		nodes.add(node);
		return node;
	}

	/**
	 * Adds an edge in this graph from the source node to the destination node.
	 * Precondition: both nodes must belong to this graph.
	 */
	public void addEdge(Node source, Node destination) {
		assert nodes.get(source.getId()) == source;
		assert nodes.get(destination.getId()) == destination;
		source.addSuccessor(destination);
	}

	/**
	 * Prints the directed graph to the given stream.
	 */
	public void print(PrintStream out) {
		for (Node u : nodes) {
			out.print(u.getId() + " -> ");
			Iterator<Node> iter = u.getSuccessorIter();
			while (iter.hasNext()) {
				Node v = iter.next();
				out.print(v.getId());
				if (iter.hasNext())
					out.print(", ");
			}
			out.println();
		}
	}
}
