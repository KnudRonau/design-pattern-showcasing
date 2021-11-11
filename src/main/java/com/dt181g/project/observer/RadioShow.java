package com.dt181g.project.observer;

import java.util.ArrayList;
import java.util.List;

public class RadioShow implements Observable {
    private List<Observer> observers = new ArrayList<Observer>();
//    private String broadcast;

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void doBroadcast() {
//        this.broadcast = broadcast;
        for(Observer o : observers) {
            o.update("The daily weather report!");
        }
    }

}
