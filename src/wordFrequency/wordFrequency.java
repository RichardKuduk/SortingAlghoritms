package wordFrequency;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class wordFrequency {
// Richard Kuduk - L00120064
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		// Counter
		int counter = 0;
		// Declare a map to hold a key and value
		Map<String, Integer> wordsList = readWords("War_and_Peace.txt");

		// Gets all the key from the wordsList map
		Set<String> keySet = wordsList.keySet();
		// For each key in keySet
		for (String key : keySet) {
			// print only first 100 words
			if (counter++ < 100) {
				//				print word(key) +   associated value	
				System.out.println(key + " " + wordsList.get(key));
				
			}
		}
	}

	public static Map<String, Integer> readWords(String filename) throws FileNotFoundException {
		// Declare map
		Map<String, Integer> words = new TreeMap<String, Integer>();
		// Scanner object to read our file
		Scanner in = new Scanner(new File(filename));
		// Use any characters other than a-z or A-Z as delimiters
		in.useDelimiter("[^a-zA-Z]+");

		while (in.hasNext()) {
			// System.out.println(in.next());
			// Add each next word from Scanner to the HashSet and cast it to
			// lower case letter because some words maybe not capitalized
			// Assign string s a word from the scanner
			String s = in.next().toLowerCase();
			// if map contains this word
			if (words.containsKey(s)) {
				// increase the counter (value) for this key
				words.put(s, words.get(s) + 1);
			} else {
				// if doesn't create this key with value of 1 
				words.put(s, 1);
			}
		}
		// return set
		return words;
	}

}
