package Greet;
import java.lang.Thread;

class Counter {
    int count;

    public synchronized void increment() {
        count++;
    }
}

public class Symchronization {

    public static void main(String[] args) {
        Counter c = new Counter();

        Thread t = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i <= 1000; i++) {
                    c.increment();
                }
            }
        });
        
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i <= 1000; i++) {
                    c.increment();
                }
            }
        });

        t.start(); // Start the thread
        t1.start(); // Start the thread

        try {
            t.join(); // Wait for the thread to complete
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        try {
            t1.join(); // Wait for the thread to complete
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(c.count); // Print the updated count
    }
}
