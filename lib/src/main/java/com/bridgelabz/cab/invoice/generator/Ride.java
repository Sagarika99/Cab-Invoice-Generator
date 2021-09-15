package com.bridgelabz.cab.invoice.generator;

public class Ride {

	public double distance;
	public int time;
	public int id;

	public Ride(int id, double distance, int time) {
		this.id = id;
		this.distance = distance;
		this.time = time;
	}
	
	public Ride( double distance, int time) {
		this.distance = distance;
		this.time = time;
	}
}
