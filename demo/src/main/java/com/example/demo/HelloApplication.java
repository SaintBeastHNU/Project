package com.example.demo;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    Label result;
    @Override
    public void start(Stage stage) throws IOException {
        GridPane form = EnterForm.enterFrom();

        Button solveButton = new Button("Расчитать");
        //solve.setPadding(new Insets(0,0,10,0));
        solveButton.setMaxSize(100,30);
        solveButton.setFont(Font.font("Tahoma", FontWeight.NORMAL, 16));
        solveButton.setOnAction(event -> solveEquation());

        result = BottomPanel.createBottomPanel();

        VBox box = new VBox(form, solveButton, result);
        box.setSpacing(20);
        box.setAlignment(Pos.CENTER);
        //box.setBackground(new Background(new BackgroundFill(Color.CHOCOLATE, CornerRadii.EMPTY, Insets.EMPTY)));

        Scene scene = new Scene(box, 550, 400);

        stage.setTitle("Gauss calculator");
        stage.setScene(scene);
        stage.show();
    }

    public void solveEquation() {
        double matrix[][] = new double[3][4];
        //Запись во временный массив все элементы TextField
        TextField[][] af = EnterForm.getAllFields();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                //Получить текст из TextField[i][j]
                matrix[i][j] = Double.parseDouble(af[i][j].getText());
            }
        }

        int n = matrix.length;
        for (int k = 0; k < n; k++) {
            int max = k;
            for (int i = k + 1; i < n; i++) {
                if (Math.abs(matrix[i][k]) > Math.abs(matrix[max][k])) {
                    max = i;
                }
            }
            double[] temp = matrix[k];
            matrix[k] = matrix[max];
            matrix[max] = temp;

            for (int i = k + 1; i < n; i++) {
                double factor = matrix[i][k] / matrix[k][k];
                for (int j = k + 1; j < n + 1; j++) {
                    matrix[i][j] -= factor * matrix[k][j];
                }
            }
        }

        // Обратный ход метода Гаусса
        double[] solution = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < n; j++) {
                sum += matrix[i][j] * solution[j];
            }
            solution[i] = (matrix[i][n] - sum) / matrix[i][i];
        }

        String str = String.format("x1: %.3f; x2: %.3f; x3: %.3f;", solution[0], solution[1], solution[2]);
        result.setText(str);
        result.setVisible(true);
    }

    public static void main(String[] args) {
        launch();
    }
}