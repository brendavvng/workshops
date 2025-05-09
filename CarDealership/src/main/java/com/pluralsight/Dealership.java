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


    // get vehicles by price (min & max)
    public ArrayList<Vehicle> getVehiclesByPrice() {

    }

    // get vehicles by make & model
    public ArrayList<Vehicle> getVehiclesByMakeModel() {

    }

    // get vehicles by the year (min & max)
    public ArrayList<Vehicle> getVehiclesByYear() {

    }

    // get vehicles by color
    public ArrayList<Vehicle> getVehiclesByColor() {

    }


    // get vehicles by mileage (min & max)
    public ArrayList<Vehicle> getVehiclesByMileage() {

    }

    // car, truck, SUV, van
    public ArrayList<Vehicle> getVehiclesByType() {

    }

    // creating getter for getAllVehicles
    public ArrayList<Vehicle> getAllVehicles() {
        return inventory();
    }

    // creating addVehicle method, adds vehicle to list
    public void addVehicle() {

    }

    // removes vehicle
    public void removeVehicle() {

    }
}
