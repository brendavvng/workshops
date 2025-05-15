package com.pluralsight;

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

    // get vehicles by price (min & max)
    public ArrayList<Vehicle> getVehiclesByPrice(double min, double max) {

    }

    // get vehicles by make & model
    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model) {

    }

    // get vehicles by the year (min & max)
    public ArrayList<Vehicle> getVehiclesByYear(int min, int max) {

    }

    // get vehicles by color
    public ArrayList<Vehicle> getVehiclesByColor(String color) {

    }


    // get vehicles by mileage (min & max)
    public ArrayList<Vehicle> getVehiclesByMileage(int min, int max) {

    }

    // car, truck, SUV, van
    public ArrayList<Vehicle> getVehiclesByType(String type) {

    }

    // creating getter for getAllVehicles
    public ArrayList<Vehicle> getAllVehicles() {
        return inventory();
    }

    private ArrayList<Vehicle> inventory() {
        return null;
    }

    // creating addVehicle method, adds vehicle to list
    public void addVehicle(Vehicle vehicle) {

    }

    // removes vehicle
    public void removeVehicle(int vin) {

    }
}
