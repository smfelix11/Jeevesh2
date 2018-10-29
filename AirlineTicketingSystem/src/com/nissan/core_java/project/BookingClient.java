package com.nissan.core_java.project;

import java.util.*;
import com.nissan.core_java.project.FlightService;

public class BookingClient 
{
    private List<Booking> tickets=new ArrayList<>();
    private List<BookingHistory> bookingHistoryList=new ArrayList<>();

    private Booking processBookingRequests(int numOfTickets, ArrayList<String> travellers, Users user,Flight flight)
    {
        Booking booking=new Booking(numOfTickets,travellers);
        Random rn = new Random();
        int range = (100000 - 1)+ 1;
        int randomNum =  rn.nextInt(range) + 1;
        booking.setTicketId(randomNum);
        booking.setUser(user);
        booking.setFlight(flight);

        tickets.add(booking);
        return booking;
    }

    public Booking getBookingFromTicket(int ticketId)
    {
        Booking booking=null;
        for(Booking b : tickets)
        {
            if(b.getTicketId()==ticketId)
            {
                booking=b;
            }
        }
        return booking;
    }



    public Booking bookTickets(Users user,Flight flight, int totalSeatsAvailable, int numOfTickets, ArrayList<String> custNames) {
        Booking booking=null;
        if (totalSeatsAvailable >= numOfTickets) 
        {
           booking= processBookingRequests(numOfTickets,custNames,user,flight);
            FlightService.updateFlightSeats(flight, numOfTickets);
        } else {
            System.out.println("Seats not available in the current flight\n\n");
        }
        
        return booking;
    }

    public List<Booking> getUserTickets()
    {
        return this.tickets;
    }

    public List<BookingHistory> getBookingHistory()
    {
        return this.bookingHistoryList;
    }
    
    private static void printTicketAllotment(final List<Booking> tickets) 
    {
        
        for (int i = 0; i < tickets.size(); i++) 
        {
            String ticketNumber = Integer.toString((i + 1));
            
            List<String> customerName = new ArrayList<>();
            
            if (Objects.nonNull(tickets.get(i))) 
            {
                customerName=tickets.get(i).getCustomerName();
            }
            System.out.format("| %-13s | %-32s %n", ticketNumber,customerName);
        }
    }
}
