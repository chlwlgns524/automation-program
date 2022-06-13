package com.example.bitcoinproject.utils;

public class Timer {

    public static final int ONE_SECOND = 1000;

    public static void waitFor(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
