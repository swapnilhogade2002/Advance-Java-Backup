package Greet;
import java.io.*;
import java.lang.Thread;

class Hii implements Runnable {
	public void run() {
		try {
			for (int i = 0; i < 5; i++) {

				// it will sleep the main thread for 1 sec
				// ,each time the for loop runs
				Thread.sleep(1000);

				// printing the value of the variable
				System.out.println("hi");
			}
		} catch (InterruptedException e) {

			// catching the exception
			System.out.println(e);
		}
	}

}

class Helloo implements Runnable {
	public void run() {
		try {
			for (int i = 0; i < 5; i++) {

				// it will sleep the main thread for 1 sec
				// ,each time the for loop runs
				Thread.sleep(1000);

				// printing the value of the variable
				System.out.println("Hello");
			}
		} catch (InterruptedException e) {

			// catching the exception
			System.out.println(e);
		}
	}

}

public class ThreadInterface {
	public static void main(String[] args) {
		Runnable a = new Hii();
		Thread t1 = new Thread(a);
		t1.start();

		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
		}
		
		Runnable b = new Helloo();
		Thread t2 = new Thread(b);
		t2.start();
	}
}
