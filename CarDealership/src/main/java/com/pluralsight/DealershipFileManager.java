package com.pluralsight;

import java.io.*;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class DealershipFileManager {

    // creating the file path for loading and reading data
    private static final String filePath = "src/main/resources/inventory.csv";

    // creating getDealership method
    public Dealership getDealership() {
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));

            if (lines.isEmpty()) return null;

            // parse dealership info
            String[] dealershipInfo = lines.get(0).split("\\|");
            Dealership dealership = new Dealership(
                    dealershipInfo[0],
                    dealershipInfo[1],
                    dealershipInfo[2]
            );

            // parse vehicles
            for (int i = 1; i < lines.size(); i++) {
                String[] v = lines.get(i).split("\\|");
                dealership.addVehicle(new Vehicle(
                        Integer.parseInt(v[0]),
                        Integer.parseInt(v[1]),
                        v[2],
                        v[3],
                        v[4],
                        v[5],
                        Integer.parseInt(v[6]),
                        Double.parseDouble(v[7])
                ));
            }

            return dealership;

        } catch (Exception e) {
            System.out.println("Error loading dealership: " + e.getMessage());
            e.printStackTrace();
            return null;
        }


    }

    public void saveDealership(Dealership dealership) {
        // Overwrite file with current dealership info and vehicles
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            // Write dealership info
            writer.println(String.join("|",
                    dealership.getName(),
                    dealership.getAddress(),
                    dealership.getPhone()
            ));

            // Write each vehicle
            for (Vehicle v : dealership.getAllVehicles()) {
                writer.println(String.format("%d|%d|%s|%s|%s|%s|%d|%.2f",
                        v.getVin(),
                        v.getYear(),
                        v.getMake(),
                        v.getModel(),
                        v.getVehicleType(),
                        v.getColor(),
                        v.getOdometer(),
                        v.getPrice()
                ));
            }

        } catch (IOException e) {
            System.out.println("Error saving dealership: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
