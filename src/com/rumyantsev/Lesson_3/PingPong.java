package com.rumyantsev.Lesson_3;

public class PingPong {
    private final Object mon = new Object();
    private volatile String currentLetter = "ping";

    public static void main(String[] args) {
        PingPong w = new PingPong();
        new Thread(w::ping).start();
        new Thread(w::pong).start();
    }

    public void ping() {
        synchronized (mon) {
            try {
                for (int i = 0; i < 3; i++) {
                    while (!currentLetter.equals("ping"))
                        mon.wait();
                    System.out.println("ping");
                    currentLetter = "pong";
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void pong() {
        synchronized (mon) {
            try {
                for (int i = 0; i < 3; i++) {
                    while (!currentLetter.equals("pong"))
                        mon.wait();
                    System.out.println("pong");
                    currentLetter = "ping";
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
