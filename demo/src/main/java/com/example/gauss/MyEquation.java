package com.example.gauss;

import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class MyEquation implements Gauss<Float, MyEquation> {
    private List<Float> equation = new ArrayList<>();

    public List<Float> getEquation() {
        return equation;
    }

    public void addDataToMyEquation(int size, TextField[][] af, int i) {
        this.equation.clear();
        for (int j = 0; j < size; j++) {
            this.equation.add(Float.parseFloat(af[i][j].getText()));
        }
    }

    @Override
    public int size() {
        return equation.size();
    }

    @Override
    public void addEquation(MyEquation item) {
        ListIterator<Float> i = equation.listIterator();
        ListIterator<Float> j = item.getEquation().listIterator();
        for (; i.hasNext() && j.hasNext(); ) {
            Float a = i.next();
            Float b = j.next();
            i.set(a + b);
        }
    }

    @Override
    public void mul(Float coefficient) {
        for (ListIterator<Float> i = equation.listIterator(); i.hasNext(); ) {
            Float next = i.next();
            i.set(next * coefficient);
        }
    }

    @Override
    public Float findCoefficient(Float a, Float b) {
        if (a == 0.0f) return 1.0f;
        return -b / a;
    }

    @Override
    public Float at(int index) {
        return equation.get(index);
    }
}
