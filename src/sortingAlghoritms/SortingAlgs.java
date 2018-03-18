package sortingAlghoritms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class SortingAlgs extends JFrame implements ActionListener {
	// Richard Kuduk - L00120064
	// Lyit - Assigment for Alghoritms and Data Structures

	// Declare Components
	JPanel topPanel, leftPanel, centerPanel, buttonPanel;
	// JPanel boxes as array
	JPanel[] quadrats;
	// Header
	JLabel lblHeading;
	// Values for combobox
	Integer[] size = { 1000, 10000, 100000 };
	// Combobox
	JComboBox<Integer> sizeList;
	// elements as arrays
	JLabel[] lblAlgName, lblTime, lblSwaps, lblComprasions, lblSortingNames;
	// textfields as arrays
	JTextField[] jtfTime, jtfNoSwaps, jtfNoComprasions;
	// Declare 3 arrays
	int[] randomNumbers, ascendingNumbers, descendingNumbers;
	// Object to keep track of sorted data
	SorterObject results;

	public SortingAlgs() {
		// Declare components
		topPanel = new JPanel();
		lblHeading = new JLabel("Select the number of elements: ");
		// Assign a chosen size
		sizeList = new JComboBox<Integer>(size);
		// Add actio listener
		sizeList.addActionListener(this);
		sizeList.setSelectedIndex(1);
		topPanel.add(lblHeading);
		topPanel.add(sizeList);
		// set center panel to be 3 rows and 5 columns
		centerPanel = new JPanel(new GridLayout(3, 5, 10, 10));
		// create 15 panels for each box
		quadrats = new JPanel[15];
		// create labels for first column
		lblAlgName = new JLabel[3];
		lblTime = new JLabel[3];
		lblSwaps = new JLabel[3];
		lblComprasions = new JLabel[3];
		// Declare font to be used in gui
		Font font = new Font("Courier", Font.BOLD,15);

		// First columns labels
		String[] arrayNames = { "Random Sorted: ", "Sorted: ", "Inversely sorted: " };
		// Creating labels for first column
		for (int i = 0; i < 3; i++) {
			lblAlgName[i] = new JLabel(arrayNames[i]);
			lblAlgName[i].setFont(font);
			lblTime[i] = new JLabel("Time elapsed: ");
			lblTime[i].setFont(font);

			lblSwaps[i] = new JLabel("No. of swaps: ");
			lblSwaps[i].setFont(font);

			lblComprasions[i] = new JLabel("No. comprasions: ");
			lblComprasions[i].setFont(font);


		}
		// Rest of the columns
		String[] sortingBoxes = { "Bubble Sort ", "Enhaced Bubble Sort ", "Selection Sort ", "Insertion Sort " };
		// Creating arrays label and textfield
		lblSortingNames = new JLabel[12];
		jtfTime = new JTextField[12];
		jtfNoSwaps = new JTextField[12];
		jtfNoComprasions = new JTextField[12];
		// Creating labels and textfields to each of the boxes (panels)
		for (int i = 0; i < 12; i++) {
			lblSortingNames[i] = new JLabel(sortingBoxes[i % 4]);
			lblSortingNames[i].setFont(font);
			jtfTime[i] = new JTextField();
			jtfTime[i].setFont(font);
			jtfNoSwaps[i] = new JTextField();
			jtfNoSwaps[i].setFont(font);

			jtfNoComprasions[i] = new JTextField();
			jtfNoComprasions[i].setFont(font);

			

		}

		for (int i = 0; i < quadrats.length; i++) {
			// Create each box
			quadrats[i] = new JPanel(new GridLayout(4, 1, 5, 5));
			// Set some random colors
			quadrats[i].setBackground(new Color(i * 15, 155, 120));
			// Create labels in first column
			if (i % 5 == 0) {
				quadrats[i].add(lblAlgName[i / 5]);
				quadrats[i].add(lblTime[i / 5]);
				quadrats[i].add(lblSwaps[i / 5]);
				quadrats[i].add(lblComprasions[i / 5]);

			} else {
				// create text field in other columns
				quadrats[i].add(lblSortingNames[(i - 1 - (int) (i / 5))]);
				quadrats[i].add(jtfTime[(i - 1 - (int) (i / 5))]);
				quadrats[i].add(jtfNoSwaps[(i - 1 - (int) (i / 5))]);
				quadrats[i].add(jtfNoComprasions[(i - 1 - (int) (i / 5))]);

			}

			centerPanel.add(quadrats[i]);
		}
		// button panel
		buttonPanel = new JPanel(new GridLayout(1, 5));
		JButton temp;
		// Array to hold button names
		String[] names = { "Reset", "Bubble", "Bubble Enhaced", "Selection", "Insertion" };
		// Add buttons with names and add action listener
		for (Integer i = 0; i < 5; i++) {
			buttonPanel.add(temp = new JButton(names[i]));
			temp.addActionListener(this);
		}

		// add(leftPanel , BorderLayout.WEST);
		add(topPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
	
		results = new SorterObject();
		// Call method to generate arrays with chosen element size
		populateArrays();

	}

	private void populateArrays() {
		// TODO Auto-generated method stub
		// Get the size choosen
		int n = (int) sizeList.getSelectedItem();
		// Pass n 
		randomNumbers = new int[n];
		ascendingNumbers = new int[n];
		descendingNumbers = new int[n];
		// Generate arrays
		GenerateArrays.generateRandomNumbers(randomNumbers);
		GenerateArrays.populateAscendingArray(ascendingNumbers);
		GenerateArrays.populateDescendingArray(descendingNumbers);

	}

	public static void main(String[] args) {

		SortingAlgs frame = new SortingAlgs();
		frame.setTitle("Richard Kuduk - L00120064 - Alghoritms and Data Structures");
		frame.setSize(1200, 800);
		frame.setResizable(false);
		// Close operation
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		// Show frame
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Event for combobox size
		if (e.getSource() == sizeList) {
			populateArrays();
		}
		
		// event for buttons
		else {
			String choice = ((JButton) e.getSource()).getText();
			// Switch for each of the buttons
			switch (choice) {
			case "Bubble":
				// Reset the result object fields
				results.reset();
				// Call Bubble sort with random array
				BubbleSortBasic.bubbleSortBasic(randomNumbers, results);
				// Assign JTextFields with values
				jtfTime[0].setText(String.valueOf(results.time) + " ms ");
				jtfNoSwaps[0].setText(String.valueOf(results.numberOfSwaps));
				jtfNoComprasions[0].setText(String.valueOf(results.numberOfComparisons));
				// Ascending array
				results.reset();
				BubbleSortBasic.bubbleSortBasic(ascendingNumbers, results);
				jtfTime[4].setText(String.valueOf(results.time) + " ms ");
				jtfNoSwaps[4].setText(String.valueOf(results.numberOfSwaps));
				jtfNoComprasions[4].setText(String.valueOf(results.numberOfComparisons));
				// Descending array
				results.reset();
				BubbleSortBasic.bubbleSortBasic(descendingNumbers, results);
				jtfTime[8].setText(String.valueOf(results.time) + " ms ");
				jtfNoSwaps[8].setText(String.valueOf(results.numberOfSwaps));
				jtfNoComprasions[8].setText(String.valueOf(results.numberOfComparisons));

				break;
			case "Bubble Enhaced":
				
				results.reset();
				BubbleSortEnhaced.bubbleSortWithBreak(randomNumbers, results);
				jtfTime[1].setText(String.valueOf(results.time) + " ms ");
				jtfNoSwaps[1].setText(String.valueOf(results.numberOfSwaps));
				jtfNoComprasions[1].setText(String.valueOf(results.numberOfComparisons));

				results.reset();
				BubbleSortEnhaced.bubbleSortWithBreak(ascendingNumbers, results);
				jtfTime[5].setText(String.valueOf(results.time) + " ms ");
				jtfNoSwaps[5].setText(String.valueOf(results.numberOfSwaps));
				jtfNoComprasions[5].setText(String.valueOf(results.numberOfComparisons));

				results.reset();
				BubbleSortEnhaced.bubbleSortWithBreak(descendingNumbers, results);
				jtfTime[9].setText(String.valueOf(results.time) + " ms ");
				jtfNoSwaps[9].setText(String.valueOf(results.numberOfSwaps));
				jtfNoComprasions[9].setText(String.valueOf(results.numberOfComparisons));
				break;
			case "Selection":
				
				results.reset();
				SelectionSort.doSelectionSort(randomNumbers, results);
				jtfTime[2].setText(String.valueOf(results.time) + " ms ");
				jtfNoSwaps[2].setText(String.valueOf(results.numberOfSwaps));
				jtfNoComprasions[2].setText(String.valueOf(results.numberOfComparisons));

				results.reset();
				SelectionSort.doSelectionSort(ascendingNumbers, results);
				jtfTime[6].setText(String.valueOf(results.time) + " ms ");
				jtfNoSwaps[6].setText(String.valueOf(results.numberOfSwaps));
				jtfNoComprasions[6].setText(String.valueOf(results.numberOfComparisons));

				results.reset();
				SelectionSort.doSelectionSort(descendingNumbers, results);
				jtfTime[10].setText(String.valueOf(results.time) + " ms ");
				jtfNoSwaps[10].setText(String.valueOf(results.numberOfSwaps));
				jtfNoComprasions[10].setText(String.valueOf(results.numberOfComparisons));
				break;
			case "Insertion":
				
				results.reset();
				InsertionSort.doInsertionSort(randomNumbers, results);
				jtfTime[3].setText(String.valueOf(results.time) + " ms ");
				jtfNoSwaps[3].setText(String.valueOf(results.numberOfSwaps));
				jtfNoComprasions[3].setText(String.valueOf(results.numberOfComparisons));

				results.reset();
				InsertionSort.doInsertionSort(ascendingNumbers, results);
				jtfTime[7].setText(String.valueOf(results.time) + " ms ");
				jtfNoSwaps[7].setText(String.valueOf(results.numberOfSwaps));
				jtfNoComprasions[7].setText(String.valueOf(results.numberOfComparisons));

				results.reset();
				InsertionSort.doInsertionSort(descendingNumbers, results);
				jtfTime[11].setText(String.valueOf(results.time) + " ms ");
				jtfNoSwaps[11].setText(String.valueOf(results.numberOfSwaps));
				jtfNoComprasions[11].setText(String.valueOf(results.numberOfComparisons));
				break;
			}

		}
	}
}
