package problem3;

/** A nonempty, immutable list of int. */
public class NonemptyNumList extends ImmutableNumList {

	/** The first element of the list */
	private int first;

	/** The rest of the list after the first element */
	private ImmutableNumList rest;

	NonemptyNumList(int first, ImmutableNumList rest) {
		this.first = first;
		this.rest = rest;
	}

}
