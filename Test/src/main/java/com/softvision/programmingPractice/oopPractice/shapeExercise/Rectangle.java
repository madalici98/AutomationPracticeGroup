package com.softvision.programmingPractice.oopPractice.shapeExercise;

public class Rectangle extends Shape{

    private double length, width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        return length * width;
    }

    @Override
    public double perimeter() {
        return 2 * length + 2 * width;
    }
}
