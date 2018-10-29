package com.nissan.core_java.project;

import java.util.*;

public class BookingHistory 
{
	//Date bookingDate;
    Booking booking;
    Flight flight;
    Users user;

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }
}
