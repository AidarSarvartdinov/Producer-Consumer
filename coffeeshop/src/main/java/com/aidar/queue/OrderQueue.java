package com.aidar.queue;

import java.util.LinkedList;
import java.util.Queue;

import com.aidar.model.Order;

public class OrderQueue {
    private Queue<Order> queue;
    private int capacity;

    public OrderQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new LinkedList<>();
    }

    public boolean add(Order order) {
        synchronized (queue) {
            while (queue.size() == capacity) {
                try {
                    queue.wait();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
    
            queue.add(order);
            queue.notifyAll();
            return true;
        }
    }

    public Order remove() {
        synchronized (queue) {
            while (queue.size() == 0) {
                try {
                    queue.wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
    
            Order order = queue.poll();
            queue.notifyAll();
            return order;
        }
    }

}
