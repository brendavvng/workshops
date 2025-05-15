package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    private Dealership dealership;
    private Scanner theScanner;



    // creating constructor
    private UserInterface() {
        // initializing scanner to read user input
        Scanner theScanner = new Scanner(System.in);
    }


    private void init() {
        DealershipFileManager dfm = new DealershipFileManager();
        dealership = dfm.getDealership();
    }

    public void display() {
        // loads the dealership from file
        init();
    }


    private void processGetByPriceRequest() {

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

    }

    public void processAddVehiclesRequest() {

    }

    public void processRemoveVehicleRequest() {

    }

    private void displayVehicles(ArrayList<Vehicle> vehicles) {

    }


}
