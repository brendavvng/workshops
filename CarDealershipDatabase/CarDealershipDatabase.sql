# ---------------------------------------------------------------------- #
# Step 1: Creating Database                                              #
# ---------------------------------------------------------------------- #


DROP DATABASE IF EXISTS CarDealershipDataBase;
CREATE DATABASE CarDealershipDataBase;
USE CarDealershipDataBase;


# ---------------------------------------------------------------------- #
# Step 2: Creating Tables                                                #
# ---------------------------------------------------------------------- #

# ---------------------------------------------------------------------- #
# Table 1: dealerships                                                   #
# ---------------------------------------------------------------------- #

CREATE TABLE `dealerships` (
    `Dealership_id` INT AUTO_INCREMENT PRIMARY KEY,
    `Name` VARCHAR(50) NOT NULL,
    `Address` VARCHAR(50) NOT NULL,
    `Phone` VARCHAR(12) NOT NULL
);

# ---------------------------------------------------------------------- #
# Table 2: vehicles                                                      #
# ---------------------------------------------------------------------- #

CREATE TABLE `vehicles` (
    `VIN` VARCHAR(20) PRIMARY KEY,
    `Dealership_id` INT NOT NULL,
    `Price` DECIMAL(10,2) NOT NULL,
    `Make` VARCHAR(50) NOT NULL,
    `Model` VARCHAR(50) NOT NULL,
    `Year` YEAR NOT NULL,
    `Color` VARCHAR(30),
    `Mileage` INT NOT NULL,
    `Type` VARCHAR(50) NOT NULL,
    `Sold` BOOLEAN NOT NULL DEFAULT FALSE,
    CONSTRAINT `FK_Vehicles_Dealership` FOREIGN KEY (`Dealership_id`) REFERENCES dealerships(`Dealership_id`)
);

# ---------------------------------------------------------------------- #
# Table 3: inventory                                                     #
# ---------------------------------------------------------------------- #

CREATE TABLE `inventory` (
	`InventoryID` INT AUTO_INCREMENT PRIMARY KEY,
	`Dealership_id` INT NOT NULL,
    `VIN` VARCHAR(20) NOT NULL,
    CONSTRAINT `FK_Inventory_Dealerships` FOREIGN KEY (`Dealership_id`) REFERENCES dealerships(`Dealership_id`),
    CONSTRAINT `FK_Inventory_VIN` FOREIGN KEY (`VIN`) REFERENCES vehicles(`VIN`)
    );
    
# ---------------------------------------------------------------------- #
# Table 4: sales contracts                                               #
# ---------------------------------------------------------------------- #

CREATE TABLE `sales_contracts` (
	`SalesID` INT AUTO_INCREMENT PRIMARY KEY,
    `VIN` VARCHAR(20) NOT NULL,
    `Customer_Name` VARCHAR(100) NOT NULL,
    `Customer_Phone` VARCHAR(15),
    `Customer_Email` VARCHAR(100),
    `Sales_Date` DATE NOT NULL,
    `Sales_Price` DECIMAL(10,2) NOT NULL,
	`Fees` DECIMAL(10,2),
    `Financed` BOOLEAN DEFAULT FALSE,
    CONSTRAINT `FK_Sales_VIN` FOREIGN KEY (`VIN`) REFERENCES vehicles(`VIN`)
    );
    
# ---------------------------------------------------------------------- #
# Table 5: lease contracts                                               #
# ---------------------------------------------------------------------- #

CREATE TABLE `lease_contracts` (
	`LeaseID` INT AUTO_INCREMENT PRIMARY KEY,
    `VIN` VARCHAR(20) NOT NULL,
    `Customer_Name` VARCHAR(100) NOT NULL,
    `Customer_Phone` VARCHAR(15),
    `Customer_Email` VARCHAR(100),
    `Lease_Start_Date` DATE NOT NULL,
    `Lease_End_Date` DATE NOT NULL,
	`Monthly_Payment` DECIMAL (10,2) NOT NULL,
    CONSTRAINT `FK_Lease_VIN` FOREIGN KEY (`VIN`) REFERENCES vehicles(`VIN`)
    );