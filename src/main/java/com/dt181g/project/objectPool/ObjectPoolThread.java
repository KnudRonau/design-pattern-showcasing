package com.dt181g.project.objectPool;

public class ObjectPoolThread extends Thread {
    private final int delay = 6000;

    @Override public void run() {
        OPResourceManager manager = OPResourceManager.INSTANCE;

        while(manager.hasAnotherResource()) {
            OPResource resource = manager.getResource();
            resource.useResource();
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            manager.returnResource(resource);
        }
    }
}
