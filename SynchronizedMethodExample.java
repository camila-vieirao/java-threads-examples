package javathreadsexamples;

class Kitchen {
    public synchronized void useKnife() {
        System.out.println(Thread.currentThread().getName() + " is using the kitchen knife.");
        try {
            Thread.sleep(2000); // Simulate time taken to use the knife
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " is done using the kitchen knife.");
    }
}

public class SynchronizedMethodExample {
    public static void main(String[] args) {
        Kitchen kitchen = new Kitchen();

        Thread chef1 = new Thread(() -> kitchen.useKnife(), "Chef 1");
        Thread chef2 = new Thread(() -> kitchen.useKnife(), "Chef 2");

        chef1.start();
        chef2.start();
    }
}