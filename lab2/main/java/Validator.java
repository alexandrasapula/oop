package main.java;

public class Validator
{
    public static double validateCost(double cost)
    {
        if (cost <= 0) throw new IllegalArgumentException("Cost cannot be negative");
        return cost;
    }

    public static double validateFuelConsumption(double fuelConsumption)
    {
        if (fuelConsumption < 0) throw new IllegalArgumentException("Fuel consumption cannot be negative");
        return fuelConsumption;
    }

    public static int validateSpeed(int maxSpeed)
    {
        if (maxSpeed <= 0) throw new IllegalArgumentException("Max speed cannot be negative");
        return maxSpeed;
    }

    public static void validateSpeedRange(int minSpeed, int maxSpeed)
    {
        if (minSpeed < 0) throw new IllegalArgumentException("Minimum speed cannot be negative");
        if (minSpeed >= maxSpeed) throw new IllegalArgumentException("Minimum speed must be less than maximum speed");
    }
}
