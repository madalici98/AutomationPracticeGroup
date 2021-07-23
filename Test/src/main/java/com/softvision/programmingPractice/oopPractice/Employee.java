package com.softvision.programmingPractice.oopPractice;

public class Employee {

    private String firstName;
    private String lastName;
    private double monthlySalary;

    public Employee(String firstName, String lastName, double monthlySalary) {

        this.firstName = firstName;
        this.lastName = lastName;

        if (monthlySalary < 0) {
            this.monthlySalary = 0.0;
        } else {
            this.monthlySalary = monthlySalary;
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public double getYearlySalary() {
        return this.monthlySalary * 12;
    }

    public void applyRaise(int raisePercent) {

        if (raisePercent < 0) {
            System.out.println("Cannot apply a negative raise");
            return;
        }

        this.monthlySalary *= (1.0 + (raisePercent / 100.0));
    }

    public void displayYearlySalary() {
        System.out.printf("Employee %s %s earns %f a year.\n", this. firstName, this.lastName, this.getYearlySalary());
    }
}
