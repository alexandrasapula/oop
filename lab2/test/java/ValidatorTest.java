package test.java;

import main.java.Validator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ValidatorTest {
    @Test
    public void testValidateCost() {
        assertEquals(100.0, Validator.validateCost(100.0));
        assertThrows(IllegalArgumentException.class, () -> Validator.validateCost(-1.0));
        assertThrows(IllegalArgumentException.class, () -> Validator.validateCost(0.0));
    }

    @Test
    public void testValidateFuelConsumption() {
        assertEquals(10.0, Validator.validateFuelConsumption(10.0));
        assertThrows(IllegalArgumentException.class, () -> Validator.validateFuelConsumption(-5.0));
    }

    @Test
    public void testValidateSpeed() {
        assertEquals(120, Validator.validateSpeed(120));
        assertThrows(IllegalArgumentException.class, () -> Validator.validateSpeed(-1));
        assertThrows(IllegalArgumentException.class, () -> Validator.validateSpeed(0));
    }

    @Test
    public void testValidateSpeedRange() {
        Validator.validateSpeedRange(20, 100);
        assertThrows(IllegalArgumentException.class, () -> Validator.validateSpeedRange(-10, 100));
        assertThrows(IllegalArgumentException.class, () -> Validator.validateSpeedRange(100, 100));
        assertThrows(IllegalArgumentException.class, () -> Validator.validateSpeedRange(150, 100));
    }
}
