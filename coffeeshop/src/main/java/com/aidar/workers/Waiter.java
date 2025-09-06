package com.aidar.workers;

import java.util.Random;

import com.aidar.model.Order;
import com.aidar.queue.OrderQueue;
import com.aidar.service.OrderGenerator;

public class Waiter implements Runnable {
    private final OrderQueue queue;
    private final OrderGenerator orderGenerator;
    private final Random random;

    public Waiter(OrderQueue queue) {
        this.queue = queue;
        this.orderGenerator = new OrderGenerator();
        this.random = new Random();
    }

    public void run() {
        Order order = orderGenerator.generateOrder();
        queue.add(order);
        System.out.println("Added new order: " + order);
        Thread.sleep(random.nextInt(4000) + 1000);
    }
}
