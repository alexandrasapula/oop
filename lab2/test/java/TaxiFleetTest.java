package test.java;

import main.java.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaxiFleetTest {
    @Test
    void addCar_increasesFleetSize() {
        TaxiFleet fleet = new TaxiFleet();
        Car sedan = new Sedan("Toyota", "Camry", 25000, 7.5, 210);
        fleet.addCar(sedan);
        Assertions.assertEquals(1, fleet.getFleet().size());
    }

    @Test
    void calculateTotalCost_returnsCorrectValue() {
        TaxiFleet fleet = new TaxiFleet();
        fleet.addCar(new Sedan("Toyota", "Camry", 25000, 7.5, 210));
        fleet.addCar(new SUV("Ford", "Explorer", 35000, 12.0, 190));
        Assertions.assertEquals(60000, fleet.calculateTotalCost());
    }

    @Test
    void findCarsBySpeedRange_returnsCorrectCars() {
        TaxiFleet fleet = new TaxiFleet();
        fleet.addCar(new Sedan("Toyota", "Camry", 25000, 7.5, 210));
        fleet.addCar(new SUV("Ford", "Explorer", 35000, 12.0, 190));
        fleet.addCar(new Coupe("BMW", "M4", 70000, 10.0, 280));

        List<Car> foundCars = fleet.findCarsBySpeedRange(200, 250);
        assertEquals(1, foundCars.size());
    }
}

