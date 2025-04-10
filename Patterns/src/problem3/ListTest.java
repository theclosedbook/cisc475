package problem3;

import java.io.PrintStream;

public class ListTest {

	public static void main(String[] args) {
		PrintStream out = System.out;
		NumList nl = new NumList();
		out.println("The empty list is: " + nl);
		assert nl.isEmpty();
		NumList nl1 = nl.cons(1);
		out.println("List containing just 1: " + nl1);
		assert !nl1.isEmpty();
		assert nl1.first() == 1;
		assert nl1.rest().isEmpty();
		NumList nl2 = (nl1.cons(-7)).cons(35);
		out.println("Should be 35, -7, 1: " + nl2);
		assert nl2.first() == 35;
		assert nl2.rest().first() == -7;
		out.println("OK.");
	}

}
