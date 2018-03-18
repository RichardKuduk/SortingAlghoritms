package barCharts;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

// Richard Kuduk - L00120064
// Lyit - Assigment for Alghoritms and Data Structures
 
public class TimeBarChart10k extends Application {
    final static String bubbleSort = "Bubble Sort";
    final static String enhacedBubble = "Enhaced Bubble";
    final static String selection = "Selection Sort";
    final static String insertion = "Insertion Sort";


 
    @Override public void start(Stage stage) {
        stage.setTitle("Sorting Alghortims Comparision");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> bc = 
            new BarChart<String,Number>(xAxis,yAxis);
        bc.setTitle("10,000 Elements Arrays - Time Comparision");
        xAxis.setLabel("Sorting Alghoritm");       
        yAxis.setLabel("Time in miliseconds");
 
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Random");       
        series1.getData().add(new XYChart.Data(bubbleSort, 123));
        series1.getData().add(new XYChart.Data(enhacedBubble, 147));
        series1.getData().add(new XYChart.Data(selection, 31));
        series1.getData().add(new XYChart.Data(insertion, 38));

        
        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Sorted");
        series2.getData().add(new XYChart.Data(bubbleSort, 62));
        series2.getData().add(new XYChart.Data(enhacedBubble, 0));
        series2.getData().add(new XYChart.Data(selection, 38));
        series2.getData().add(new XYChart.Data(insertion, 0));

        
        XYChart.Series series3 = new XYChart.Series();
        series3.setName("Inverted");
        series3.getData().add(new XYChart.Data(bubbleSort, 101));
        series3.getData().add(new XYChart.Data(enhacedBubble, 100));
        series3.getData().add(new XYChart.Data(selection, 47));
        series3.getData().add(new XYChart.Data(insertion, 31));

       
        
        Scene scene  = new Scene(bc,800,600);
        bc.getData().addAll(series1, series2, series3 );
        stage.setScene(scene);
        stage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
}