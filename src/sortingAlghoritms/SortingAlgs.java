package sortingAlghoritms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
	SorterObject results;

	public SortingAlgs() {
		topPanel = new JPanel();
		lblHeading = new JLabel("Select the number of elements: ");
		sizeList = new JComboBox<Integer>(size);
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
		// First columns labels
		String[] arrayNames = { "Random Sorted: ", "Sorted: ", "Inversely sorted: " };
		// Creating labels for first column
		for (int i = 0; i < 3; i++) {
			lblAlgName[i] = new JLabel(arrayNames[i]);
			lblTime[i] = new JLabel("Time elapsed: ");
			lblSwaps[i] = new JLabel("No. of swaps: ");
			lblComprasions[i] = new JLabel("No. comprasions: ");

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
			jtfTime[i] = new JTextField();
			jtfNoSwaps[i] = new JTextField();
			jtfNoComprasions[i] = new JTextField();

		}

		for (int i = 0; i < quadrats.length; i++) {
			quadrats[i] = new JPanel(new GridLayout(4, 1, 5, 5));
			quadrats[i].setBackground(new Color(i * 15, 155, 120));

			if (i % 5 == 0) {
				quadrats[i].add(lblAlgName[i / 5]);
				quadrats[i].add(lblTime[i / 5]);
				quadrats[i].add(lblSwaps[i / 5]);
				quadrats[i].add(lblComprasions[i / 5]);

			} else {
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
		String[] names = { "Reset", "Bubble", "Bubble Enhaced", "Selection", "Insertion" };
		for (Integer i = 0; i < 5; i++) {
			buttonPanel.add(temp = new JButton(names[i]));
			temp.addActionListener(this);
		}

		// add(leftPanel , BorderLayout.WEST);
		add(topPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);

		results = new SorterObject();
		populateArrays();

	}

	private void populateArrays() {
		// TODO Auto-generated method stub
		int n = (int) sizeList.getSelectedItem();
		randomNumbers = new int[n];
		ascendingNumbers = new int[n];
		descendingNumbers = new int[n];

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

		if (e.getSource() == sizeList) {
			populateArrays();
		}
		// TODO Auto-generated method stub
		else {
			String choice = ((JButton) e.getSource()).getText();

			switch (choice) {
			case "Bubble":
				
				results.reset();
				BubbleSortBasic.bubbleSortBasic(randomNumbers, results);
				jtfTime[0].setText(String.valueOf(results.time) + " ms ");
				jtfNoSwaps[0].setText(String.valueOf(results.numberOfSwaps));
				jtfNoComprasions[0].setText(String.valueOf(results.numberOfComparisons));

				results.reset();
				BubbleSortBasic.bubbleSortBasic(ascendingNumbers, results);
				jtfTime[4].setText(String.valueOf(results.time) + " ms ");
				jtfNoSwaps[4].setText(String.valueOf(results.numberOfSwaps));
				jtfNoComprasions[4].setText(String.valueOf(results.numberOfComparisons));

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
				SelectionSort.doInsertionSort(randomNumbers, results);
				jtfTime[2].setText(String.valueOf(results.time) + " ms ");
				jtfNoSwaps[2].setText(String.valueOf(results.numberOfSwaps));
				jtfNoComprasions[2].setText(String.valueOf(results.numberOfComparisons));

				results.reset();
				SelectionSort.doInsertionSort(ascendingNumbers, results);
				jtfTime[6].setText(String.valueOf(results.time) + " ms ");
				jtfNoSwaps[6].setText(String.valueOf(results.numberOfSwaps));
				jtfNoComprasions[6].setText(String.valueOf(results.numberOfComparisons));

				results.reset();
				SelectionSort.doInsertionSort(descendingNumbers, results);
				jtfTime[10].setText(String.valueOf(results.time) + " ms ");
				jtfNoSwaps[10].setText(String.valueOf(results.numberOfSwaps));
				jtfNoComprasions[10].setText(String.valueOf(results.numberOfComparisons));
				break;
			case "4":
				System.out.println("4");
				break;
			}

		}
	}
}
