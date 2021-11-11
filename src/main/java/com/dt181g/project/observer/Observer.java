package com.dt181g.project.observer;

public interface Observer {

    void update(String update);
    void followObservable(Observable o);
}
