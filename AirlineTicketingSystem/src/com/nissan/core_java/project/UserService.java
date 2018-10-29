package com.nissan.core_java.project;
import java.util.*;

//import Users.*;
public class UserService 
{
	private static ArrayList<Users> user=new ArrayList<Users>();
	
	public Users createUser(Scanner sc)
	{
		//get all details
		
		System.out.println("Enter name of the User");
		String n=sc.nextLine();
		System.out.println("Enter the email id of the user");
		String e=sc.nextLine();
		System.out.println("Enter the phone number of the user");
		String p=sc.nextLine();
		System.out.println("Enter the city of the user");
		String c=sc.nextLine();
		System.out.println("Enter the date of birth of the user in DDMMYYYY format");
		String d=sc.nextLine();
		String date=d.substring(0,2)+"/"+d.substring(2,4)+"/"+d.substring(4);
		return new Users(n,e,p,c,date);
	}
	
	public void storeUser()
	{
		//save user to database
	}
	
	public ArrayList<Users> getUsers()
	{
		return user;
	}
	
	public void addUser(Users u)
	{
		if(user.contains(u)!=true)
		{
			user.add(u);
			System.out.println("User added successfully");
		}
		else
		{
			System.out.println("User already exists");
		}
	}
	
	public void removeUser(Users u)
	{
		if(user.contains(u))
			{
				user.remove(u);
				System.out.println("User successfully removed");
			}
		else
			System.out.println("User dosent exist");
	}

	public Users getSpecificUser(String temp) 
	{
		Users u0=null;
		for(Users u:user)
		{
			if(u.getName().equalsIgnoreCase(temp))
			{
				u0=u;
			}
		}
		
		return u0;
	}
	

}
