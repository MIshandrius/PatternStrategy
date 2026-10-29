package org.example;

import org.example.Facade.GalleryFacade;
import org.example.Facade.MuseumFacade;
import org.example.Strategy.RegularPricing;
import org.example.Strategy.DiscountPricing;
import org.example.Strategy.CommissionPricing;
import org.example.Strategy.FixedDiscountPricing;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        GalleryFacade gallery = new GalleryFacade("Starry Night", 100000, "KZT");

        gallery.showGallery();

        gallery.presentVirtualGallery();
        gallery.presentPhysicalGallery();

        gallery.presentWithPricing(new RegularPricing());
        gallery.presentWithPricing(new DiscountPricing(10));
        gallery.presentWithPricing(new CommissionPricing(15));
        gallery.presentWithPricing(new FixedDiscountPricing(5000));
        gallery.presentWithPricing(new RegularPricing());

        MuseumFacade museum = new MuseumFacade("DAVID");
        museum.showMuseum();

        museum.presentPhysicalMuseum();
        museum.presentVirtualMuseum();


    }


}
