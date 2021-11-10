package com.dt181g.project.observer;

public class RadioUnit implements Observer {
    private RadioShow radioShow;
    private String name;

    public RadioUnit(String name) {
        super();
        this.name = name;
    }

    @Override
    public void update(String broadcast) {
        System.out.println(name + " is now broadcasting " + broadcast);
    }

    @Override
    public void followRadioShow(RadioShow radioShow) {
        this.radioShow = radioShow;
    }
}
