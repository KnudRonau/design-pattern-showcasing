package com.dt181g.project.observer;

import java.util.ArrayList;
import java.util.List;

public class RadioShow implements Observable {
    private List<RadioUnit> radioUnits = new ArrayList<RadioUnit>();
//    private String broadcast;

    @Override
    public void addRadioUnit(RadioUnit radioUnit) {
        radioUnits.add(radioUnit);
    }

    @Override
    public void removeRadioUnit(RadioUnit radioUnit) {
        radioUnits.remove(radioUnit);
    }

    @Override
    public void doBroadcast() {
//        this.broadcast = broadcast;
        for(RadioUnit radioUnit : radioUnits) {
            radioUnit.update("The daily weather report!");
        }
    }

}
