package com.dt181g.project.producerConsumer;

import java.util.Random;

public class Consumer extends Thread{
    private PCResourcePool resourcePool;
    private Random rand;

    public Consumer() {
        this.resourcePool = PCResourcePool.INSTANCE;
        this.rand = new Random();
    }

    @Override
    public void run() {
        while(true) {
            try {
                int newResources = rand.nextInt(10);
                int interval = rand.nextInt(5) + 1;
                resourcePool.removeResources(newResources);
                sleep( interval * 500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
