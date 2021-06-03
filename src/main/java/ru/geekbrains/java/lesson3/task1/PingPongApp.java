package ru.geekbrains.java.lesson3.task1;

public class PingPongApp {
    private String currentState = "ping";

    public static void main(String[] args) {
        PingPongApp pingPongApp = new PingPongApp();

        new Thread(() -> {
            while (true) {
                pingPongApp.printPing();
            }
        }).start();

        new Thread(() -> {
            while (true) {
                pingPongApp.printPong();
            }
        }).start();
    }

    public synchronized void printPing() {
        while (currentState.equals("pong")) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("ping");
        currentState = "pong";
        this.notifyAll();

    }

    public synchronized void printPong() {
        while (currentState.equals("ping")) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("pong");
        currentState = "ping";
        this.notifyAll();
    }
}
