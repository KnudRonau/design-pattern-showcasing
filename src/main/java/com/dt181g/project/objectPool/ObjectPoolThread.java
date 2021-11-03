package com.dt181g.project.objectPool;

public class ObjectPoolThread extends Thread {
    private final int delay = 4000;

    @Override public void run() {
        OPResourceManager manager = OPResourceManager.INSTANCE;

        while(manager.hasAnotherResource()) {
            OPResource resource = manager.getResource();
            System.out.println("The resource numbered " + resource + " is now being used, " +
                    "and will be returned afterwards");
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            manager.returnResource(resource);
        }
    }
}
