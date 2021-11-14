package com.dt181g.project.abstractFactory;

/**
 * Concrete class implementing Toy responsible for returning various information regarding a swedish toy.
 * @author Knud Ronau Larsen
 */
public class SwedishToy implements Toy {

    @Override
    public String getName() {
        return "Boring Swedish Toy";
    }

    @Override
    public String getOriginCountry() {
        return "Sweden";
    }

    @Override
    public String getFunRating() {
        return "4/10";
    }

    @Override
    public String getPrice() {
        return "250 Fake Crowns";
    }

    @Override
    public String getInfo() {
        return "Name: " + getName() + "\nCountry of Origin: " + getOriginCountry()
                + "\nAmount of Fun: " + getFunRating() + "\nPrice: " + getPrice() + "\n";
    }
}
