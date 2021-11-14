package com.dt181g.project.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Concrete RadioShow implementing Observable for showcasing observer pattern. Responsible for storing observers and
 * calling their update methods
 * @author Knud Ronau Larsen
 */
public class RadioShow implements Observable {
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void update() {
        for(Observer o : observers) {
            o.update("The daily weather report!");
        }
    }

}
