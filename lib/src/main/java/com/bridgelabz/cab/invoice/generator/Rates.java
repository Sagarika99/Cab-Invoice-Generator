package com.bridgelabz.cab.invoice.generator;

public class Rates {

    int normalRatePerKM;
    int normalRatePerMIN;
    int normalMinFare;

    int premiumRatePerKM;
    int premiumRatePerMIN;
    int premiumMinFare;

    public Rates(int normalRatePerKM, int normalRatePerMIN, int normalMinFare ,int premiumRatePerKM, int premiumRatePerMIN, int premiumMinFare ) {
        this.normalRatePerKM = normalRatePerKM;
        this.normalRatePerMIN = normalRatePerMIN;
        this.normalMinFare = normalMinFare;

        this.premiumRatePerKM = premiumRatePerKM;
        this.premiumRatePerMIN = premiumRatePerMIN;
        this.premiumMinFare = premiumMinFare;

    }
}
