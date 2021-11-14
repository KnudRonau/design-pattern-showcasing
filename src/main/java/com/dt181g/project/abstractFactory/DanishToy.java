package com.dt181g.project.abstractFactory;

/**
 * Concrete class implementing Toy responsible for returning various information regarding a danish toy.
 * @author Knud Ronau Larsen
 */
public class DanishToy implements Toy {

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
                + "\nAmount of Fun: " + getFunRating() + "\nPrice: " + getPrice() + "\n";
    }
}
