package org.example.Strategy;

public class RegularPricing implements PricingStrategy {
    @Override
    public double calculatedPrice(double basePrice){
        return basePrice;
    }
}
