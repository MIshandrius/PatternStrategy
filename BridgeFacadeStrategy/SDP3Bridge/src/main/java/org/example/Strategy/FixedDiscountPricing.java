package org.example.Strategy;

public class FixedDiscountPricing implements PricingStrategy {

    private final double discountUsd;

    public FixedDiscountPricing(double discountUsd) {
        if (!Double.isFinite(discountUsd) || discountUsd < 0) {
            throw new IllegalArgumentException(
                    "Discount must be a finite, non-negative number"
            );
        }

        this.discountUsd = discountUsd;
    }

    @Override
    public double calculatedPrice(double basePrice) {
        return Math.max(0, basePrice - discountUsd);
    }
}
