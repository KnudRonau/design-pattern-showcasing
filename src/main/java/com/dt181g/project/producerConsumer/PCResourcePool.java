package com.dt181g.project.producerConsumer;

import java.util.LinkedList;
import java.util.Queue;

public class PCResourcePool {
    public static final PCResourcePool INSTANCE = new PCResourcePool();
    private final Queue<PCResource> resources = new LinkedList<>();

    private PCResourcePool() {
        for(int i = 1; i <= 100; i++) {
            resources.add(new PCResource());
        }
    }

    public synchronized void addResources(int amount) {
        for(int i = 1; i <= amount; i++) {
            resources.add(new PCResource());
        }
//        System.out.println(amount + " Resources have been added. " + getResourceAmount() + " are remaining");
    }

    public synchronized void removeResources(int amount) {
        for(int i = 1; i <= amount; i++) {
            resources.poll();
        }
//        System.out.println(amount + " Resources have been removed. " + getResourceAmount() + " are remaining");
    }

    public synchronized int getResourceAmount() {
        return resources.size();
    }
}
