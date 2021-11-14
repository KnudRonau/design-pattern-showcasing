package com.dt181g.project.factoryMethod;

/**
 * Concrete class implementing Announcement. Responsible for returning a closing message.
 * @author Knud Ronau Larsen
 */
public class Closing implements Announcement{

    @Override
    public String getMessage() {
        return "\nTHIS IS A CLOSING ANNOUNCEMENT! THE CENTRE CLOSES IN 15 MINUTES\n";
    }
}
