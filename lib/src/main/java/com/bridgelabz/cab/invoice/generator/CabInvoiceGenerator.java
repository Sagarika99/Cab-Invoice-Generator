package com.bridgelabz.cab.invoice.generator;

import java.util.HashMap;

public class CabInvoiceGenerator {
//	private static final double MINIMUM_COST_PERKM = 10; 
//	private static final int COST_PER_TIME = 1;
//	private static final double MINIMUM_FARE = 5;
	public double totalFare = 0;
	private int id = 1;
	Rates rate = new Rates (10,1,5,15,2,20);
	HashMap<Integer,InvoiceSummary> multipleUser = new HashMap<Integer, InvoiceSummary>();
	

	public double calculateFare(double distance, int time, RideType rideType) {
		if(rideType == rideType.NORMAL) {
			totalFare = distance * rate.normalRatePerKM + time * rate.normalRatePerMIN;
			double minfare = Math.max(totalFare, rate.normalMinFare);
			return minfare;
		}else if (rideType == rideType.PREMIUM) {
			totalFare = distance * rate.premiumRatePerKM + time * rate.premiumRatePerMIN;
			double minfare = Math.max(totalFare, rate.premiumMinFare);
			return minfare;
		}
		return totalFare;
	}

	public InvoiceSummary calculateFare(Ride[] rides, RideType rideType) {
		double totalFare = 0;
		for(Ride ride : rides) {
			totalFare += this.calculateFare(ride.distance, ride.time, rideType);
		}
		multipleUser.put(id, new InvoiceSummary(rides.length, totalFare));
		id++;
		return new InvoiceSummary(rides.length, totalFare);
	}

	public String fareOfGivenId(int i) {
		System.out.println(multipleUser.get(i));
		return String.valueOf(multipleUser.get(i));
	}
	
}
