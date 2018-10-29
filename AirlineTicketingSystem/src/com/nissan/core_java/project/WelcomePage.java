package com.nissan.core_java.project;
import java.util.*;
import java.sql.*;
public class WelcomePage 
{
	final static String adminPassword="pas123";
	public static void main(String[] args) 
	{
		boolean b=false;
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		AdminMenu am=new AdminMenu();
		AdminMenu am2;
		
		/*UserMenu us=new UserMenu();*/
		
		
		
		
		
		while(b!=true)
		{
			System.out.println("    Airline Ticketing System\n Choose access type\n1.Admin\n2.Regular User");
			int choice=Integer.parseInt(sc.nextLine());
			if(choice==1)
			{
				//Authenticate admin
				System.out.println("Enter admin password");
				String pas=sc.nextLine();
				if(pas.equalsIgnoreCase(adminPassword))
				{
					//switch control to admin
					am.main(1);
				}
			}
			else 
				if(choice==2)
				{
					//Switch to user
					am.main(2);
				}
		}
	}

}
