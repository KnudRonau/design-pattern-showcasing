package com.dt181g.project.factoryMethod;

/**
 * Concrete class implementing Announcement. Responsible for returning a warning message.
 * @author Knud Ronau Larsen
 */
public class Warning implements Announcement{

    @Override
    public String getMessage() {
        return "\nTHIS IS A WARNING ANNOUNCEMENT! THE FLOOR IS LAVA, GET UP ON SOMETHING!\n";
    }
}
