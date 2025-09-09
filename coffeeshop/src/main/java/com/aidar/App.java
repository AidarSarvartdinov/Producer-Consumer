package com.aidar;

import com.aidar.queue.OrderQueue;
import com.aidar.workers.Barista;
import com.aidar.workers.Waiter;

public class App 
{
    public static void main( String[] args )
    {
        OrderQueue queue = new OrderQueue(5);
        Thread waiter1 = new Thread(new Waiter(queue));
        Thread waiter2 = new Thread(new Waiter(queue));
        Thread waiter3 = new Thread(new Waiter(queue));
        Thread barista1 = new Thread(new Barista(queue));
        Thread barista2 = new Thread(new Barista(queue));

        try {
            waiter1.start();
            waiter2.start();
            waiter3.start();
            barista1.start();
            barista2.start();

            waiter1.join();
            waiter2.join();
            waiter3.join();
            barista1.join();
            barista2.join();
        } catch (Exception e) {
            waiter1.interrupt();
            waiter2.interrupt();
            waiter3.interrupt();
            barista1.interrupt();
            barista2.interrupt();
        }
    }
}
