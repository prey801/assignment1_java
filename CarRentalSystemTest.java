import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CarRentalSystemTest {

    private Car testCar;
    private Customer testCustomer;
    private RentalAgency testAgency;

    @BeforeEach
    void setUp() {
        testCar = new Car("Test Model", "Test Brand", 100.0);
        testCustomer = new Customer("John Doe", 30, "ABC123");
        testAgency = new RentalAgency(3);
    }

    @Test
    void testCarCreation() {
        assertEquals("Test Model", testCar.model);
        assertEquals("Test Brand", testCar.brand);
        assertEquals(100.0, testCar.pricePerDay);
    }

    @Test
    void testCustomerCreation() {
        assertEquals("John Doe", testCustomer.name);
        assertEquals(30, testCustomer.age);
        assertEquals("ABC123", testCustomer.licenseNumber);
    }

    @Test
    void testAddCar() {
        testAgency.addCar(testCar);
        assertEquals(1, testAgency.numberOfCars);
        assertEquals(testCar, testAgency.cars[0]);
    }

    @Test
    void testAddCarWhenFull() {
        for (int i = 0; i < 3; i++) {
            testAgency.addCar(new Car("Model" + i, "Brand" + i, 100.0));
        }
        Car extraCar = new Car("Extra", "Brand", 100.0);
        testAgency.addCar(extraCar);
        assertEquals(3, testAgency.numberOfCars);
    }

    @Test
    void testDisplayAvailableCars() {
        testAgency.addCar(testCar);
        
        assertDoesNotThrow(() -> testAgency.displayAvailableCars());
    }
}