package main.java;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TaxiFleet
{
    private List<Car> fleet;

    public TaxiFleet()
    {
        this.fleet = new ArrayList<>();
    }

    public void addCar(Car car)
    {
        fleet.add(car);
    }
    public List<Car> getFleet()
    {
        // For tests
        return new ArrayList<>(fleet);
    }

    public double calculateTotalCost()
    {
        double totalCost = 0;
        for (Car car : fleet)
        {
            totalCost += car.getCost();
        }
        return totalCost;
    }

    public void sortByFuelConsumption()
    {
        fleet.sort(Comparator.comparingDouble(Car::getFuelConsumption));
    }

    public List<Car> findCarsBySpeedRange(int minSpeed, int maxSpeed)
    {
        List<Car> carsInRange = new ArrayList<>();
        for (Car car : fleet) {
            if (car.getMaxSpeed() >= minSpeed && car.getMaxSpeed() <= maxSpeed)
            {
                carsInRange.add(car);
            }
        }
        return carsInRange;
    }

    public void displayFleet()
    {
        for (Car car : fleet)
        {
            car.displayInfo();
        }
    }
}
