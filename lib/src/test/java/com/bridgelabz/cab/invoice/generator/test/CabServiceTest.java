package com.bridgelabz.cab.invoice.generator.test;

import org.junit.Assert;
import org.junit.Test;
import com.bridgelabz.cab.invoice.generator.CabInvoiceGenerator;
import com.bridgelabz.cab.invoice.generator.Ride;

public class CabServiceTest {

	@Test
	public void givenDistanceAndTime_ShouldReturnTotalFare() {
		CabInvoiceGenerator generator = new CabInvoiceGenerator();
		double distance = 2.0;
		int time = 5;
		double fare = generator.calculateFare(distance,time);
		Assert.assertEquals(25,fare,0.0);
	}
	
	@Test
	public void givenDistanceAndTime_ShouldReturnMinFare() {
		CabInvoiceGenerator generator = new CabInvoiceGenerator();
		double distance = 0.1;
		int time = 1;
		double fare = generator.calculateFare(distance,time);
		Assert.assertEquals(5,fare,0.0);
	}
	
	@Test
	public void givenMultipleRides_ShouldReturnTotalFare() {
		CabInvoiceGenerator generator = new CabInvoiceGenerator();
		Ride[] rides = { new Ride(2.0,5),
						  new Ride (0.1,1)
		};
		double fare = generator.calculateFare(rides);
		Assert.assertEquals(30,fare,0.0);
	}
}
