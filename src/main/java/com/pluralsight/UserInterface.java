package com.pluralsight;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    private Scanner scanner = new Scanner(System.in);
    private DealershipFileManager dealershipFileManager = new DealershipFileManager();

    public UserInterface() {
    }

    private void init() {
        this.dealership = dealershipFileManager.getDealership();
    }

    public void display() {

        init();
        boolean running = true;

        while (running) {
            System.out.println("\n========================");
            System.out.println("Car Dealership Inventory");
            System.out.println("========================");
            System.out.println("Choose an option:");
            System.out.println("1) Search Vehicles By Price");
            System.out.println("2) Search Vehicles By Make & Model");
            System.out.println("3) Search Vehicles By Year");
            System.out.println("4) Search Vehicles By Color");
            System.out.println("5) Search Vehicles By Mileage");
            System.out.println("6) Search Vehicles By Vehicle Type");
            System.out.println("7) Show All Vehicles");
            System.out.println("8) Add Vehicle To Inventory");
            System.out.println("9) Remove Vehicle From Inventory");
            System.out.println("X) Exit");
            System.out.println("========================");
            System.out.print("Please enter here: ");
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("X")) {
                System.out.println("Goodbye!");
            }

            switch (input.toUpperCase()) {
                case "1" -> processGetByPriceRequest();
                case "2" -> processGetByMakeModelRequest();
                case "3" -> processGetByYearRequest();
                case "4" -> processGetByColorRequest();
                case "5" -> processGetByMileageRequest();
                case "6" -> processGetByVehicleTypeRequest();
                case "7" -> processGetAllVehiclesRequest();
                case "8" -> processAddVehicleRequest();
                case "9" -> processRemoveVehicleRequest();
                case "X" -> running = false;
                default -> System.out.println("Invalid option");
            }
        }
        scanner.close();
    }

    public void processGetByPriceRequest() {
        System.out.print("Please input minimum price: ");
        double minPrice = scanner.nextDouble();
        System.out.print("Please input maximum price: ");
        double maxPrice = scanner.nextDouble();
        scanner.nextLine();

        List<Vehicle> vehicles = dealership.getVehiclesByPrice(minPrice, maxPrice);
        displayVehicles(vehicles);
    }

    public void processGetByMakeModelRequest() {
        System.out.print("Please input make: ");
        String make = scanner.nextLine();
        System.out.print("Please input model: ");
        String model = scanner.nextLine();


        List<Vehicle> vehicles = dealership.getVehiclesByMakeModel(make, model);
        displayVehicles(vehicles);
    }

    public void processGetByYearRequest() {
        System.out.print("Please input minimum year: ");
        int minYear = scanner.nextInt();
        System.out.print("Please input maximum year: ");
        int maxYear = scanner.nextInt();
        scanner.nextLine();

        List<Vehicle> vehicles = dealership.getVehiclesByYear(minYear, maxYear);
        displayVehicles(vehicles);
    }

    public void processGetByColorRequest() {
        System.out.print("Please input color: ");
        String color = scanner.nextLine();


        List<Vehicle> vehicles = dealership.getVehiclesByColor(color);
        displayVehicles(vehicles);
    }

    public void processGetByMileageRequest() {
        System.out.print("Please input minimum mileage: ");
        int minMileage = scanner.nextInt();
        System.out.print("Please input maximum mileage: ");
        int maxMileage = scanner.nextInt();
        scanner.nextLine();

        List<Vehicle> vehicles = dealership.getVehiclesByMileage(minMileage, maxMileage);
        displayVehicles(vehicles);
    }

    public void processGetByVehicleTypeRequest() {
        System.out.print("Please input vehicle type: ");
        String vehicleType = scanner.nextLine();


        List<Vehicle> vehicles = dealership.getVehiclesByVehicleType(vehicleType);
        displayVehicles(vehicles);
    }

    public void processGetAllVehiclesRequest() {
        List<Vehicle> vehicles = dealership.getAllVehicles();
        displayVehicles(vehicles);

    }

    public void processAddVehicleRequest() {
        System.out.print("Please enter the vin of the new vehicle: ");
        int vin = scanner.nextInt();
        System.out.println("Please enter the year of the new vehicle: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Please enter the make of the new vehicle: ");
        String make = scanner.nextLine();
        System.out.println("Please enter the model of the new vehicle: ");
        String model = scanner.nextLine();
        System.out.println("Please enter the type of the new vehicle: ");
        String vehicleType = scanner.nextLine();
        System.out.println("Please enter the color of the new vehicle: ");
        String color = scanner.nextLine();
        System.out.println("Please enter the mileage of the new vehicle: ");
        int odometer = scanner.nextInt();
        System.out.println("Please enter the price of the new vehicle: ");
        double price = scanner.nextInt();
        scanner.nextLine();
        Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
        dealership.addVehicle(vehicle);
        dealershipFileManager.saveDealership(dealership);
        System.out.println(vehicle.getMake() + " " + vehicle.getModel() + " Added Successfully!");
    }

    public void processRemoveVehicleRequest() {
        List<Vehicle> vehicles = dealership.getAllVehicles();
        System.out.println("=============================================");
        displayVehicles(vehicles);
        System.out.println("=============================================");
        System.out.print("Enter VIN of vehicle you would like to remove: ");
        int vin = scanner.nextInt();
        scanner.nextLine();

        boolean found = false;
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVin() == vin) {
                dealership.removeVehicle(vehicle);
                dealershipFileManager.saveDealership(dealership);
                System.out.println(vehicle.getMake() + " " + vehicle.getModel() + " removed successfully!");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Vehicle not found.");
        }
    }

    private void displayVehicles(List<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }

}
