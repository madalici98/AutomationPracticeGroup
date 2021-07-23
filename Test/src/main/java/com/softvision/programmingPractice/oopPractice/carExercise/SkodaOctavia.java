package com.softvision.programmingPractice.oopPractice.carExercise;

public class SkodaOctavia extends Car {

    private int yearsVendorWarranty;

    public SkodaOctavia(String model, int cylinders, int yearsVendorWarranty) {
        super(model, cylinders);
        this.yearsVendorWarranty = yearsVendorWarranty;
    }

    @Override
    public void startEngine() {
        System.out.println("Starting engine of Skoda Octavia...");
    }

    @Override
    public void accelerate() {
        System.out.println("Accelerating Skoda Octavia...");
    }

    @Override
    public void brake() {
        System.out.println("Braking Skoda Octavia...");
    }
}
