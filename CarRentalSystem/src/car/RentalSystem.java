package car;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.List;

public class RentalSystem {
	private List<Car> cars;
    private List<Customer> customers;
    private List<Rent> rents;
    
	public RentalSystem(List<Car> cars, List<Customer> customers, List<Rent> rents) {
		this.cars = cars;
		this.customers = customers;
		this.rents = rents;
	}
    
	public void addCar(String carId, String brand, String model,int price, boolean isAvailable) {
        cars.add(new Car(carId, brand, model, price, isAvailable));
    }

    public void removeCar(String carId) {
        cars.removeIf(car -> car.getCarId().equals(carId));
    }

    public void addCustomer(String customerId, String name, String email) {
        customers.add(new Customer(customerId, name, email));
    }

    public void removeCustomer(String customerId) {
        customers.removeIf(customer -> customer.getCustomerId().equals(customerId));
    }

    public void rentCar(String carId, String customerId) {
        if (findCarById(carId) != null && findCustomerById(customerId) != null) {
            Car car = findCarById(carId);
            if (car.isAvailable()) {
                car.setAvailable(false);
                rents.add(new Rent(carId, customerId, LocalDate.now()));
                saveDataToFile("cars");
                saveDataToFile("rents");
            } else {
                System.out.println("Car is not available for rent.");
            }
        } else {
            System.out.println("Car or customer not found.");
        }
    }

    public void returnCar(String carId) {
        Car car = findCarById(carId);
        if (car != null) {
            Rent rent = findRentByCarId(carId);
            if (rent != null) {
                car.setAvailable(true);
                rents.remove(rent);
                saveDataToFile("cars");
                saveDataToFile("rents");
            } else {
                System.out.println("Car is not currently rented.");
            }
        } else {
            System.out.println("Car not found.");
        }
    }

    public void saveDataToFile(String dataName) {
        try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(dataName + ".txt"))) {
            switch (dataName) {
                case "cars":
                    stream.writeObject(cars);
                    break;
                case "customers":
                    stream.writeObject(customers);
                    break;
                case "rents":
                    stream.writeObject(rents);
                    break;
                default:
                    System.out.println("Invalid data type.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadDataFromFile(String dataName) {
        try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream(dataName + ".txt"))) {
            switch (dataName) {
                case "cars":
                    cars = (List<Car>) stream.readObject();
                    break;
                case "customers":
                    customers = (List<Customer>) stream.readObject();
                    break;
                case "rents":
                    rents = (List<Rent>) stream.readObject();
                    break;
                default:
                    System.out.println("Invalid data type.");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Car findCarById(String carId) {
        return cars.stream().filter(car -> car.getCarId().equals(carId)).findFirst().orElse(null);
    }

    private Customer findCustomerById(String customerId) {
        return customers.stream().filter(customer -> customer.getCustomerId().equals(customerId)).findFirst().orElse(null);
    }

    private Rent findRentByCarId(String carId) {
        return rents.stream().filter(rent -> rent.getCarId().equals(carId)).findFirst().orElse(null);
    }
}
