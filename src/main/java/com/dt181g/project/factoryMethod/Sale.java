package com.dt181g.project.factoryMethod;

/**
 * Concrete class implementing Announcement. Responsible for returning a sale message.
 * @author Knud Ronau Larsen
 */
public class Sale implements Announcement{

    @Override
    public String getMessage() {
        return "\nTHIS IS A SALE ANNOUNCEMENT! RIGHT NOW WE OFFER 80% ON EVERYTHING!\n";
    }
}
