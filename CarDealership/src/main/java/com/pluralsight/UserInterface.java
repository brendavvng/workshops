package com.pluralsight;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    private Dealership dealership;
    private Scanner theScanner;

    // creating constructor
    protected UserInterface() {
        // initializing scanner to read user input
        this.theScanner = new Scanner(System.in);
    }

    public void init() {
        DealershipFileManager dfManager = new DealershipFileManager();
        dealership = dfManager.getDealership();
    }

    public void display() {
        // loads the dealership from file, calling init method
        init();
        boolean isRunning = true;
        while (isRunning) {
            // ﾟ･:.｡:ﾟ･♡
            // printing out menu
            System.out.println("            ‧˚₊•┈┈┈┈┈Welcome!┈┈┈┈┈•‧₊˚⊹");
            System.out.println("⁺˚*•̩̩͙*˚⁺‧͙⁺˚*•̩̩Dealership Menu: ͙*˚⁺‧͙⁺˚*•̩̩͙*˚⁺‧͙  ");
            System.out.println("1.  °∘\uD83D\uDCAE∘° Find vehicles within a price range ﾟ･♡");
            System.out.println("2.  °∘\uD83D\uDCAE∘° Find vehicles by make / model ﾟ･♡");
            System.out.println("3.  °∘\uD83D\uDCAE∘° Find vehicles by year range ﾟ･♡");
            System.out.println("4.  °∘\uD83D\uDCAE∘° Find vehicles by color ﾟ･♡");
            System.out.println("5.  °∘\uD83D\uDCAE∘° Find vehicles by mileage range ﾟ･♡");
            System.out.println("6.  °∘\uD83D\uDCAE∘° Find vehicles by type (car, truck, SUV, van) ﾟ･♡");
            System.out.println("7.  °∘\uD83D\uDCAE∘° List ALL vehicles ﾟ･♡");
            System.out.println("8.  °∘\uD83D\uDCAE∘° Add a vehicle ﾟ･♡");
            System.out.println("9.  °∘\uD83D\uDCAE∘° Remove a vehicle ﾟ･♡");
            System.out.println("99. °∘\uD83D\uDCAE∘° Quit ﾟ･♡");
            System.out.print("°∘\uD83D\uDCAE∘° Please enter number here: ");

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
                    System.out.println("˚₊ ˚ ‧₊ .:･˚₊ ˚ ‧₊ .:･˚₊ *˚˚₊ ˚˚ ‧₊");
                    System.out.println("╭───────── · · ୨୧ · · ─────────╮");
                    System.out.println("Leaving the system now. Goodbye!");
                    System.out.println("╰───────── · · ୨୧ · · ─────────╯");
                    System.out.println("˚₊ ˚ ‧₊ .:･˚₊ ˚ ‧₊ .:･˚₊ *˚˚₊ ˚˚ ‧₊");
                    break;
                default:
                    System.out.println("Invalid input, please try again.");
            }

        }

    }

    private void processGetByPriceRequest() {
        // request user for min & max price
        System.out.println("Please enter the minimum price: ");
        double minimumPrice = Double.parseDouble(theScanner.nextLine());
        System.out.println("Please enter the maximum price: ");
        double maximumPrice = Double.parseDouble(theScanner.nextLine());

        // calling dealership method
        ArrayList<Vehicle> matchingVehicles = dealership.getVehiclesByPrice(minimumPrice, maximumPrice);
        // displaying the matching vehicles
        displayVehicles(matchingVehicles);

    }

    public void processGetByMakeModelRequest() {
        // ask user for make of vehicle
        System.out.println("Enter vehicle make: " );
        // storing the input
        String make = theScanner.nextLine();

        // ask user for model of vehicle
        System.out.println("Enter vehicle model: ");
        // storing the input
        String model = theScanner.nextLine();

        // call Dealership methods for make & model
        ArrayList<Vehicle> matches = dealership.getVehiclesByMakeModel(make, model);
        // displaying results / matched vehicles
        displayVehicles(matches);
    }


    public void processGetByYearRequest() {
        // asking user for minimum year
        System.out.println("Enter minimum year: ");
        // parsing to have string turn into int
        int minimumYear = Integer.parseInt(theScanner.nextLine());

        System.out.println("Enter maximum year: ");
        int maximumYear = Integer.parseInt(theScanner.nextLine());

        ArrayList<Vehicle> matches = dealership.getVehiclesByYear(minimumYear, maximumYear);
        displayVehicles(matches);

    }

    public void processGetByColorRequest() {
        System.out.println("Enter Color: ");
        String color = theScanner.nextLine();

        ArrayList<Vehicle> matches = dealership.getVehiclesByColor(color);
        displayVehicles(matches);

    }

    // min and max for mileage
    public void processGetByMileageRequest() {
        System.out.println("Enter minimum mileage: ");
        int minimumMileage = Integer.parseInt(theScanner.nextLine());

        System.out.println("Enter maximum mileage: ");
        int maximumMileage = Integer.parseInt(theScanner.nextLine());

        ArrayList<Vehicle> matches = dealership.getVehiclesByMileage(minimumMileage, maximumMileage);
        displayVehicles(matches);
    }

    public void processGetByVehicleTypeRequest() {
        System.out.println("Enter type of vehicle (car, truck, SUV, van): ");
        String type = theScanner.nextLine();

        ArrayList<Vehicle> matches = dealership.getVehiclesByType(type);
        displayVehicles(matches);
    }

    public void processGetAllVehiclesRequest() {
        // getting full list of vehicles from dealership
        ArrayList<Vehicle> vehicles = dealership.getAllVehicles();
        // printing vehicle to app / console
        displayVehicles(vehicles);

    }

    public void processAddVehiclesRequest() {
        System.out.println(" °∘\uD83D\uDCAE∘° Enter VIN: ");
        int vin = Integer.parseInt(theScanner.nextLine());

        System.out.println(" °∘\uD83D\uDCAE∘° Enter Year: ");
        int year = Integer.parseInt(theScanner.nextLine());

        System.out.println(" °∘\uD83D\uDCAE∘° Enter Make: ");
        String make = theScanner.nextLine();

        System.out.println(" °∘\uD83D\uDCAE∘° Enter Model: ");
        String model = theScanner.nextLine();

        System.out.println(" °∘\uD83D\uDCAE∘° Enter Type: ");
        String type = theScanner.nextLine();

        System.out.println(" °∘\uD83D\uDCAE∘° Enter Color: ");
        String color = theScanner.nextLine();

        System.out.println(" °∘\uD83D\uDCAE∘° Enter Odometer: ");
        int odometer = Integer.parseInt(theScanner.nextLine());

        System.out.println(" °∘\uD83D\uDCAE∘° Enter Price: ");
        double price = Double.parseDouble(theScanner.nextLine());

        // creating and adding vehicle
        Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);
        dealership.addVehicle(vehicle);
        DealershipFileManager dfManager = new DealershipFileManager();
        dfManager.saveDealership(dealership);
        System.out.println(" °∘\uD83D\uDCAE∘° Vehicle added. ");

    }

    public void processRemoveVehicleRequest() {
        System.out.println("Enter VIN number to remove vehicle: ");
        int vin = Integer.parseInt(theScanner.nextLine());

        dealership.removeVehicle(vin);
        DealershipFileManager dfManager = new DealershipFileManager();
        dfManager.saveDealership(dealership);
        System.out.println("Vehicle has been removed.");

    }

    private void displayVehicles(ArrayList<Vehicle> vehicles) {
        // if there are not any vehicles, return to main menu
        if (vehicles == null || vehicles.isEmpty()) {
            System.out.println("No vehicles found, sorry!");
            return;
        }

        for (Vehicle vehicle : vehicles) {
            // prints out override toString method in Vehicle class
            System.out.println(vehicle);
        }
    }


}
