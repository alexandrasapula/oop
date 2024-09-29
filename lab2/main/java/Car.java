package main.java;

public abstract class Car
{
    protected String brand;
    protected String model;
    protected double cost;
    protected double fuelConsumption;
    protected int maxSpeed;

    public Car(String brand, String model, double cost, double fuelConsumption, int maxSpeed)
    {
        this.brand = brand;
        this.model = model;
        this.cost = Validator.validateCost(cost);
        this.fuelConsumption = Validator.validateFuelConsumption(fuelConsumption);
        this.maxSpeed = Validator.validateSpeed(maxSpeed);
    }

    public double getFuelConsumption()
    {
        return fuelConsumption;
    }

    public int getMaxSpeed()
    {
        return maxSpeed;
    }

    public double getCost()
    {
        return cost;
    }

    public abstract void displayInfo();
}
