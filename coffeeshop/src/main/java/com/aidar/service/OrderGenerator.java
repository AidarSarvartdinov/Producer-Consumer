package com.aidar.service;

import java.util.Random;

import com.aidar.model.Order;

public class OrderGenerator {
    private final Random random;
    private static final String[] drinks = { "espresso", "americano", "latte", "cappuccino", "mocha" };

    public OrderGenerator() {
        this.random = new Random();
    }

    public Order generateOrder() {
        String drinkName = drinks[random.nextInt(drinks.length)];
        return new Order(drinkName);
    }

}
