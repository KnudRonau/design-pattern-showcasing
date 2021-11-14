package com.dt181g.project.templateMethod;

public abstract class TemplateDemo {

    public final String outputInfo() {
        return lineOne() + lineTwo() + lineThree();
    }

    public abstract String lineOne();
    public abstract String lineTwo();
    public final String lineThree() {
        return "Isn't the template method just neat?\n";
    }

}
