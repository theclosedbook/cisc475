package edu.udel.cisc475.kwic;

import java.io.PrintStream;

public interface LineStorage {

	int numLines();

	int numWordsInLine(int line);

	int numCharsInWord(int line, int word);

	char getChar(int line, int word, int c);

	String getWord(int line, int word);
	
	String getLineAsString(int line);

	/** Adds a line and returns the index of the new line. */
	int addLine();

	/** Adds a word to a line and returns the index of the new word */
	int addWord(int line, String str);

	// etc.

	void print(PrintStream out);
}
