package com.bridgelabz.cab.invoice.generator.test;

import org.junit.Assert;
import java.util.HashMap;
import org.junit.Test;
import com.bridgelabz.cab.invoice.generator.CabInvoiceGenerator;
import com.bridgelabz.cab.invoice.generator.Ride;
import com.bridgelabz.cab.invoice.generator.RideType;
import com.bridgelabz.cab.invoice.generator.InvoiceSummary;

public class CabServiceTest {
	HashMap<Integer, InvoiceSummary> multipleUser = new HashMap<Integer, InvoiceSummary>();
		
	@Test
	public void givenDistanceAndTime_ShouldReturnTotalFare() {
		CabInvoiceGenerator generator = new CabInvoiceGenerator();
		double distance = 2.0;
		int time = 5;
		double fare = generator.calculateFare(distance,time,RideType.NORMAL);
		Assert.assertEquals(25,fare,0.0);
	}
	
	@Test
	public void givenDistanceAndTime_ShouldReturnMinFare() {
		CabInvoiceGenerator generator = new CabInvoiceGenerator();
		double distance = 0.1;
		int time = 1;
		double fare = generator.calculateFare(distance,time,RideType.NORMAL);
		Assert.assertEquals(5,fare,0.0);
	}
	
	@Test
	public void givenMultipleRides_ShouldReturnInvoiceSummary() {
		CabInvoiceGenerator generator = new CabInvoiceGenerator();
		Ride[] rides = { new Ride(2.0,5),
						  new Ride (0.1,1)
		};
		InvoiceSummary summary = generator.calculateFare(rides, RideType.NORMAL);
		InvoiceSummary expectedSummary = new InvoiceSummary(2,30);
		Assert.assertEquals(expectedSummary,summary);
	} 
	
	public void givenUserId_ShouldReturnInvoiceSummary() {
		CabInvoiceGenerator generator = new CabInvoiceGenerator();
		Ride[] ride1 = { new Ride(1,2.0,5), new Ride (1,0.1,1) };
		Ride[] ride2 = { new Ride(2,4,6),new Ride(2,2,3),new Ride(2,5,6)};
		
		InvoiceSummary fare1 = generator.calculateFare(ride1,RideType.NORMAL);
		Assert.assertEquals("InvoiceSummary{noOfRides=2, totalFare=30.0, avaerageFare=15.0", generator.fareOfGivenId(1));
		InvoiceSummary fare2 = generator.calculateFare(ride2,RideType.PREMIUM);
		Assert.assertEquals("InvoiceSummary{noOfRides=3, totalFare=125.0, avaerageFare=41.6", generator.fareOfGivenId(2));
	}
}