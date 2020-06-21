package com.lesnoytishka;

public class PingPongThreads {
    private boolean isLastRecord = false;

    private final Thread pingThread = new Thread(() -> initThread("ping", false));
    private final Thread pongThread = new Thread(() -> initThread("pong", true));

    public static void main(String[] args) {
        PingPongThreads pingPongThreads = new PingPongThreads();
        pingPongThreads.pingThread.start();
        pingPongThreads.pongThread.start();
    }

    private void initThread(String text, boolean isMustToBeLast) {
        while (true) {
            if (isLastRecord == isMustToBeLast) {
                displayText(text);
                isLastRecord = !isLastRecord;
            }
        }
    }

    private synchronized void displayText(String text) {
            System.out.println(text);
    }

}