package com.pluralsight;

public class SalesContract extends Contract {

    // instantiating variables
    private double salesTaxAmount;
    private int recordingFee;
    private int processingFee;
    private boolean financed;

    // constructors
    public SalesContract(String dateOfContract, String customerName, String customerEmail, Vehicle vehicleSold, double salesTaxAmount, int recordingFee, int processingFee, boolean financed) {
        // calling the parent class for constructor
        super(dateOfContract, customerName, customerEmail, vehicleSold);
        // 5% sales tax
        this.salesTaxAmount = vehicleSold.getPrice() * 0.05;
        // recording fee is $100
        this.recordingFee = 100;
        // processing fee based on the vehicle price
        this.processingFee = vehicleSold.getPrice() < 10000 ? 295 : 495;
        this.financed = financed;
    }

    // getters and setters
    public double getSalesTaxAmount() {
        return salesTaxAmount;
    }

    public void setSalesTaxAmount(double salesTaxAmount) {
        this.salesTaxAmount = salesTaxAmount;
    }

    public int getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(int processingFee) {
        this.processingFee = processingFee;
    }

    public boolean isFinanced() {
        return financed;
    }

    public void setFinanced(boolean financed) {
        this.financed = financed;
    }

    public int getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(int recordingFee) {
        this.recordingFee = recordingFee;
    }

    // overriding methods in contract class
    @Override
    public double getTotalPrice() {
        return getVehicleSold().getPrice() + salesTaxAmount + recordingFee + processingFee;
    }

    @Override
    public double getMonthlyPayment() {
        // if not financed, return 0
        if (!financed) {
            return 0;
        }

        double totalPrice = getTotalPrice();
        double rate;
        int months;

        //Processing fee ($295 for vehicles under $10,000 and $495 for all others
        if (getVehicleSold().getPrice() >= 10000) {
            // 4.25 annual rate
            rate = 0.0425;
            // loan term
            months = 48;
        } else {
            // 5.25 annual rate
            rate = 0.0525;
            // loan term
            months = 24;
        }
        // fixed interest rate
        double monthlyRate = rate / 12;
        // Calculates monthly payment using the loan amortization formula with interest
        // Formula: (P * r) / (1 - (1 + r)^-n), where P=price, r=monthly rate, n=months
        return (totalPrice * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -months));

    }
}
