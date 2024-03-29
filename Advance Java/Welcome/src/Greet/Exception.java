package Greet;

public class Exception {

	public static void main(String[] args) {
		
		try {
			int i =9/0;
		}
		catch(ArithmeticException  e) {
			System.err.println("Error in calculation");
		}


	}

}
