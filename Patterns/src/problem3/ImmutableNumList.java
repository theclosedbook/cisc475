package problem3;

/** An immutable list of int. */
public abstract class ImmutableNumList {

	/** Single, fixed copy of the empty list. */
	private final static ImmutableNumList emptyList = new EmptyNumList();

	public ImmutableNumList() {
	}

	/**
	 * Is this list empty? Note: if it is not empty, this object can be safely
	 * cast to {@link NonemptyNumList}.
	 */
	public abstract boolean isEmpty();

	/** Returns the list obtained by prepending val to this list. */
	public abstract NonemptyNumList cons(int val);

	/** Returns the empty list */
	public static ImmutableNumList emptyList() {
		return emptyList;
	}
}
