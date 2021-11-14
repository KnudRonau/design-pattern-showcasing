package com.dt181g.project.templateMethod;

/**
 * Concrete class extending TemplateDemo, responsible for implementing the two abstract methods.
 * @author Knud Ronau Larsen
 */
public class Sub2 extends TemplateDemo {

    @Override
    public String lineOne() {
        return "This is line one from overridden method lineOne in class Sub2 extending templateDemo\n";
    }

    @Override
    public String lineTwo() {
        return "This is what the other class returns! WOW \n";
    }

}
