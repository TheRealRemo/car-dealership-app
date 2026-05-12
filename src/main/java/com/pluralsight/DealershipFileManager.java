package com.pluralsight;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class DealershipFileManager {

    //Methods
    public Dealership getDealership() {
        Dealership dealership = null;

        try {
            File file = new File("dealership.csv");
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedReader br = new BufferedReader(new FileReader("dealership.csv"));
            //First read dealership line in .csv file and save data in constructor
            String dealershipLine = br.readLine();
            String[] dealershipPart = dealershipLine.split("\\|");
            dealership = new Dealership(dealershipPart[0], dealershipPart[1], dealershipPart[2]);
            String line;
            //After, read other lines and save them into vehicle objects
            while ((line = br.readLine()) != null) {
                if (line.isEmpty()) {
                    continue;
                }
                String[] vehiclePart = line.split("\\|");
                int vin = Integer.parseInt(vehiclePart[0]);
                int year = Integer.parseInt(vehiclePart[1]);
                String make = vehiclePart[2];
                String model = vehiclePart[3];
                String vehicleType = vehiclePart[4];
                String color = vehiclePart[5];
                int odometer = Integer.parseInt(vehiclePart[6]);
                double price = Double.parseDouble(vehiclePart[7]);

                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                dealership.addVehicle(vehicle);
            }
            br.close();
        } catch (IOException e) {
        }

        return dealership;
    }
}

