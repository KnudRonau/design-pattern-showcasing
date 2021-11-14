package com.dt181g.project.objectPool;

/**
 * Class for showcasing a resource to be used in a pool of resources.
 * @author Knud Ronau Larsen
 */
public class OPResource {
    private final int value;

    /**
     * Constructor to give the resource a number.
     * @param value resource number
     */
    public OPResource(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }

    /**
     * Method to print that the resource is in use.
     */
    public void useResource() {
        System.out.println("The resource numbered " + value + " is now being used, " +
                "and will be returned afterwards");
    }

}
