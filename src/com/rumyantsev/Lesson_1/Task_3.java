package com.rumyantsev.Lesson_1;

import java.util.Arrays;
import java.util.List;

//Написать пример кода, который реализует принцип полиморфизма, на примере фигур — круг, квадрат, треугольник
public class Main {
    public static void main(String[] args) {
        Square circle = new Circle(5);
        Square kvadrat = new Kvadrat(10);
        Square triangle = new Triangle(2,3);

        List<Square> figures = Arrays.asList(circle, kvadrat, triangle);
        for (Square f : figures) {
            System.out.println(f.getSquare());
        }

    }
}

interface Square {
    double getSquare();
}

class Circle implements Square {

    int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public double getSquare() {
        return 3.14 * radius * radius;
    }
}

class Kvadrat implements Square {

    int side;

    public Kvadrat(int side) {
        this.side = side;
    }

    @Override
    public double getSquare() {
        return side * side;
    }
}

class Triangle implements Square {

    int b;
    int h;

    public Triangle(int b, int h) {
        this.b = b;
        this.h = h;
    }

    @Override
    public double getSquare() {
        return b * h / 2.0;
    }
}
