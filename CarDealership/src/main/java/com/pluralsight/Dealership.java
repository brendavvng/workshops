package com.pluralsight;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Dealership {

    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    // creating constructors
    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        // instantiating ArrayList<Vehicle> object in constructor
        this.inventory = new ArrayList<Vehicle>();
    }

    // getters for properties
    public String getName() {
        return name;
    }

    public ArrayList<Vehicle> getInventory() {
        return inventory;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    // returns vehicles by price (min & max)
    public ArrayList<Vehicle> getVehiclesByPrice(double min, double max) {
        // creating a new array list to store vehicles that matches price range
        ArrayList<Vehicle> matches = new ArrayList<>();
        // looping through every vehicle in inventory
        for (Vehicle vehicle : inventory) {
            // checking if vehicles are within the price range, min and max
            if (vehicle.getPrice() >= min && vehicle.getPrice() <= max) {
                // if vehicle matches, add it to the list
                matches.add(vehicle);
            }
        }
        // returning list of matching vehicles
        return matches;
    }

    // returns vehicles by make & model
    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model) {
        // creating array list for the matching vehicles
        ArrayList<Vehicle> matches = new ArrayList<>();
        // looping through every vehicle in inventory
        for (Vehicle vehicle : inventory) {
            // checking if the make & model of vehicle match
            if (vehicle.getMake().equalsIgnoreCase(make) &&
                vehicle.getModel().equalsIgnoreCase(model)) {
                // if vehicle matches, add it to the list
                matches.add(vehicle);
            }
        }
        // returning list of matching vehicles
        return matches;
    }

    // returns vehicles by the year (min & max)
    public ArrayList<Vehicle> getVehiclesByYear(int min, int max) {
        ArrayList<Vehicle> matches = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            // checking the range for vehicle years
            if (vehicle.getYear() >= min && vehicle.getYear() <= max) {
                // if matches within range, add to list
                matches.add(vehicle);
            }
        }
        return matches;
    }

    // returns vehicles by color
    public ArrayList<Vehicle> getVehiclesByColor(String color) {
        ArrayList<Vehicle> matches = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            // if color matches w/ input color
            if (vehicle.getColor().equalsIgnoreCase(color)) {
                // if matches, add to list
                matches.add(vehicle);
            }
        }
        return matches;
    }


    // returns vehicles by mileage (min & max)
    public ArrayList<Vehicle> getVehiclesByMileage(int min, int max) {
        ArrayList<Vehicle> matches = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            // if the mileage range is within range
            if (vehicle.getOdometer() >= min && vehicle.getOdometer() <= max) {
                // if matches, add to list
                matches.add(vehicle);
            }
        }
        return matches;
    }

    // returns vehicles that match car, truck, SUV, van
    public ArrayList<Vehicle> getVehiclesByType(String type) {
        ArrayList<Vehicle> matches = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            // checking if vehicle type matches
            if (vehicle.getVehicleType().equalsIgnoreCase(type)) {
                // if matches, add to list
                matches.add(vehicle);
            }
        }
        return matches;
    }

    // creating getter for getAllVehicles
    // this returns entire list of vehicle inventory
    public ArrayList<Vehicle> getAllVehicles() {
        return inventory;
    }


    // creating addVehicle method, adds vehicle to list
    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    // removes vehicle
    public void removeVehicle(int vin) {
        // looping through inventory and find matching vin
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getVin() == vin) {
                inventory.remove(i);
                // stops after removing
                break;
            }

        }
    }
}
