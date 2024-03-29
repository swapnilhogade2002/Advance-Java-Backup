package Greet;
import java.io.*;
import java.lang.Thread;

class Hi extends Thread{
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

class Hello extends Thread{
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

public class ThreadSleep {

	public static void main(String[] args) {
	Hi a = new Hi();
	a.start();
	
	try{Thread.sleep(20);} catch(InterruptedException e){}
	Hello b = new Hello();
	b.start();
	}
}
