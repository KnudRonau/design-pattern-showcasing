package com.dt181g.project;

import com.dt181g.project.objectPool.ObjectPoolThread;
import com.dt181g.project.producerConsumer.Consumer;
import com.dt181g.project.producerConsumer.Informer;
import com.dt181g.project.producerConsumer.Producer;

public class Engine {
    public Engine() {
    }

    public void start() {
        startObjectPool();
        startProducerConsumer();
    }

    private void startObjectPool() {
        Thread opThread = new ObjectPoolThread();
        opThread.start();
    }

    private void startProducerConsumer() {
        Thread producerThread = new Producer();
        Thread consumerThread1 = new Consumer(1);
        Thread consumerThread2 = new Consumer(2);
        Thread informerThread = new Informer();

        producerThread.start();
        consumerThread1.start();
        consumerThread2.start();
        informerThread.start();

    }

}
