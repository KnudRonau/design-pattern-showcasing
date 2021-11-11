package com.dt181g.project.observer;

public interface Observable {

    void addObserver(Observer o);

    void removeObserver(Observer o);

    void doBroadcast();
}
