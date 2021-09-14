package com.bridgelabz.cab.invoice.generator;

import java.util.Objects;

public class InvoiceSummary {

	public int noOfRides;
	public double totalFare;
	public double averageFare;

	public InvoiceSummary(int noOfRides, double totalFare ) {
		this.noOfRides = noOfRides;
		this.totalFare = totalFare;
		this.averageFare = this.totalFare/this.noOfRides;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InvoiceSummary other = (InvoiceSummary) obj;
		return averageFare == other.averageFare && noOfRides == other.noOfRides && totalFare == other.totalFare;
	}	
}
