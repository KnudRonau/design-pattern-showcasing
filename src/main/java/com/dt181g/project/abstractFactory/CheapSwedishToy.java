package com.dt181g.project.abstractFactory;

public class CheapSwedishToy implements Toy{

    @Override
    public String getName() {
        return "Cheap Boring Swedish Toy";
    }

    @Override
    public String getOriginCountry() {
        return "Sweden";
    }

    @Override
    public String getFunRating() {
        return "2/10";
    }

    @Override
    public String getPrice() {
        return "70 Fake Crowns";
    }

    @Override
    public String getInfo() {
        return "Name: " + getName() + "\nCountry of Origin: " + getOriginCountry()
                + "\nAmount of Fun: " + getFunRating() + "\nPrice: " + getPrice();
    }
}
