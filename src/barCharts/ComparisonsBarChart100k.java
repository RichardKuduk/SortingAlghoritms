package barCharts;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

//Richard Kuduk - L00120064
//Lyit - Assigment for Alghoritms and Data Structures

public class ComparisonsBarChart100k extends Application {
	final static String bubbleSort = "Bubble Sort";
	final static String enhacedBubble = "Enhaced Bubble";
	final static String selection = "Selection Sort";
	final static String insertion = "Insertion Sort";

	@Override
	public void start(Stage stage) {
		stage.setTitle("Sorting Alghortims Comparision");
		final CategoryAxis xAxis = new CategoryAxis();
		final NumberAxis yAxis = new NumberAxis();
		final BarChart<String, Number> bc = new BarChart<String, Number>(xAxis, yAxis);
		bc.setTitle("100,000 Elements Arrays - Comparisions of Elements");
		xAxis.setLabel("Sorting Alghoritm");
		yAxis.setLabel("Comparisons");

		XYChart.Series series1 = new XYChart.Series();
		series1.setName("Random");
		series1.getData().add(new XYChart.Data(bubbleSort, 9999800001L));
		series1.getData().add(new XYChart.Data(enhacedBubble, 9899301006L));
		series1.getData().add(new XYChart.Data(selection, 4999950000L));
		series1.getData().add(new XYChart.Data(insertion, 2465937221L));

		XYChart.Series series2 = new XYChart.Series();
		series2.setName("Sorted");
		series2.getData().add(new XYChart.Data(bubbleSort, 9999800001L));
		series2.getData().add(new XYChart.Data(enhacedBubble, 99999));
		series2.getData().add(new XYChart.Data(selection, 4999950000L));
		series2.getData().add(new XYChart.Data(insertion, 99999));

		XYChart.Series series3 = new XYChart.Series();
		series3.setName("Inverted");
		series3.getData().add(new XYChart.Data(bubbleSort, 9999800001L));
		series3.getData().add(new XYChart.Data(enhacedBubble, 9999800001L));
		series3.getData().add(new XYChart.Data(selection, 4999950000L));
		series3.getData().add(new XYChart.Data(insertion, 5000049999L));

		Scene scene = new Scene(bc, 800, 600);
		bc.getData().addAll(series1, series2, series3);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}