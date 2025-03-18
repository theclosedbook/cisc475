package edu.udel.cisc475.kwic;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Comparator;

public class Alphabetizer {

	private LineStorage ls;

	private Integer perm[];

	public Alphabetizer(LineStorage ls) {
		this.ls = ls;
	}

	class IComp implements Comparator<Integer> {
		@Override
		public int compare(Integer o1, Integer o2) {
			String line1 = ls.getLineAsString(o1),
					line2 = ls.getLineAsString(o2);
			return line1.compareTo(line2);
		}
	}

	public void alph() {
		int n = ls.numLines();
		perm = new Integer[n];
		for (int i = 0; i < n; i++)
			perm[i] = i;
		Comparator<Integer> comp = new IComp();
		Arrays.sort(perm, comp);
	}

	public int ith(int i) {
		return perm[i];
	}

	public void print(PrintStream out) {
		out.println(Arrays.toString(perm));
	}
}
