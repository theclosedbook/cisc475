package edu.udel.cisc475.kwic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * An Input object is created to parse a particular text file. The method
 * getWords() returns the LineStorage object presenting a structured view of
 * that file.
 */
public class Input {

	private String filename;

	private LineStorage ls;

	public Input(String filename) {
		this.filename = filename;
	}

	public LineStorage getWords() throws IOException {
		ls = new CommonLineStorage();
		BufferedReader br = new BufferedReader(new FileReader(filename));
		while (true) {
			String theLine = br.readLine();
			if (theLine == null)
				break;
			int line = ls.addLine();
			for (String word : theLine.split("\\h"))
				ls.addWord(line, word);
		}
		br.close();
		return ls;
	}
}
