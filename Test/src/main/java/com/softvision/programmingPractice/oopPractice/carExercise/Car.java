package com.softvision.programmingPractice.oopPractice.carExercise;

public class Car {

    private String model; // I assume this is the "name" specified in the exercise

    private int wheels;
    private int cylinders;
    private boolean engine;

    public Car(String model, int cylinders) {
        this.model = model;
        this.wheels = 4;
        this.cylinders = cylinders;
        this.engine = true;
    }

    public String getModel() {
        return model;
    }

    public int getWheels() {
        return wheels;
    }

    public int getCylinders() {
        return cylinders;
    }

    public boolean hasEngine() {
        return engine;
    }

    public void startEngine() {
        System.out.println("Starting engine...");
    }

    public void accelerate() {
        System.out.println("Accelerating...");
    }

    public void brake() {
        System.out.println("Braking...");
    }
}
