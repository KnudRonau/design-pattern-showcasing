package com.dt181g.project.producerConsumer;

import java.util.Random;

/**
 * Thread class responsible for calling upon the Resource pool to add a randomized number of new resources at a
 * randomized interval.
 * @author Knud Ronau Larsen
 */
public class Producer extends Thread{
    private PCResourcePool resourcePool;
    private Random rand;

    /**
     * Constructor to instantiate the ResourcePool and Random object.
     */
    public Producer() {
        this.resourcePool = PCResourcePool.INSTANCE;
        this.rand = new Random();
    }

    /**
     * Runs in a loop once the Thread is started.
     */
    @Override
    public void run() {
        while(true) {
            try {
                int newResources = rand.nextInt(20) + 1;
                int interval = rand.nextInt(5) + 1;
                resourcePool.addResources(newResources);
                sleep(interval * 500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
