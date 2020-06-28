package Lesson3;

import static java.lang.Thread.sleep;

public class CounterCheck {
    public static void main(String[] args) {
        int finishCount = 30;
        int threadAmount = 5;

        Counter counter = new Counter();

        for (int i = 0; i < threadAmount; i++) {
            int threadNumber = i + 1;
            new Thread(() -> {
                while (counter.currentValue() < finishCount) {
                    System.out.println("thread " + threadNumber + ":" + counter.increment());
                    try {
                        sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }).start();
        }

    }
}
