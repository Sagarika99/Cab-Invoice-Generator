package com.bridgelabz.cab.invoice.generator;

public class CabInvoiceGenerator {
	private static final double MINIMUM_COST_PERKM = 10; 
	private static final int COST_PER_TIME = 1;

	public double calculateFare(double distance, int time) {
		return distance * MINIMUM_COST_PERKM + time * COST_PER_TIME;
		
	}
	
}
