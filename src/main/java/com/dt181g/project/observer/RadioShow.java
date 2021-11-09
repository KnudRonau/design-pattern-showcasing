package com.dt181g.project.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class RadioShow  {
    private List<Observer> observers = new ArrayList<Observer>();
    private String broadcast;

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void doBroadcast(String broadcast) {
        this.broadcast = broadcast;
        for(Observer observer : observers) {
            observer.update();
        }
    }

}
