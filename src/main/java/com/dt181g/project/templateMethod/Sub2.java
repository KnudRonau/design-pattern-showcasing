package com.dt181g.project.templateMethod;

public class Sub2 extends TemplateDemo {

    @Override
    public String lineOne() {
        return "This is line one from overridden method lineOne in the class Sub2 extending templateDemo\n";
    }

    @Override
    public String lineTwo() {
        return "TemplateDemo's final method outputInfo returns different a different String depending on the object's " +
                "class\n";
    }

    @Override
    public String lineThree() {
        return "In this case, outputInfo is triggered on a Sub2 object\n";
    }


}
