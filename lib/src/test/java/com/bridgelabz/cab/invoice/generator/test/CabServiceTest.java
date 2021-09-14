package com.bridgelabz.cab.invoice.generator.test;

import org.junit.Assert;
import org.junit.Test;
 import com.bridgelabz.cab.invoice.generator.CabInvoiceGenerator;

public class CabServiceTest {

	@Test
	public void givenDistanceAndTime_ShouldReturnTotalFare() {
		CabInvoiceGenerator generator = new CabInvoiceGenerator();
		double distance = 2.0;
		int time = 5;
		double fare = generator.calculateFare(distance,time);
		Assert.assertEquals(25,fare,0.0);
	}
}
