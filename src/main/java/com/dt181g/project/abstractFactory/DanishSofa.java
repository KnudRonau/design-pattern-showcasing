package com.dt181g.project.abstractFactory;

/**
 * Concrete class implementing Sofa responsible for returning various information regarding a danish sofa.
 * @author Knud Ronau Larsen
 */
public class DanishSofa implements Sofa{

    @Override
    public String getName() {
        return "Jysk Sofa";
    }

    @Override
    public double getLength() {
        return 2.6;
    }

    @Override
    public String getComfortLevel() {
        return "Decently Comfortable";
    }

    @Override
    public String getOriginCountry() {
        return "Denmark";
    }

    @Override
    public String getPrice() {
        return "4000 real crowns";
    }

    @Override
    public String getInfo() {
        return "Name: " + getName() + "\nCountry of Origin: " + getOriginCountry() + "\nLength in meters: " + getLength()
                + "\nComfort Level: " + getComfortLevel() + "\nPrice: " + getPrice() + "\n";
    }
}
