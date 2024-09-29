package main.java;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        TaxiFleet fleet = new TaxiFleet();
        initializeFleet(fleet);
        displayFleetInfo(fleet);

        int minSpeed = 200;
        int maxSpeed = 250;
        findCarsInSpeedRange(fleet, minSpeed, maxSpeed);
    }

    private static void initializeFleet(TaxiFleet fleet) {
        fleet.addCar(new Sedan("Toyota", "Camry", 25000, 7.5, 210));
        fleet.addCar(new SUV("Ford", "Explorer", 35000, 12.0, 190));
        fleet.addCar(new Coupe("BMW", "M4", 70000, 10.0, 280));
        fleet.addCar(new Sedan("Honda", "Accord", 22000, 8.0, 220));
    }

    private static void displayFleetInfo(TaxiFleet fleet) {
        System.out.println("Fleet info:");
        fleet.displayFleet();
        System.out.println("\nTotal fleet cost: $" + fleet.calculateTotalCost());
        System.out.println("\nSorting cars by fuel consumption...");
        fleet.sortByFuelConsumption();
        fleet.displayFleet();
    }

    private static void findCarsInSpeedRange(TaxiFleet fleet, int minSpeed, int maxSpeed) {
        Validator.validateSpeedRange(minSpeed, maxSpeed);
        List<Car> foundCars = fleet.findCarsBySpeedRange(minSpeed, maxSpeed);
        if (!foundCars.isEmpty()) {
            System.out.println("\nCars found in speed range " + minSpeed + "-" + maxSpeed + " km/h:");
            foundCars.forEach(Car::displayInfo);
        } else {
            System.out.println("\nNo cars found in speed range " + minSpeed + "-" + maxSpeed + " km/h.");
        }
    }
}
