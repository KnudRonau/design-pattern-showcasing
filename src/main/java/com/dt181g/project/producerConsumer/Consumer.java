package com.dt181g.project.producerConsumer;

import java.util.Random;

public class Consumer extends Thread{
    private PCResourcePool resourcePool;
    private Random rand;
    private int num;

    public Consumer(int num) {
        this.resourcePool = PCResourcePool.INSTANCE;
        this.rand = new Random();
        this.num = num;
    }

    @Override
    public void run() {
        while(true) {
            try {
                int newResources = rand.nextInt(10) + 1;
                int interval = rand.nextInt(5) + 1;
                resourcePool.removeResources(newResources);
                System.out.println(num + " has consumed " + newResources + " resources");
                sleep( interval * 500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
