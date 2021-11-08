package com.dt181g.project.templateMethod;

public abstract class TemplateDemo {

    public final String outputInfo() {
        return lineOne() + lineTwo() + lineThree();
    }

    public abstract String lineOne();
    public abstract String lineTwo();
    public abstract String lineThree();

}
