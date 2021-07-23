package com.softvision.programmingPractice.oopPractice.shapeExercise;

public class Hexagon extends Square{

    public Hexagon(double side) {
        super(side);
    }

    @Override
    public double area() {
        return (3 * Math.sqrt(3)) / 2 * side;
    }

    @Override
    public double perimeter() {
        return 6 * side;
    }
}
