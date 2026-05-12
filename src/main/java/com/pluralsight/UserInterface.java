package com.pluralsight;

import java.util.Comparator;
import java.util.Scanner;

public class UserInterface {
  private Dealership  dealership;
  private static void ledgerMenu(Scanner scanner) {

    boolean running = true;
    while (running) {
      //sort taking and comparing first date with safety net then
      // comparing time if multiple dates are on the same day
      System.out.println("Ledger");
      System.out.println("Choose an option:");
      System.out.println("A) All");
      System.out.println("D) Deposits");
      System.out.println("P) Payments");
      System.out.println("R) Reports");
      System.out.println("H) Home");

      String input = scanner.nextLine().trim();

      switch (input.toUpperCase()) {
        case "A" -> displayLedger();
        case "D" -> displayDeposits();
        case "P" -> displayPayments();
        case "R" -> reportsMenu(scanner);
        case "H" -> running = false;
        default -> System.out.println("Invalid option");
      }
    }
  }

}
