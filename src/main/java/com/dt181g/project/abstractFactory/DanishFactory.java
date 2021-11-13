package com.dt181g.project.abstractFactory;

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
