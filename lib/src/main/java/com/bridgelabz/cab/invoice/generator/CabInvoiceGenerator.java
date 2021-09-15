package com.bridgelabz.cab.invoice.generator;

import java.util.HashMap;

public class CabInvoiceGenerator {
	private static final double MINIMUM_COST_PERKM = 10; 
	private static final int COST_PER_TIME = 1;
	private static final double MINIMUM_FARE = 5;
	private int id = 1;
	HashMap<Integer,InvoiceSummary> multipleUser = new HashMap<Integer, InvoiceSummary>();
	

	public double calculateFare(double distance, int time) {
		double totalFare = distance * MINIMUM_COST_PERKM + time * COST_PER_TIME;
//		if (totalFare < MINIMUM_FARE) {
//			return MINIMUM_FARE;
//		}
//		return totalFare;
		return Math.max(totalFare, MINIMUM_FARE);
	}

	public InvoiceSummary calculateFare(Ride[] rides) {
		double totalFare = 0;
		for(Ride ride : rides) {
			totalFare += this.calculateFare(ride.distance, ride.time);
		}
		multipleUser.put(id, new InvoiceSummary(rides.length, totalFare));
		return new InvoiceSummary(rides.length, totalFare);
	}

	public String fareOfGivenId(int i) {
		System.out.println(multipleUser.get(i));
		return String.valueOf(multipleUser.get(i));
	}
	
}
