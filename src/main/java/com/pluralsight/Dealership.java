package com.pluralsight;

import java.util.ArrayList;

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

}
