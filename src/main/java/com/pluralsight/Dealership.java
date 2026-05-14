package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    //Attributes
    private String name;
    private String address;
    private String phone;

    private ArrayList<Vehicle> inventory;

    //Constructor
    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    //Getters


    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    //Methods
    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        List<Vehicle> filteredList = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getPrice() >= min && vehicle.getPrice() <= max) {
                filteredList.add(vehicle);
            }
        }
        return filteredList;
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        List<Vehicle> filteredList = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)) {
                filteredList.add(vehicle);
            }
        }
        return filteredList;
    }


    public List<Vehicle> getVehiclesByYear(int min, int max) {
        List<Vehicle> filteredList = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getYear() >= min && vehicle.getYear() <= max) {
                filteredList.add(vehicle);
            }
        }
        return filteredList;
    }

    public List<Vehicle> getVehiclesByColor(String color) {
        List<Vehicle> filteredList = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getColor().equalsIgnoreCase(color)) {
                filteredList.add(vehicle);
            }
        }
        return filteredList;
    }

    public List<Vehicle> getVehiclesByMileage(int min, int max) {
        List<Vehicle> filteredList = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getOdometer() >= min && vehicle.getOdometer() <= max) {
                filteredList.add(vehicle);
            }
        }
        return filteredList;
    }

    public List<Vehicle> getVehiclesByVehicleType(String vehicleType) {
        List<Vehicle> filteredList = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getVehicleType().equalsIgnoreCase(vehicleType)) {
                filteredList.add(vehicle);
            }
        }
        return filteredList;
    }

    public List<Vehicle> getAllVehicles() {
        return inventory;
    }

    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {

    }
}
