package com.dt181g.project.observer;

/**
 * Concrete RadioUnit implementing Observer. Follows an observable and prints a broadcast when called by observable.
 * @author Knud Ronau Larsen
 */
public class RadioUnit implements Observer {
    private Observable observable;
    private String name;

    /**
     * Constructor to store a name for the unit
     * @param name unit's name
     */
    public RadioUnit(String name) {
        this.name = name;
    }

    @Override
    public void update(String broadcast) {
        System.out.println(" --  " + name + " is now broadcasting " + broadcast);
    }

    @Override
    public void followObservable(Observable o) {
        this.observable = o;
    }
}
