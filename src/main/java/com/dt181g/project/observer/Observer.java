package com.dt181g.project.observer;

/**
 * object interface for entities to conform to the observer pattern
 */
public interface Observer {

    /**
     * Method to print local information along with provided update
     * @param update String containing information to add
     */
    void update(String update);

    /**
     * Method to follow an observable object
     * @param o object to observe
     */
    void followObservable(Observable o);
}
