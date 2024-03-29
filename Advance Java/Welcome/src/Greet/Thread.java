package Greet;

class A extends Thread{
	void run() {
		for(int i=0;i<=4;i++)
		{
			System.out.println("Hi");
			try{
				Thread.sleep(1000);
			   }
			catch(InterruptedException  e) {
				
			}
		}

	}
}

class B extends Thread{
	void run() {
		for(int i=0;i<=4;i++)
		{
			System.out.println("Bye");
			try {
				Thread.sleep(1000);
			}
			catch(InterruptedException  e) {
				
			}
		
		}

	}
}
public class Thread {

	public Thread(Runnable runnable) {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		A obj1 =new A();
		B obj2 = new B();
		obj1.run();
		obj2.run();
	}


}
