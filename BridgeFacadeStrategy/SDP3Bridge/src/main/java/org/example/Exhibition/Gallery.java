package org.example.Exhibition;

import org.example.Art.IArt;
import org.example.ObjectType.IObjectFormat;
import org.example.Price.IPrice;
import org.example.Strategy.PricingStrategy;
import org.example.Strategy.RegularPricing;

import java.util.Objects;

public class Gallery extends Exhibition{
    private PricingStrategy pricingStrategy = new RegularPricing();

    public void setPricingStrategy(PricingStrategy pricingStrategy){
        this.pricingStrategy = Objects.requireNonNull(
                pricingStrategy, "Pricing must not be null"
        );
    }
    public Gallery(
            IArt artwork,
            IObjectFormat form,
            double priceUsd,
            IPrice price
    ) {
        super(artwork, price, priceUsd, form);
    }

    @Override
    public void show() {
        System.out.println("This artwork is available for sale");
        showDetails();
        double finalPriceUsd = pricingStrategy.calculatedPrice(priceUsd);
        System.out.println("Price: " + price.format(finalPriceUsd));
    }
}
