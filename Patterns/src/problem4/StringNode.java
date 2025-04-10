package problem4;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * A richer kind of node which also has a "text" field.
 */
public class StringNode {

	private int id;
	private String text;
	private Set<StringNode> successors = new LinkedHashSet<>();

	public StringNode(int id, String text) {
		this.id = id;
		this.text = text;
	}

	public String toString() {
		return "Node[" + id + ", " + text + "]";
	}

	void addSuccessor(StringNode that) {
		successors.add(that);
	}

	public Iterator<StringNode> getSuccessorIter() {
		return successors.iterator();
	}

}
