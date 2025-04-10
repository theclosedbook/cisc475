package problem3;

import java.io.PrintStream;

public class ImmutableListTest {

	public static void main(String[] args) {
		PrintStream out = System.out;
		ImmutableNumList nl = ImmutableNumList.emptyList();
		out.println("The empty list is: " + nl);
		assert nl.isEmpty();
		NonemptyNumList nl1 = nl.cons(1);
		out.println("List containing just 1: " + nl1);
		assert !nl1.isEmpty();
		assert nl1.first() == 1;
		assert nl1.rest().isEmpty();
		NonemptyNumList nl2 = (nl1.cons(-7)).cons(35);
		out.println("Should be 35, -7, 1: " + nl2);
		assert nl2.first() == 35;
		assert ((NonemptyNumList) nl2.rest()).first() == -7;
		out.println("OK.");
	}

}
