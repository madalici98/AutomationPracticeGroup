package com.softvision.programmingPractice.oopPractice.shapeExercise;

public class Circle extends Shape{

    private double radix;
    private static double PI = 3.14;

    @Override
    public double area() {
        return PI * radix * radix;
    }

    @Override
    public double perimeter() {
        return 2 * PI * radix;
    }
}
