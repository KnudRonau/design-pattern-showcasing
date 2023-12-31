package com.dt181g.project.templateMethod;

/**
 * Concrete class extending TemplateDemo, responsible for implementing the two abstract methods.
 * @author Knud Ronau Larsen
 */
public class Sub1 extends TemplateDemo {

    @Override
    public String lineOne() {
        return "This is line one from overridden method lineOne in class Sub1 extending templateDemo\n";
    }

    @Override
    public String lineTwo() {
        return "If you click on Template Button 2, you will see what the other subclass has to offer!\n";
    }
}
