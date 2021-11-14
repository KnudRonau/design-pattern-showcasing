package com.dt181g.project.abstractFactory;

/**
 * Interface for creating a Factory. Has methods to create a Toy and a Sofa.
 * @author Knud Ronau Larsen
 */
public interface Factory {
    /**
     * Method to create a Toy
     * @return created Toy
     */
    Toy createToy();
    /**
     * Method to create a Sofa
     * @return created Sofa
     */
    Sofa createSofa();

}
