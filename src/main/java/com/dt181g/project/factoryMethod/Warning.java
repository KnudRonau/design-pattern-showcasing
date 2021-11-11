package com.dt181g.project.factoryMethod;

public class Warning implements Announcement{

    @Override
    public String getMessage() {
        return "\nTHIS IS A WARNING ANNOUNCEMENT! THE FLOOR IS LAVA, GET UP ON SOMETHING!\n";
    }
}
