package com.softvision.programmingPractice.oopPractice.shapeExercise;

public class Triangle extends Shape {

    private double side1, side2, side3;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    // Heron's formula
    public double area() {

        double p = 0.5 * this.perimeter();

        return Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
    }

    @Override
    public double perimeter() {
        return side1 + side2 + side3;
    }

}
