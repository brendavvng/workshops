package com.pluralsight;

public class LeaseContract extends Contract {

    private double expectedEndingValue;
    private double leaseFee;

    public LeaseContract(String dateOfContract, String customerName, String customerEmail, Vehicle vehicleSold, double leaseFee, double expectedEndingValue) {
        super(dateOfContract, customerName, customerEmail, vehicleSold);
        double price = vehicleSold.getPrice();
        this.leaseFee = price * 0.7;
        this.expectedEndingValue = price * 0.5;
    }

    // getters and setters
    public double getExpectedEndingValue() {
        return expectedEndingValue;
    }

    public void setExpectedEndingValue(double expectedEndingValue) {
        this.expectedEndingValue = expectedEndingValue;
    }

    public double getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }

    // overriding methods in contract class
    @Override
    public double getTotalPrice() {
        // total lease price = 50% of vehicle price + 7% lease fee
        return expectedEndingValue + leaseFee;
    }

    @Override
    public double getMonthlyPayment() {
        double totalPrice = getTotalPrice();
        // 4% interest, divided by monthly
        double rate = 0.04 / 12;
        int months = 36;

        return (totalPrice * rate) / (1 - Math.pow(1 - rate, -months));
    }

}
