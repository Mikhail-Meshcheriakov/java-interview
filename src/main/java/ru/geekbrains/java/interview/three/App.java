package ru.geekbrains.java.interview.three;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle());
        shapes.add(new Triangle());
        shapes.add(new Square());

        for (Shape shape : shapes) {
            shape.calculateArea();
        }
    }
}
