package com.dt181g.project.producerConsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Singleton entity responsible for providing access to a pool of resources.
 * @author Knud Ronau Larsen
 */
public class PCResourcePool {
    public static final PCResourcePool INSTANCE = new PCResourcePool();
    private final BlockingQueue<PCResource> resources = new ArrayBlockingQueue<>(200, true);

    /**
     * Constructor storing 100 resources in the resources BlockingQueue.
     */
    private PCResourcePool() {
        for(int i = 1; i <= 100; i++) {
            resources.add(new PCResource());
        }
    }

    /**
     * Method to add an amount of resources to the resource pool if sufficient capacity is available.
     * @param amount number of resources to add
     */
    public synchronized void addResources(int amount) {
        for(int i = 1; i <= amount; i++) {
            resources.offer(new PCResource());
        }
    }

    /**
     * Method to remove an amount of resources from the resource pool.
     * @param amount amount of resources to remove
     */
    public synchronized void removeResources(int amount) {
        for(int i = 1; i <= amount; i++) {
            resources.poll();
        }
    }

    /**
     * Method to return the amount of resources in the pool
     * @return number of resources
     */
    public synchronized int getResourceAmount() {
        return resources.size();
    }
}
