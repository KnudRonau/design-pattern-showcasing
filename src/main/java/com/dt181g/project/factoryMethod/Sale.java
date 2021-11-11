package com.dt181g.project.factoryMethod;

public class Sale implements Announcement{

    @Override
    public String getMessage() {
        return "\nTHIS IS A SALE ANNOUNCEMENT! RIGHT NOW WE OFFER 80% ON EVERYTHING!";
    }
}
