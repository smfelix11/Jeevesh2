package com.nissan.core_java.project;

public class Payment {

    private double flightPrice;
    //private double surge;
    private float tax;

    public double getFlightPrice() {
        return flightPrice;
    }

    public void setFlightPrice(double flightPrice) {
        this.flightPrice = flightPrice;
    }

    /*public double getSurge() {
        return surge;
    }

    public void setSurge(double surge) {
        this.surge = surge;
    }
*/
    public float gettax() {
        return tax;
    }

    public void settax(float tax) {
        this.tax = tax;
    }
}
