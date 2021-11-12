package com.dt181g.project.abstractFactory;

public class CheapDanishToy implements Toy{

    @Override
    public String getName() {
        return "Small Lego box";
    }

    @Override
    public String getOriginCountry() {
        return "Denmark";
    }

    @Override
    public String getFunRating() {
        return "7/10";
    }

    @Override
    public String getPrice() {
        return "50 real crowns";
    }

    @Override
    public String getInfo() {
        return "Name: " + getName() + "\nCountry of Origin: " + getOriginCountry()
                + "\nAmount of Fun: " + getFunRating() + "\nPrice: " + getPrice();
    }
}
