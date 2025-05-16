package com.pluralsight;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    private Dealership dealership;
    private Scanner theScanner;

    // creating constructor
    private UserInterface() {
        // initializing scanner to read user input
        this.theScanner = new Scanner(System.in);
    }

    private void init() {
        DealershipFileManager dfManager = new DealershipFileManager();
        dealership = dfManager.getDealership();
    }

    public void display() {
        // loads the dealership from file, calling init method
        init();
        boolean isRunning = true;
        while (isRunning) {
            // printing out menu
            System.out.println("⁺˚*•̩̩͙✩•̩̩͙*˚⁺‧͙⁺˚*•̩̩Dealership Menu: ͙*˚⁺‧͙⁺˚*•̩̩͙✩•̩̩͙*˚⁺‧͙  ");
            System.out.println("1 °∘\uD83D\uDCAE∘° Find vehicles within a price range");
            System.out.println("2 °∘\uD83D\uDCAE∘° Find vehicles by make / model");
            System.out.println("3 °∘\uD83D\uDCAE∘° Find vehicles by year range");
            System.out.println("4 °∘\uD83D\uDCAE∘° Find vehicles by color");
            System.out.println("5 °∘\uD83D\uDCAE∘° Find vehicles by mileage range");
            System.out.println("6 °∘\uD83D\uDCAE∘° Find vehicles by type (car, truck, SUV, van)";
            System.out.println("7 °∘\uD83D\uDCAE∘° List ALL vehicles");
            System.out.println("8 °∘\uD83D\uDCAE∘° Add a vehicle");
            System.out.println("9 °∘\uD83D\uDCAE∘° Remove a vehicle");
            System.out.println("99 °∘\uD83D\uDCAE∘° Quit");
            System.out.println("°∘\uD83D\uDCAE∘° Please enter number here: ");

            // reading user input
            int userChoice = theScanner.nextInt();
            theScanner.nextLine();

            // switch for menu
            switch (userChoice) {
                case 1:
                    processGetByPriceRequest();
                    break;
                case 2:
                    processGetByMakeModelRequest();
                    break;
                case 3:
                    processGetByYearRequest();
                    break;
                case 4:
                    processGetByColorRequest();
                    break;
                case 5:
                    processGetByMileageRequest();
                    break;
                case 6:
                    processGetByVehicleTypeRequest();
                    break;
                case 7:
                    processGetAllVehiclesRequest();
                    break;
                case 8:
                    processAddVehiclesRequest();
                    break;
                case 9:
                    processRemoveVehicleRequest();
                    break;
                case 99:
                    isRunning = false;
                    System.out.println("Leaving the system now. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid input, please try again.");
            }

        }

    }


    private void processGetByPriceRequest() {
        // request min & max price
        System.out.println("Please enter the minimum price: ");
        double minimumPrice = Double.parseDouble(theScanner.nextLine());
        System.out.println("Please enter the maximum price: ");
        double maximumPrice = Double.parseDouble(theScanner.nextLine());

        ArrayList<>

    }

    public void processGetByMakeModelRequest() {

    }

    public void processGetByYearRequest() {

    }

    public void processGetByColorRequest() {

    }

    public void processGetByMileageRequest() {

    }

    public void processGetByVehicleTypeRequest() {

    }

    public void processGetAllVehiclesRequest() {
        // getting full list of vehicles from dealership
        ArrayList<Vehicle> vehicles = dealership.getAllVehicles();
        // printing vehicle to app / console
        displayVehicles(vehicles);

    }

    public void processAddVehiclesRequest() {

    }

    public void processRemoveVehicleRequest() {

    }

    private void displayVehicles(ArrayList<Vehicle> vehicles) {
        // if there are not any vehicles, return to main menu
        if (vehicles == null || vehicles.isEmpty()) {
            System.out.println("No vehicles found, sorry!");
            return;
        }

        for (Vehicle vehicle : vehicles) {
            // prints out override toString in Vehicle class
            System.out.println(vehicles);
        }
    }


}
