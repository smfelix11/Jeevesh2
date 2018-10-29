package com.nissan.core_java.project;

import java.sql.*;
import java.util.*;

public class AdminMenu 
{

	public static void main(int adminInput) 
	{
		Scanner sc = new Scanner(System.in);
		
		FlightService fs = new FlightService();
		UserService us = new UserService();
		BookingClient client =new BookingClient();
		BookingHistory bookingHistory=new BookingHistory();
		Flight f,f1;
		Users u;
		
		//JDBC Connection
				/*try 
				{
				String databaseUrl="jdbc:mysql://localhost:3306/airlinemanagementsystem";
				Connection conn=DriverManager.getConnection(databaseUrl,"root","password1234");
				Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery("select * from userdetails");
				System.out.println("List of users\n");
				while(rs.next())
				{
					System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6));
				}
				}
				catch(Exception e)
				{
					System.out.println(e);
				}*/
		//JDBC
		boolean run = true;
		final String userPassword="12345";
		if (adminInput == 1) {
			while (run == true) 
			{
			System.out.println("Welcome Admin\n1.Add a flight\n2.Remove a flight\n3.Add a user\n4.Remove a user\n5.Display all flights\n6.Display all users\n7.Logout");
			int choiceUser = Integer.parseInt(sc.nextLine());
			
				switch (choiceUser) {
				case 1: {
					f = fs.createFlight(sc);
					fs.addFlight(f);
					fs.storeFlight();// database storage

				}
					break;
				case 2: 
				{
					System.out.println("Enter name of the flight");
					String temp=sc.nextLine();
					Flight fTemp=fs.getSpecificFlight(temp);
					if(fTemp!=null)
					{
						fs.removeFlight(fTemp);	
					}
					
					// fs.removeFlightDb();
				}
					break;
				case 3: {
					u = us.createUser(sc);
					us.addUser(u);
					us.storeUser();// database storage
				}
					break;
				case 4: 
				{
					System.out.println("Enter name of the user");
					String temp=sc.nextLine();
					Users uTemp=us.getSpecificUser(temp);
					if(uTemp!=null)
					{
						us.removeUser(uTemp);
					}
					// us.removeUserDb();
				}
					break;
				case 5: {
					ArrayList<Flight> hf = fs.getFlights();
					System.out.println(
							"Flight name \t Airline Name \t From \t Destination \t Departure Time \t Arrival Time \t Capacity");
					for (Flight fl : hf) {
						System.out.println(fl.getName() + "\t" + fl.getAirline_name() + "\t" + fl.getFrom() + "\t"
								+ fl.getTo() + "\t" + fl.getDept_time() + "\t" + fl.getArrival_time() + "\t"
								+ fl.getCapacity());
					}
				}
					break;
				case 6: {
					ArrayList<Users> ul = us.getUsers();
					System.out.println("User name \t Email \t Phone number \t City \t Date of Birth");
					for (Users u1 : ul) {
						System.out.println(u1.getName() + "\t" + u1.getEmail() + "\t" + u1.phone_number + "\t"
								+ u1.getCity() + "\t" + u1.getDateOfBirth());
					}
				}
					break;
				case 7: {
					run = false;
				}
					break;
				}

			}
		}
		else if(adminInput==2)
		{
			boolean run2=true;
			System.out.println("Enter user name");
			String uName=sc.nextLine();
			System.out.println("Enter user password");
			String uPassword=sc.nextLine();
			
			
			for(Users user:us.getUsers())
			{
				if(uName.equalsIgnoreCase(user.getName())&&uPassword.equals(userPassword))
				{
					while(run==true)
					{
						
						System.out.println("Welcome user.\n1.Book a Flight\nCancel a Flight\n3.Booked History\n4.Logout");
						int choiceUser=Integer.parseInt(sc.nextLine());
						switch(choiceUser)
						{
						case 1:
						{
							boolean booked=false;
							System.out.println("Enter the departure city");
							String dep=sc.nextLine();
							System.out.println("Enter the arrival city");
							String arri=sc.nextLine();

							ArrayList<Flight> flightList=fs.findFlight(dep,arri);
							System.out.println("Flight name \t Airline Name \t From \t Destination \t Departure Time \t Arrival Time \t Capacity");
							for(Flight f2:flightList)
	                        {
								System.out.println(f2.getName() + "\t" + f2.getAirline_name() + "\t" + f2.getFrom() + "\t"	+ f2.getTo() + "\t" + f2.getDept_time() + "\t" + f2.getArrival_time() + "\t" + f2.getCapacity());
	                        }
							if(flightList.size()>0)
							{
								System.out.println("Enter the flight name to be booked");
								String flightSelected=sc.nextLine();
								f1=fs.getSpecificFlight(flightSelected);
								
								System.out.println("Number of seats to be booked");
								int noOfTickets=Integer.parseInt(sc.nextLine());

								/*
								 * Directly updating flight tickets without recording the bookings
								 * 
								 * fs.updateFlightSeats(f1, (f1.capacity-noOfTickets));
								   System.out.println(noOfTickets+" successfully booked");
								*
								*/
								
								// Dealing with multiple passengers
								ArrayList<String> passengers=new ArrayList<String>();
								for(int i=0;i<noOfTickets;i++)
								{
									System.out.println(i+1+" Enter the traveller name ");
									passengers.add(sc.nextLine());
								}
								Booking booking=client.bookTickets(user,f1,f1.getCapacity(),noOfTickets,passengers);
	                            //double FinalPrice=noOfTickets*f1.getPrice();
								booked=PaymentService.getPaymentDetail(noOfTickets,f1,sc,client.getUserTickets(),booking);

	                            if(booked)
	                            {
	                                bookingHistory.setUser(user);
	                                f1.setFlightStatus("Confirmed");
	                                bookingHistory.setFlight(f1);
	                                //bookingHistory.setBookingDate(new Date());
	                                bookingHistory.setBooking(booking);
	                            }
	                            else 
	                            {
	                                bookingHistory.setUser(user);
	                                f1.setFlightStatus("Cancelled");
	                                bookingHistory.setFlight(f1);
	                                //bookingHistory.setBookingDate(new Date());
	                                bookingHistory.setBooking(booking);
	                            }
	                            client.getBookingHistory().add(bookingHistory);
	                        }
							else
	                        {
	                            System.out.println("No flights available");
	                        }

								
						}
						
						break;
						case 2:
						{
							Users currentUser=user;
	                        if(client.getUserTickets().size()>0){
	                            client.getUserTickets().stream().forEach(e->
	                            {
	                                if(e.getUser().getEmail().equalsIgnoreCase(currentUser.getEmail())){
	                                    System.out.println(e.getTicketId()+"\t"+e.getCustomerName());
	                                }
	                            });
	                            System.out.println("Enter the Ticket id which needs to be cancelled from booking list");
	                            int ticketId=sc.nextInt();
	                            Booking booking=client.getBookingFromTicket(ticketId);
	                            if(booking!=null) {
	                                Flight flightTicketCancelled=booking.getFlight();
	                                flightTicketCancelled.setCapacity(flightTicketCancelled.getCapacity()+booking.getNoOfTickets());

	                                client.getUserTickets().remove(booking);

	                                bookingHistory.setUser(user);
	                                flightTicketCancelled.setFlightStatus("Cancelled");
	                                bookingHistory.setFlight(flightTicketCancelled);
	                                bookingHistory.setBooking(booking);
	                                client.getBookingHistory().add(bookingHistory);


	                            }
	                            else
	                                System.out.println("Id not found");
	                        }
	                        else 
	                        {
	                            System.out.println("No seats");
	                        }
							
						}
						break;
						case 3:
						{
							
							if(client.getBookingHistory().size()>0){
	                            for(BookingHistory bh : client.getBookingHistory()){
	                                System.out.println(" Name :"+bh.getUser().getName()+" email :"+bh.getUser().getEmail());
	                                System.out.println(" Flight information \n Flight Name : "+bh.getFlight().getName());
	                                System.out.println("Departure :"+bh.getFlight().getFrom()+" Arrival :"
	                                        +bh.getFlight().getTo()+" Departure Time :"+bh.getFlight().getDept_time());
	                                System.out.println("Flight status :"+bh.getFlight().getFlightStatus());

	                                System.out.println(" Booking info :");
	                                System.out.println("Ticket ID : "+bh.getBooking().getTicketId());
	                                System.out.println("Travellers name : "+bh.getBooking().getCustomerName());
	                            }
	                        }else {
	                            System.out.println("No booking history available");
	                        }
						}
						break;
						case 4:
						{
							run=false;
						}
						break;
						}
					}
				}

			}
			
			}
					
		
	}
}
