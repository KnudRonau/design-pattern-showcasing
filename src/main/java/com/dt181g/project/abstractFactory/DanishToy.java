package com.dt181g.project.abstractFactory;

public class DanishToy implements Toy {
    private String name;
    private String originCountry;
    private String funRating;
    private String price;

    public DanishToy() {
        this.name = "Big Lego box";
        this.originCountry = "Denmark";
        this.funRating = "10/10";
        this.price = "200 real crowns";
    }

    @Override
    public String getName() {
        return "Big Lego Box";
    }

    @Override
    public String getOriginCountry() {
        return "Denmark";
    }

    @Override
    public String getFunRating() {
        return "10/10";
    }

    @Override
    public String getPrice() {
        return "200 Real Crowns";
    }

    @Override
    public String getInfo() {
        return "Name: " + getName() + "\nCountry of Origin: " + getOriginCountry()
                + "\nAmount of Fun: " + getFunRating() + "\nPrice: " + getPrice();
    }
}
