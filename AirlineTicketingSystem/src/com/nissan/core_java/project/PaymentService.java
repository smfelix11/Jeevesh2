package com.nissan.core_java.project;
import java.util.*;
public class PaymentService 
{

    public static boolean getPaymentDetail(int noOfSeats, Flight f, Scanner sc, List<Booking> bookingList,Booking book){
        Payment p=new Payment();
        p.setFlightPrice(noOfSeats*f.getPrice());
        p.settax(((float)18/100)*(float) p.getFlightPrice());
        boolean flag=false;
        double finalAmount=p.getFlightPrice()+p.gettax();

        System.out.println(" Final bill is "+finalAmount+"\nContinue (Y/N) ?");
        String confirm=sc.next();
        if(confirm.trim().equalsIgnoreCase("yes") || confirm.trim().equalsIgnoreCase("y")) 
        {

            System.out.println("Ticket Booked");

            System.out.println(" Ticket :\n");
            System.out.println("Departure : "+f.getFrom()+"\t Arrival : "+f.getTo());
             
            
            System.out.println("Flight fare : " + (p.getFlightPrice() + "tax : " + p.gettax()));
            
            System.out.println("Total amount : " + finalAmount);
            flag=true;
        }
        else
        {
            f.setCapacity(f.getCapacity()+noOfSeats);
            bookingList.remove(book);
            System.out.println("Ticket Cancelled");
        }
        return flag;
    }
}