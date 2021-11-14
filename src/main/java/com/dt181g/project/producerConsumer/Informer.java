package com.dt181g.project.producerConsumer;

/**
 * Thread class responsible for printing the current number of resources in the pool every 5 seconds.
 * @author Knud Ronau Larsen
 */
public class Informer extends Thread{
    private PCResourcePool resourcePool;
    private final int delay = 5000;

    /**
     * Constructor instantiating the ResourcePool
     */
    public Informer() {
        this.resourcePool = PCResourcePool.INSTANCE;
    }

    /**
     * Runs in a loop once the Thread is started.
     */
    @Override
    public void run() {
        while(true) {
            try{
                System.out.println("There are currently " + resourcePool.getResourceAmount() + " resources" +
                        " in the resource pool");
                sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
