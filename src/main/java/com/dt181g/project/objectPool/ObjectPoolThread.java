package com.dt181g.project.objectPool;

/**
 * Class extending Thread responsible for retrieving resources, "using" them, and returning them after a delay.
 * @author Knud Ronau Larsen
 */
public class ObjectPoolThread extends Thread {
    private final int delay = 6000;

    /**
     * Runs in a loop once the Thread is started.
     */
    @Override
    public void run() {
        OPResourceManager manager = OPResourceManager.INSTANCE;

        // Will never be false as the resources are always returned after usage
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
