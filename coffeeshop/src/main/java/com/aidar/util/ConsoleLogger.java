package com.aidar.util;

public class ConsoleLogger {
    private static final Object LOCK = new Object();

    private ConsoleLogger() {}

    public static void log(String message) {
        synchronized (LOCK) {
            System.out.println(message);
        }
    }
}
