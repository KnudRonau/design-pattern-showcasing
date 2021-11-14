package com.dt181g.project.abstractFactory;

/**
 * Concrete class implementing Factory responsible for creating DanishSofa and DanishToy
 * @author Knud Ronau Larsen
 */
public class DanishFactory implements Factory {

    @Override
    public Sofa createSofa() {
        return new DanishSofa();
    }

    @Override
    public Toy createToy() {
        return new DanishToy();
    }
}
