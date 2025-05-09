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

    // creating addVehicle method, adds vehicle to list
    public void addVehicle() {

    }

    // creating getter for getAllVehicles
    public ArrayList<Vehicle> getAllVehicles() {
        return inventory();
    }
}
