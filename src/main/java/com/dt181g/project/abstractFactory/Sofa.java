package com.dt181g.project.abstractFactory;

/**
 * Interface for creating a Sofa. Has methods to return information regarding the Sofa.
 * @author Knud Ronau Larsen
 */
public interface Sofa {
    /**
     * Method to get Sofa's name
     * @return name of Sofa
     */
    String getName();

    /**
     * Method to return length of Sofa
     * @return length of Sofa
     */
    double getLength();

    /**
     * Method to return comfort level of sofa
     * @return comfort level
     */
    String getComfortLevel();

    /**
     * Method to get origin country
     * @return country of origin
     */
    String getOriginCountry();

    /**
     * Method to return price
     * @return price of Sofa
     */
    String getPrice();

    /**
     * Method to return all the info in one String
     * @return all info
     */
    String getInfo();
}
