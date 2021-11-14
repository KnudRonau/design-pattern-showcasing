package com.dt181g.project.templateMethod;

/**
 * Abstract class for showcasing the template method pattern. Responsible for providing an interface for subclasses
 * and gathering concrete class differences into a single String output.
 * @author Knud Ronau Larsen
 */
public abstract class TemplateDemo {

    /**
     * Method to gather all class Strings and return them as a single one
     * @return Conjoined String
     */
    public final String outputInfo() {
        return lineOne() + lineTwo() + lineThree();
    }

    /**
     * Method returning a concrete class specific String
     * @return class specific String
     */
    public abstract String lineOne();

    /**
     * Method returning a concrete class specific String
     * @return class specific String
     */
    public abstract String lineTwo();

    /**
     * Method returning a String relevant to all subclasses.
     * @return Generally relevant String
     */
    public final String lineThree() {
        return "Isn't the template method just neat?\n";
    }

}
