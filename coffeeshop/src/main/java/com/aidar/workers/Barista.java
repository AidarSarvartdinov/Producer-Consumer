package com.aidar.workers;

import java.util.Random;

import com.aidar.model.Order;
import com.aidar.queue.OrderQueue;
import com.aidar.util.ConsoleLogger;

public class Barista implements Runnable {
    private final Random random;
    private final OrderQueue queue;

    public Barista(OrderQueue queue) {
        this.queue = queue;
        this.random = new Random();
    }

    public void run() {
        while (true) {
            Order order = queue.remove();
            try {
                Thread.sleep(random.nextInt(4000) + 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ConsoleLogger.log("Order " + order + " is finished");
        }
    }
}
