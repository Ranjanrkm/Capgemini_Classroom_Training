import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

// 1. Interface
interface Rentable {
    double calculateRent(int days);

    boolean isAvailable();
}

// 2. Abstract Vehicle class
public abstract class Vehicle implements Rentable {
    private String id;
    private String model;
    private double dailyRate;
    private boolean available;

    public Vehicle(String id, String model, double dailyRate) {
        this.id = id;
        this.model = model;
        this.dailyRate = dailyRate;
        this.available = true;
    }

    public String getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    @Override
    public boolean isAvailable() {
        return available;
    }

    public void markRented() {
        available = false;
    }

    public void markAvailable() {
        available = true;
    }

    public abstract String getType();

    @Override
    public String toString() {
        return getType() + " " + model + " (" + id + ")";
    }

    // MAIN METHOD: Run Vehicle.java directly
    public static void main(String[] args) {
        RentalShop shop = new RentalShop();

        // Add vehicles to the fleet
        shop.addVehicle(new Car("C1", "Swift", 2000));
        shop.addVehicle(new Bike("B1", "Activa", 400));
        shop.addVehicle(new Truck("T1", "Tata Ace", 2500));

        // Create customers
        Customer asha = new Customer("Asha");
        Customer ravi = new Customer("Ravi");

        // Rent vehicles and handle errors
        try {
            shop.rent("B1", asha, 8);
            shop.rent("T1", ravi, 2);

            try {
                shop.rent("B1", ravi, 2);
            } catch (RentalException e) {
                System.out.println("Error: " + e.getMessage());
            }

            // Return the bike
            shop.giveBack("B1");

            // Display available vehicles
            shop.showAvailable();

        } catch (RentalException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

// 3. Car class
class Car extends Vehicle {

    public Car(String id, String model, double dailyRate) {
        super(id, model, dailyRate);
    }

    @Override
    public double calculateRent(int days) {
        return getDailyRate() * days;
    }

    @Override
    public String getType() {
        return "Car";
    }
}

// 4. Bike class
class Bike extends Vehicle {

    public Bike(String id, String model, double dailyRate) {
        super(id, model, dailyRate);
    }

    @Override
    public double calculateRent(int days) {
        double rent = getDailyRate() * days;

        if (days >= 7) {
            rent = rent * 0.90;
        }

        return rent;
    }

    @Override
    public String getType() {
        return "Bike";
    }
}

// 5. Truck class
class Truck extends Vehicle {

    public Truck(String id, String model, double dailyRate) {
        super(id, model, dailyRate);
    }

    @Override
    public double calculateRent(int days) {
        return getDailyRate() * days + 500;
    }

    @Override
    public String getType() {
        return "Truck";
    }
}

// 6. Customer class
class Customer {
    private String name;
    private List<Rental> rentalHistory;

    public Customer(String name) {
        this.name = name;
        this.rentalHistory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addRental(Rental rental) {
        rentalHistory.add(rental);
    }

    public List<Rental> getRentalHistory() {
        return new ArrayList<>(rentalHistory);
    }
}

// 7. Rental class
class Rental {
    private Vehicle vehicle;
    private Customer customer;
    private int days;

    public Rental(Vehicle vehicle, Customer customer, int days) {
        this.vehicle = vehicle;
        this.customer = customer;
        this.days = days;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getDays() {
        return days;
    }

    public double getTotalRent() {
        return vehicle.calculateRent(days);
    }
}

// 8. Custom exception
class RentalException extends Exception {

    public RentalException(String message) {
        super(message);
    }
}

// 9. RentalShop class
class RentalShop {
    private List<Vehicle> fleet = new ArrayList<>();

    public void addVehicle(Vehicle vehicle) {
        fleet.add(vehicle);
    }

    private Vehicle findVehicle(String vehicleId)
            throws RentalException {

        for (Vehicle vehicle : fleet) {
            if (vehicle.getId().equals(vehicleId)) {
                return vehicle;
            }
        }

        throw new RentalException(
            "Vehicle with ID " + vehicleId + " not found"
        );
    }

    // Rent a vehicle
    public Rental rent(
            String vehicleId,
            Customer customer,
            int days
    ) throws RentalException {

        if (days <= 0) {
            throw new RentalException(
                "Rental days must be greater than zero"
            );
        }

        Vehicle vehicle = findVehicle(vehicleId);

        if (!vehicle.isAvailable()) {
            throw new RentalException(
                vehicle + " is already rented"
            );
        }

        Rental rental = new Rental(vehicle, customer, days);

        vehicle.markRented();
        customer.addRental(rental);

        System.out.printf(
            Locale.US,
            "%s rented %s for %d days = %.2f%n",
            customer.getName(),
            vehicle,
            days,
            rental.getTotalRent()
        );

        return rental;
    }

    // Return a vehicle
    public void giveBack(String vehicleId)
            throws RentalException {

        Vehicle vehicle = findVehicle(vehicleId);

        if (vehicle.isAvailable()) {
            throw new RentalException(
                vehicle + " is not currently rented"
            );
        }

        vehicle.markAvailable();
    }

    // Display all available vehicles
    public void showAvailable() {
        System.out.println("Available vehicles:");

        for (Vehicle vehicle : fleet) {
            if (vehicle.isAvailable()) {
                System.out.println("  " + vehicle);
            }
        }
    }
}