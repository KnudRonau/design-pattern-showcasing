package com.dt181g.project.producerConsumer;

public class Informer extends Thread{
    private PCResourcePool resourcePool;
    private final int delay = 5000;

    public Informer() {
        this.resourcePool = PCResourcePool.INSTANCE;
    }

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
