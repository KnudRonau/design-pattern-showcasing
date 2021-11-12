package com.dt181g.project.abstractFactory;

public class SwedishToyFactory implements ToyFactory{
    @Override
    public Toy createCheapToy() {
        return new CheapSwedishToy();
    }

    @Override
    public Toy createPremiumToy() {
        return new PremiumSwedishToy();
    }
}
