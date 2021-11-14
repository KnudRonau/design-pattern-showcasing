package com.dt181g.project.producerConsumer;

import java.util.Random;

/**
 * Thread class responsible for calling upon the Resource pool to remove a randomized number of resources at a
 * randomized interval.
 * @author Knud Ronau Larsen
 */
public class Consumer extends Thread{
    private PCResourcePool resourcePool;
    private Random rand;
    private int num;

    /**
     * Constructor to instantiate the ResourcePool and Random object, and give the consumer a number.
     * @param num number given to the consumer
     */
    public Consumer(int num) {
        this.resourcePool = PCResourcePool.INSTANCE;
        this.rand = new Random();
        this.num = num;
    }

    /**
     * Runs in a loop once the Thread is started.
     */
    @Override
    public void run() {
        while(true) {
            try {
                int newResources = rand.nextInt(7);
                int interval = rand.nextInt(5) + 1;
                resourcePool.removeResources(newResources);
//                System.out.println(num + " has consumed " + newResources + " resources");
                sleep( interval * 500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
