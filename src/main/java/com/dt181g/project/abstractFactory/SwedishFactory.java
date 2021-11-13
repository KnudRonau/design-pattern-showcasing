package com.dt181g.project.abstractFactory;

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
