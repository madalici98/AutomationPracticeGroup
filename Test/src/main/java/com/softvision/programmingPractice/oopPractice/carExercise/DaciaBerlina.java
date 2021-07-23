package com.softvision.programmingPractice.oopPractice.carExercise;

public class DaciaBerlina extends Car {

    private int numberOfIconsOnWindshield;
    private boolean canDoorsClose;

    public DaciaBerlina(String model, int cylinders, int numberOfIconsOnWindshield, boolean canDoorsClose) {
        super(model, cylinders);
        this.numberOfIconsOnWindshield = numberOfIconsOnWindshield;
        this.canDoorsClose = canDoorsClose;
    }

    @Override
    public void startEngine() {
        System.out.println("Starting engine of Dacia Berlina. Say 'Doamne Ajuta'...");
    }

    @Override
    public void accelerate() {
        System.out.println("Accelerating Dacia Berlina. The car started to make weird sounds...");
    }

    @Override
    public void brake() {
        System.out.println("Braking Dacia Berlina. Hope the brakes work...");
    }
}
