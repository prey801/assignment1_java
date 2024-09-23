import java.util.Scanner;

class Car {
    String model;
    String brand;
    double pricePerDay;

    public Car(String model, String brand, double pricePerDay) {
        this.model = model;
        this.brand = brand;
        this.pricePerDay = pricePerDay;
    }

    public void displayDetails() {
        System.out.println("Car Model: " + model);
        System.out.println("Brand: " + brand);
        System.out.println("Price per day: $" + pricePerDay);
    }
}

class Customer {
    String name;
    int age;
    String licenseNumber;

    public Customer(String name, int age, String licenseNumber) {
        this.name = name;
        this.age = age;
        this.licenseNumber = licenseNumber;
    }

    public void displayCustomerDetails() {
        System.out.println("Customer Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("License Number: " + licenseNumber);
    }
}

class RentalAgency {
    Car[] cars;
    int numberOfCars;

    public RentalAgency(int size) {
        cars = new Car[size];
        numberOfCars = 0;
    }

    public void addCar(Car car) {
        if (numberOfCars < cars.length) {
            cars[numberOfCars] = car;
            numberOfCars++;
        } else {
            System.out.println("No space to add more cars.");
        }
    }

    public void displayAvailableCars() {
        if (numberOfCars == 0) {
            System.out.println("No cars available.");
        } else {
            for (int i = 0; i < numberOfCars; i++) {
                System.out.println("Car " + (i + 1) + ":");
                cars[i].displayDetails();
                System.out.println();
            }
        }
    }
}

public class CarRentalSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Create RentalAgency
        RentalAgency agency = new RentalAgency(3);  // Maximum of 3 cars in the agency
        
        // Add some cars
        Car car1 = new Car("Model S", "Tesla", 200);
        Car car2 = new Car("Mustang", "Ford", 150);
        Car car3 = new Car("Civic", "Honda", 100);
        agency.addCar(car1);
        agency.addCar(car2);
        agency.addCar(car3);
        
        // Display available cars
        System.out.println("Available cars in the rental agency:");
        agency.displayAvailableCars();
        
        // Customer details input
        System.out.println("Enter customer details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("License Number: ");
        String licenseNumber = scanner.nextLine();
        
        Customer customer = new Customer(name, age, licenseNumber);
        System.out.println("Customer Details:");
        customer.displayCustomerDetails();
        
        // Car rental
        System.out.println("Choose a car by number (1-3): ");
        int carChoice = scanner.nextInt();
        if (carChoice >= 1 && carChoice <= 3) {
            System.out.println("You chose:");
            agency.cars[carChoice - 1].displayDetails();
            System.out.println("Thank you for renting!");
        } else {
            System.out.println("Sorry, that car is not available.");
        }
        
        scanner.close();
    }
}