package com.example.demo;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class BottomPanel {
    public static Label createBottomPanel() {

        Label res = new Label();
        res.setFont(Font.font("Tahoma", FontWeight.NORMAL, 16));
        res.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(10), Insets.EMPTY)));
        res.setBorder(new Border(new BorderStroke(Color.GREY, BorderStrokeStyle.SOLID, new CornerRadii(7), new BorderWidths(2))));
        res.setMaxSize(500,75);
        res.setPrefSize(500,75);
        res.setAlignment(Pos.CENTER);

        return res;
    }
}
