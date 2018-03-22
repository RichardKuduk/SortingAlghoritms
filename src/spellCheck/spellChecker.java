package spellCheck;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class spellChecker<E> {
// Richard Kuduk - L00120064
	public static void main(String[] args) throws FileNotFoundException {
		// Counter to count number of words
		int counter = 0;
		// Read the dictionary and the document
		Set<String> dictionaryWords = readWords("Dictionary.txt");
		// Read a book
		Set<String> bookWords = readWords("Alice_in_Wonderland.txt");
		// Treeset for sortedData
		SortedSet<String> sortedData = new TreeSet<String>();
		// For each word in bookWords
		System.out.println("Words that are in the book but not in dictionary: ");
		for (String s : bookWords) {
			// if dictionary does not contains a word from book
			if (!dictionaryWords.contains(s)) {
				// Print the word
				System.out.println("Word number: " + ++counter + " ---> " + s);
				// Add words to sortedData set
				sortedData.add(s);

				
			}
		}
		// Print the sorted words
		System.out.println("Alphabetical order: " + "\n" + sortedData);

		
	}

	public static Set<String> readWords(String filename) throws FileNotFoundException {
		// Declare set
		Set<String> words = new HashSet<String>();
		// Scanner object to read our file
		Scanner in = new Scanner(new File(filename));
		// Use any characters other than a-z or A-Z as delimiters
		in.useDelimiter("[^a-zA-Z]+");

		while (in.hasNext()) {
			// System.out.println(in.next());
			// Add each next word from Scanner to the HashSet and cast it to
			// lower case letter because some words maybe not capitalized
			words.add(in.next().toLowerCase());
		}
		// return set
		return words;
	}

}
