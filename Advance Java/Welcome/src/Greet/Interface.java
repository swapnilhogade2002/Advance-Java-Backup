package Greet;

interface car{
	 static void show() {
		System.out.println("static method can be show in interface");
	}
}

public class Interface {

	public static void main(String[] args) {
		car.show();
	}

}
