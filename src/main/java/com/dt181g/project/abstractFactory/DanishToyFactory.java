package com.dt181g.project.abstractFactory;

public class DanishToyFactory implements ToyFactory {

    @Override
    public Toy createCheapToy() {
        return new CheapDanishToy();
    }

    @Override
    public Toy createPremiumToy() {
        return new PremiumDanishToy();
    }
}
