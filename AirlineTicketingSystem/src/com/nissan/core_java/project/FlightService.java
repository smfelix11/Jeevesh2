package com.nissan.core_java.project;

import java.util.*;

public class FlightService 
{

	private static ArrayList<Flight> fl=new ArrayList<Flight>();
	
	public Flight createFlight(Scanner sc)
	{
		//All flight details
		System.out.println("Enter flight name");
		String n=sc.nextLine();
		System.out.println("Enter departure city");
		String d=sc.nextLine();
		System.out.println("Enter airline name");
		String an=sc.nextLine();
		System.out.println("Enter Destination city");
		String dest=sc.nextLine();
		System.out.println("Enter departure time");
		String dep=sc.nextLine();
		System.out.println("Enter arrival time");
		String arr=sc.nextLine();
		System.out.println("Enter capacity of the flight");
		int cap=Integer.parseInt(sc.nextLine());
		System.out.println("Enter price of one ticket");
		double price=Double.parseDouble(sc.nextLine());

		return new Flight(n,d,an,dest,dep,arr,cap,price);
	}
	
	public void storeFlight()
	{
		//save Flight to database
	}
	public ArrayList<Flight> getFlights()
	{
		return fl;
	}
	
	public void addFlight(Flight f)
	{
		if(fl.contains(f)!=true)
		{
			fl.add(f);
			System.out.println("Flight added successfully");
		}
		else
		{
			System.out.println("Flight already in system");
		}
	}
	
	public void removeFlight(Flight f)
	{
		if(fl.contains(f))
		{
			fl.remove(f);
			System.out.println("Flight removed successfully");
		}
		else
		{
			System.out.println("Flight not found");
		}
	}
	
	public ArrayList<Flight> findFlight(String dep,String arr)
	{
		ArrayList<Flight> matchingFlights=new ArrayList<Flight>();
		for(Flight f:fl)
		{
			if(f.getFrom().equalsIgnoreCase(dep)&&f.getTo().equalsIgnoreCase(arr))
			{
				matchingFlights.add(f);
			}
		}
		return matchingFlights;
	}
	
	public Flight getSpecificFlight(String name)
	{
		Flight f0=null;
		for(Flight f:fl)
		{
			if(f.getName().equalsIgnoreCase(name))
			{
				f0=f;
			}
		}
		return f0;
	}
	
	public static void updateFlightSeats(Flight flight,int seats)
	{
        flight.setCapacity(flight.getCapacity()-seats);
        fl.add(flight);
    }
}
