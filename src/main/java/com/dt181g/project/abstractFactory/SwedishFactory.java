package com.dt181g.project.abstractFactory;

/**
 * Concrete class implementing Factory responsible for creating SwedishSofa and SwedishSofa
 * @author Knud Ronau Larsen
 */
public class SwedishFactory implements Factory {
    @Override
    public Sofa createSofa() {
        return new SwedishSofa();
    }

    @Override
    public Toy createToy() {
        return new SwedishToy();
    }
}
