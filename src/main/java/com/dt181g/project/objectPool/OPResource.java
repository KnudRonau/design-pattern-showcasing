package com.dt181g.project.objectPool;

public class OPResource {
    private final int value;
    public OPResource(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }

    public void useResource() {
        System.out.println("The resource numbered " + value + " is now being used, " +
                "and will be returned afterwards");
    }

}
