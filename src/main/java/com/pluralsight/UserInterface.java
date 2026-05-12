package com.pluralsight;

import java.util.Comparator;
import java.util.Scanner;

public class UserInterface {
  private Dealership dealership;

  public UserInterface() {
  }
  private void init(){
    DealershipFileManager dealershipFileManager = new DealershipFileManager();
     this.dealership = dealershipFileManager.getDealership();
  }
  public void display(){ Scanner scanner = new Scanner(System.in);

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
  public void processGetByPriceRequest(){}
  public void processGetByMakeModelRequest(){}
  public void processGetByYearRequest(){}
  public void processGetByColorRequest(){}
  public void processGetByMileageRequest(){}
  public void processGetByVehicleTypeRequest(){}
  public void processGetAllVehiclesRequest(){}
  public void processAddVehicleRequest(){}
  public void processRemoveVehicleRequest(){}


}
