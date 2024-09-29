package main.java;

public class Coupe extends Car
{
    public Coupe(String brand, String model, double cost, double fuelConsumption, int maxSpeed)
    {
        super(brand, model, cost, fuelConsumption, maxSpeed);
    }

    public void displayInfo()
    {
        System.out.println("[main.java.Coupe] Brand: " + brand + ", Model: " + model + ", Cost: $" + cost
                + ", Fuel Consumption: " + fuelConsumption + "L/100km, Max Speed: " + maxSpeed + " km/h");
    }
}
