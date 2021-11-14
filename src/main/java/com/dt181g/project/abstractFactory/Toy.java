package com.dt181g.project.abstractFactory;

/**
 * Interface for creating a Toy. Has methods to return information regarding the Toy.
 * @author Knud Ronau Larsen
 */
public interface Toy {
    /**
     * Method to get Toy's name
     * @return name of Toy
     */
    String getName();

    /**
     * Method to get origin country
     * @return origin of Toy
     */
    String getOriginCountry();

    /**
     * Method to get fun rating
      * @return fun rating of Toy
     */
    String getFunRating();

    /**
     * Method to return price
     * @return price of Toy
     */
    String getPrice();

    /**
     * Method to return all the info in one String
     * @return all info
     */
    String getInfo();
}
