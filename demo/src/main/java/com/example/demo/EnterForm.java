package com.example.demo;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class EnterForm {

    public static GridPane enterFrom() {
        GridPane form = new GridPane();
        form.setAlignment(Pos.CENTER);
        form.setPadding(new Insets(20));
        form.setVgap(10);
        form.setHgap(10);
        form.add(MyTextField.textField(),0,0);
        form.add(MyTextField.textField(),1,0);
        form.add(MyTextField.textField(),2,0);
        form.add(MyTextField.textField(),3,0);

        form.add(MyTextField.textField(),0,1);
        form.add(MyTextField.textField(),1,1);
        form.add(MyTextField.textField(),2,1);
        form.add(MyTextField.textField(),3,1);

        form.add(MyTextField.textField(),0,2);
        form.add(MyTextField.textField(),1,2);
        form.add(MyTextField.textField(),2,2);
        form.add(MyTextField.textField(),3,2);


        return form;
    }
}
