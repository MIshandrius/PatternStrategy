package org.example.Art;

public class Sculpture implements IArt{
    protected String sculpture;
    @Override
    public void detailArt(){
        System.out.println("Sculpture: " + sculpture);
    }
    public Sculpture(String sculpture) {
        this.sculpture = sculpture;
    }
}
