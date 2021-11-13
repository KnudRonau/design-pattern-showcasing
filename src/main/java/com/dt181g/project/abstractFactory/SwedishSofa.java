package com.dt181g.project.abstractFactory;

public class SwedishSofa implements Sofa{

    @Override
    public String getName() {
        return "Ikea Sofa";
    }

    @Override
    public double getLength() {
        return 3.2;
    }

    @Override
    public String getComfortLevel() {
        return "Very comfortable";
    }

    @Override
    public String getOriginCountry() {
        return "Sweden";
    }

    @Override
    public String getPrice() {
        return "7000 Fake Crowns";
    }

    @Override
    public String getInfo() {
        return "Name: " + getName() + "\nCountry of Origin: " + getOriginCountry() + "\nLength in meters: " + getLength()
                + "\nComfort Level: " + getComfortLevel() + "\nPrice: " + getPrice() + "\n";
    }
}
