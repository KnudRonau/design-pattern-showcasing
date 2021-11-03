package com.dt181g.project.producerConsumer;

import java.util.Random;

public class Producer extends Thread{
    private PCResourcePool resourcePool;
    private Random rand;

    public Producer() {
        this.resourcePool = PCResourcePool.INSTANCE;
        this.rand = new Random();
    }

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
