package com.aidar.model;

public class Order {
    private final String drinkName;
    private final int orderNumber;
    private static int totalOrders;

    public Order(String drinkName) {
        this.drinkName = drinkName;
        synchronized (this) {
            totalOrders++;
            this.orderNumber= totalOrders;
        }
    }

    @Override
    public String toString() {
        return drinkName + " #" + orderNumber;
    }

}


