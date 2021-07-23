package com.softvision.programmingPractice.oopPractice.shapeExercise;

public class Square extends Shape {

    protected double side;

    public double getSide() {
        return side;
    }

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double area() {
        return side * side;
    }

    @Override
    public double perimeter() {
        return 4 * side;
    }
}
