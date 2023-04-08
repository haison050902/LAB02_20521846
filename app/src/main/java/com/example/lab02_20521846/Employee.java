package com.example.lab02_20521846;

public class Employee {
    private String fullName;
    private double salary;

    public Employee(String fullName, double salary) {
        this.fullName = fullName;
        this.salary = salary;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double calcSalary() {
        double a = this.getSalary() - (this.getSalary() * 0.105);
        double net = 0;
        double tax = 0;

        if (a < 11000000)
        {
            net = a;
        } else
        {
            tax = (a - 11000000) * 0.05;
            net = a - tax;
        }

        return net;
    }
}
