package javathreadsexamples;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Kitchen {
    private final Lock lock = new ReentrantLock();

    public void useKnife() {
        lock.lock(); // Acquire the lock
        try {
            System.out.println(Thread.currentThread().getName() + " is using the kitchen knife.");
            try {
                Thread.sleep(2000); // Simulate time taken to use the knife
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " is done using the kitchen knife.");
        } finally {
            lock.unlock(); // Always unlock in a finally block
        }
    }
}

public class LockExample {
    public static void main(String[] args) {
        Kitchen kitchen = new Kitchen();

        Thread chef1 = new Thread(() -> kitchen.useKnife(), "Chef 1");
        Thread chef2 = new Thread(() -> kitchen.useKnife(), "Chef 2");

        chef1.start();
        chef2.start();
    }
}