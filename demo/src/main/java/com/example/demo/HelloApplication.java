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

import com.example.gauss.*;

public class HelloApplication extends Application {
    Label result;

    private static final int DEFAULT_EQUATIONS_NUMBER = 3;
    private static final int DEFAULT_VARIABLES_NUMBER = 3;

    @Override
    public void start(Stage stage) {
        GridPane form = EnterForm.enterFrom();

        Button solveButton = new Button("Расчитать");
        Button resetButton = new Button("Очистить поля");
        Button exitButton = new Button("Завершение программы");

        solveButton.setMaxSize(100, 30);
        solveButton.setFont(Font.font("Tahoma", FontWeight.NORMAL, 16));
        solveButton.setOnAction(event -> solveEquation());

//        resetButton.setMaxSize(100, 30);
//        resetButton.setFont(Font.font("Tahoma", FontWeight.NORMAL, 16));
////        resetButton.setOnAction(event ->); тут реализовать функцию очистки полей
//
//        exitButton.setMaxSize(100, 30);
//        exitButton.setFont(Font.font("Tahoma", FontWeight.NORMAL, 16));
//        exitButton.setOnAction(event -> System.exit(0));

        result = BottomPanel.createBottomPanel();

        VBox box = new VBox(form, solveButton, result);
        box.setSpacing(20);
        box.setAlignment(Pos.CENTER);

        Scene scene = new Scene(box, 550, 400);

        stage.setTitle("Gauss calculator");
        stage.setScene(scene);
        stage.show();
    }

    public void solveEquation() {
        LinearSystem<Float, MyEquation> list = addSystem();
        Algorithm<Float, MyEquation> alg = new Algorithm<>(list);
        int i, j;

        try {
            alg.calculate();
        } catch (NullPointerException | ArithmeticException e) {
            result.setText(e.getMessage());
        }

        Float[] x = new Float[DEFAULT_EQUATIONS_NUMBER];

        for (i = list.size() - 1; i >= 0; i--) {
            Float sum = 0.0f;
            for (j = list.size() - 1; j > i; j--)
                sum += list.itemAt(i, j) * x[j];
            x[i] = (list.itemAt(i, list.size()) - sum) / list.itemAt(i, j);
        }

        String str = String.format("x1: %.3f; x2: %.3f; x3: %.3f;", x[0], x[1], x[2]);
        result.setText(str);
        result.setVisible(true);
    }

    public static LinearSystem<Float, MyEquation> addSystem() {
        LinearSystem<Float, MyEquation> list = new LinearSystem<>();

        for (int i = 0; i < DEFAULT_EQUATIONS_NUMBER; i++) {
            MyEquation myEq = new MyEquation();
            TextField[][] af = EnterForm.getAllFields();
            myEq.addDataToMyEquation(DEFAULT_VARIABLES_NUMBER + 1, af);
            list.push(myEq);
        }
        return list;
    }


    public static void main(String[] args) {
        launch();
    }
}