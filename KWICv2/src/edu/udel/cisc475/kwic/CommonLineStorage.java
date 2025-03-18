package edu.udel.cisc475.kwic;

import java.io.PrintStream;
import java.util.ArrayList;

/**
 * A LineStorage object is structured representation of a text file. A file is a
 * sequence of lines, each of which is a sequence of words. A word is a String
 * (also a sequence of char).
 */
public class CommonLineStorage implements LineStorage {
	/**
	 * For each line, the sequence of words in that line.
	 */
	private ArrayList<ArrayList<String>> theWords = new ArrayList<>();

	public CommonLineStorage() {
	}

	public int numLines() {
		return theWords.size();
	}

	public int numWordsInLine(int line) {
		return theWords.get(line).size();
	}

	public int numCharsInWord(int line, int word) {
		return theWords.get(line).get(word).length();
	}

	public char getChar(int line, int word, int c) {
		return theWords.get(line).get(word).charAt(c);
	}

	public String getWord(int line, int word) {
		return theWords.get(line).get(word);
	}

	public String getLineAsString(int line) {
		StringBuffer buf = new StringBuffer();
		for (String word : theWords.get(line)) {
			buf.append(word);
			buf.append(" ");
		}
		return buf.toString();
	}

	/** Adds a line and returns the index of the new line. */
	public int addLine() {
		theWords.add(new ArrayList<>());
		return theWords.size() - 1;
	}

	/** Adds a word to a line and returns the index of the new word */
	public int addWord(int line, String str) {
		ArrayList<String> wordsInLine = theWords.get(line);
		wordsInLine.add(str);
		return wordsInLine.size() - 1;
	}

	// etc.

	public void print(PrintStream out) {
		for (ArrayList<String> line : theWords) {
			for (String word : line) {
				out.print(word);
				out.print(" ");
			}
			out.println();
		}
	}
}
