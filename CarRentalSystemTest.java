public class CarRentalSystemTest {
    public static void main(String[] args) {
        testCarCreation();
        testCustomerCreation();
        testRentalAgency();
        System.out.println("All tests completed.");
    }

    static void testCarCreation() {
        Car testCar = new Car("Test Model", "Test Brand", 100.0);
        System.out.println("Car Creation Test:");
        System.out.println("Expected: Test Model, Test Brand, 100.0");
        System.out.println("Actual: " + testCar.model + ", " + testCar.brand + ", " + testCar.pricePerDay);
        System.out.println("Test " + (testCar.model.equals("Test Model") && 
                                      testCar.brand.equals("Test Brand") && 
                                      testCar.pricePerDay == 100.0 ? "passed" : "failed"));
        System.out.println();
    }

    static void testCustomerCreation() {
        Customer testCustomer = new Customer("John Doe", 30, "ABC123");
        System.out.println("Customer Creation Test:");
        System.out.println("Expected: John Doe, 30, ABC123");
        System.out.println("Actual: " + testCustomer.name + ", " + testCustomer.age + ", " + testCustomer.licenseNumber);
        System.out.println("Test " + (testCustomer.name.equals("John Doe") && 
                                      testCustomer.age == 30 && 
                                      testCustomer.licenseNumber.equals("ABC123") ? "passed" : "failed"));
        System.out.println();
    }

    static void testRentalAgency() {
        RentalAgency testAgency = new RentalAgency(2);
        Car car1 = new Car("Model1", "Brand1", 100.0);
        Car car2 = new Car("Model2", "Brand2", 150.0);
        Car car3 = new Car("Model3", "Brand3", 200.0);

        System.out.println("Rental Agency Test:");
        
        testAgency.addCar(car1);
        System.out.println("Added first car. Number of cars: " + testAgency.numberOfCars);
        System.out.println("Test " + (testAgency.numberOfCars == 1 ? "passed" : "failed"));

        testAgency.addCar(car2);
        System.out.println("Added second car. Number of cars: " + testAgency.numberOfCars);
        System.out.println("Test " + (testAgency.numberOfCars == 2 ? "passed" : "failed"));

        testAgency.addCar(car3);
        System.out.println("Tried to add third car. Number of cars: " + testAgency.numberOfCars);
        System.out.println("Test " + (testAgency.numberOfCars == 2 ? "passed" : "failed"));

        System.out.println("\nTesting displayAvailableCars method:");
        testAgency.displayAvailableCars();
    }
}
