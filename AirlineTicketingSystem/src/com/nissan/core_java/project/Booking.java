package com.nissan.core_java.project;
import java.util.*;
public class Booking 
{
	int noOfTickets;
	ArrayList<String> customers;
	Users user;
	Flight flight;
	int ticketId;
	
	public int getNoOfTickets() 
	{
		return noOfTickets;
	}
	public void setNoOfTickets(int noOfTickets) 
	{
		this.noOfTickets = noOfTickets;
	}
	
	public ArrayList<String> getCustomers() 
	{
		return customers;
	}
	public void setCustomers(ArrayList<String> customers) 
	{
		this.customers = customers;
	}
	
	public Users getUser() 
	{
		return user;
	}
	public void setUser(Users user) 
	{
		this.user = user;
	}
	
	public Booking(int numberOfTickets, ArrayList<String> customerNames)
	{
        this.noOfTickets=numberOfTickets;
        this.customers=customerNames;
    }
	
	public Flight getFlight() 
	{
		return flight;
	}
	public void setFlight(Flight flight) 
	{
		this.flight = flight;
	}
	
	public int getTicketId() 
	{
		return ticketId;
	}
	public void setTicketId(int ticketId) 
	{
		this.ticketId = ticketId;
	}
	
	public ArrayList<String> getCustomerName() 
	{
        return this.customers;
    }
}
