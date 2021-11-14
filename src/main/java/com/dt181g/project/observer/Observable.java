package com.dt181g.project.observer;

/**
 * Subject interface for entities to conform to the observer pattern
 * @author Knud Ronau Larsen
 */
public interface Observable {

    /**
     * Method to add an observer to list of observers
     * @param o observer
     */
    void addObserver(Observer o);

    /**
     * Method to remover observer from observer list
     * @param o observer
     */
    void removeObserver(Observer o);

    /**
     * Method to call update method on all observers in list
     */
    void update();
}
