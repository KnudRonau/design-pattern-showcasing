package com.dt181g.project.observer;

public interface Observable {

    void addRadioUnit(RadioUnit radioUnit);

    void removeRadioUnit(RadioUnit radioUnit);

    void doBroadcast();
}
