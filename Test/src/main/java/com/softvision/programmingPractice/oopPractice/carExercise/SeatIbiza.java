package com.softvision.programmingPractice.oopPractice.carExercise;

public class SeatIbiza extends Car {

    private boolean hasPremiumFurnishing;

    public SeatIbiza(String model, int cylinders, boolean hasPremiumFurnishing) {
        super(model, cylinders);
        this.hasPremiumFurnishing = hasPremiumFurnishing;
    }

    @Override
    public void startEngine() {
        System.out.println("Starting engine of Seat Ibiza...");
    }

    @Override
    public void accelerate() {
        System.out.println("Accelerating Seat Ibiza...");
    }

    @Override
    public void brake() {
        System.out.println("Braking Seat Ibiza...");
    }
}
