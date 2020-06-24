package Lesson3;

import static java.lang.Thread.sleep;

public class PingPong {
    boolean isPong = false;

    void playGame(int amountOfParties){
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < amountOfParties; i++) {
                    ping();
                    i++;
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < amountOfParties; i++) {
                    pong();
                    i++;
                }
            }
        }).start();
    }

    private synchronized void pong(){
        while (!isPong) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Pong");
        isPong = false;
        notify();
    }

    private synchronized void ping(){
        while (isPong) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Ping");
        isPong = true;
        notify();
    }
}
