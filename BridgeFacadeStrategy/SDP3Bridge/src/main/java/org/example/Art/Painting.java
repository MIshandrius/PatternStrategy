package org.example.Art;


public class Painting implements IArt {
    protected String painting;

    public Painting(String painting) {
        this.painting = painting;
    }

    @Override
    public void detailArt(){
        System.out.println("Painting: " + painting);
    }
}
