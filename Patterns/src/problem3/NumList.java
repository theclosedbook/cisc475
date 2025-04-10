package problem3;

/**
 * A mutable list of numbers. The data in each list is stored in an array of int
 * that is private to one list.
 */
public class NumList {

	/**
	 * The data of this list. This array is always non-null, but might have
	 * length 0.
	 */
	private int[] data;

	/** Constructs new instance with given data array */
	private NumList(int[] data) {
		this.data = data;
	}

	/** Constructs a new empty list */
	public NumList() {
		this(new int[0]);
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("{ ");
		for (int i = 0; i < data.length; i++)
			sb.append(data[i] + " ");
		sb.append("}");
		return sb.toString();
	}

	/** Is this list empty? */
	public boolean isEmpty() {
		return data.length == 0;
	}

	/**
	 * Get the first element in this list. Precondition: list must be nonempty.
	 */
	public int first() {
		return data[0];
	}

	/**
	 * Get the list obtained by removing the first element from this list.
	 * Precondition: list must be nonempty.
	 */
	public NumList rest() {
		if (data.length == 0)
			throw new RuntimeException("List is empty");
		int[] newData = new int[data.length - 1];
		for (int i = 1; i < data.length; i++)
			newData[i - 1] = data[i];
		return new NumList(newData);
	}

	/**
	 * Returns a new list in which the first element is val and the rest of the
	 * list is identical to this list. I.e., it returns the list obtained by
	 * pre-pending val to this.
	 */
	public NumList cons(int val) {
		int[] newData = new int[data.length + 1];
		newData[0] = val;
		for (int i = 0; i < data.length; i++)
			newData[i + 1] = data[i];
		return new NumList(newData);
	}

	/**
	 * Modifies this list by changing its first element to the given value. This
	 * mutation method is provided in addition to the methods specified in
	 * {@link NumListIF}. Precondition: list is nonempty.
	 */
	public void setFirst(int val) {
		if (data.length == 0)
			throw new RuntimeException("List is empty");
		data[0] = val;
	}
}
