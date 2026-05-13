package com.pluralsight;

public class CarDealershipApp {
    public static void main(String[] args) {



    UserInterface userInterface = new UserInterface();
    DealershipFileManager dealershipFileManager = new DealershipFileManager();
    dealershipFileManager.getDealership();
    userInterface.display();











    }

}
