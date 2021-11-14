package com.dt181g.project.producerConsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class PCResourcePool {
    public static final PCResourcePool INSTANCE = new PCResourcePool();
    private final BlockingQueue<PCResource> resources = new ArrayBlockingQueue<>(200, true);

    private PCResourcePool() {
        for(int i = 1; i <= 100; i++) {
            resources.add(new PCResource());
        }
    }

    public synchronized void addResources(int amount) {
        for(int i = 1; i <= amount; i++) {
            resources.offer(new PCResource());
        }
    }

    public synchronized void removeResources(int amount) {
        for(int i = 1; i <= amount; i++) {
            resources.poll();
        }
    }

    public synchronized int getResourceAmount() {
        return resources.size();
    }
}
