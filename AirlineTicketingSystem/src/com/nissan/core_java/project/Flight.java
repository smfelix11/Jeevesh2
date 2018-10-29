package com.nissan.core_java.project;

public class Flight 
{
	String name;//Unique flight id
	String from;
	String airline_name;
	String to;
	String dept_time;
	String arrival_time;
	int capacity;
	String flightStatus;
	double price;
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getFlightStatus() {
		return flightStatus;
	}
	public void setFlightStatus(String flightStatus) {
		this.flightStatus = flightStatus;
	}
	public Flight(String name, String from, String airline_name, String to, String dept_time, String arrival_time,
			int capacity, double d) {
		super();
		this.name = name;
		this.from = from;
		this.airline_name = airline_name;
		this.to = to;
		this.dept_time = dept_time;
		this.arrival_time = arrival_time;
		this.capacity = capacity;
		this.price=d;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getAirline_name() {
		return airline_name;
	}
	public void setAirline_name(String airline_name) {
		this.airline_name = airline_name;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getDept_time() {
		return dept_time;
	}
	public void setDept_time(String dept_time) {
		this.dept_time = dept_time;
	}
	public String getArrival_time() {
		return arrival_time;
	}
	public void setArrival_time(String arrival_time) {
		this.arrival_time = arrival_time;
	}
}
