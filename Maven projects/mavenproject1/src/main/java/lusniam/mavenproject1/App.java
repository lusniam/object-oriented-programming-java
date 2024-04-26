import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class App extends Application {

    private static final int NUM_THREADS = 5;
    private static final int NUM_EXECUTIONS = 3;

    private Pane drawingPane;
    private Button drawButton;
    private int linesWritten;

    @Override
    public void start(Stage primaryStage) {
        drawingPane = new Pane();
        drawButton = new Button("Rysuj");
        drawButton.setOnAction(e -> drawCircles());

        BorderPane root = new BorderPane();
        root.setCenter(drawingPane);
        root.setBottom(drawButton);

        Scene scene = new Scene(root, 400, 400);

        primaryStage.setTitle("Circle Drawing App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void drawCircles() {
        clearDrawingPane();
        linesWritten = 0;

        for (int i = 0; i < NUM_THREADS; i++) {
            int finalI = i;
            new Thread(() -> {
                for (int j = 0; j < NUM_EXECUTIONS; j++) {
                    Platform.runLater(() -> drawRandomCircle(finalI, j));
                    sleep(1000);
                    writeDataToFile(finalI, j);
                }
            }).start();
        }
    }

    private void drawRandomCircle(int threadNumber, int executionNumber) {
        double centerX = Math.random() * drawingPane.getWidth();
        double centerY = Math.random() * drawingPane.getHeight();
        double radius = Math.random() * 50 + 10; // Random radius between 10 and 60

        Circle circle = new Circle(centerX, centerY, radius);
        drawingPane.getChildren().add(circle);

        System.out.println("Thread " + threadNumber + ", Execution " + executionNumber +
                ": Center (" + centerX + ", " + centerY + "), Radius: " + radius);
    }

    private void writeDataToFile(int threadNumber, int executionNumber) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("circle_data.txt", true))) {
            String data = threadNumber + "," + executionNumber + "," +
                    Math.random() + "," + Math.random() + "," +
                    (Math.random() * 50 + 10) + "\n";
            writer.write(data);
            linesWritten++;
            updateStatus();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateStatus() {
        // You can display the number of lines written wherever you like in your GUI
        // For simplicity, we print it to the console here
        System.out.println("Lines written: " + linesWritten);
    }

    private void clearDrawingPane() {
        drawingPane.getChildren().clear();
    }

    private void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
