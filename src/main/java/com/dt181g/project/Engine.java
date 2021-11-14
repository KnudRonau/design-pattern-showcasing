package com.dt181g.project;

import com.dt181g.project.objectPool.ObjectPoolThread;
import com.dt181g.project.producerConsumer.Consumer;
import com.dt181g.project.producerConsumer.Informer;
import com.dt181g.project.producerConsumer.Producer;

/**
 * Entity responsible for starting Threads relating to Producer Consumer pattern and Object Pool.
 * @author Knud Ronau Larsen
 */
public class Engine {
    public Engine() {
    }

    /**
     * public method calling the private methods to start threads.
     */
    public void start() {
        startObjectPool();
        startProducerConsumer();
    }

    /**
     * Method to create and start Objet Pool Thread.
     */
    private void startObjectPool() {
        Thread opThread = new ObjectPoolThread();
        opThread.start();
    }

    /**
     * Method to create and start Producer, Consumer and Informer threads.
     */
    private void startProducerConsumer() {
        Thread producerThread = new Producer();
        Thread consumerThread1 = new Consumer(1);
        Thread consumerThread2 = new Consumer(2);
        Thread consumerThread3 = new Consumer(3);
        Thread informerThread = new Informer();

        producerThread.start();
        consumerThread1.start();
        consumerThread2.start();
        consumerThread3.start();
        informerThread.start();

    }

}
