package org.example.Strategy;

public class CommissionPricing implements PricingStrategy{
    private final double commissionPercent;

    public CommissionPricing(double commissionPercent){
        if(!Double.isFinite(commissionPercent) || commissionPercent < 0 || commissionPercent > 100){
            throw new IllegalArgumentException("Commission must be finite, non-negative number");
        }

        this.commissionPercent = commissionPercent;
    }

    @Override
    public double calculatedPrice(double basePrice){
        return basePrice * (1 + commissionPercent / 100.00);
    }
}
