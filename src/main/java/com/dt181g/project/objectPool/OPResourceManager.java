package com.dt181g.project.objectPool;

import java.util.Deque;
import java.util.LinkedList;

public class OPResourceManager {
    public static final OPResourceManager INSTANCE = new OPResourceManager();
    private final Deque<OPResource> resources = new LinkedList<>();

    private OPResourceManager() {
        for(int i = 1; i <= 10; i++) {
            resources.add(new OPResource(i));
        }
    }

    public OPResource getResource() {
        return resources.pollFirst();
    }

    public boolean hasAnotherResource() {
        return !resources.isEmpty();
    }

    public void returnResource(OPResource resource) {
        resources.add(resource);
    }
}
