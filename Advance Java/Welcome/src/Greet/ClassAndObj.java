package Greet;

public class ClassAndObj {
	int num1,num2;
	
	public void perform() {
		int result= num1+num2;
		System.out.println(result);
	}
	

	public static void main(String[] args) {
		ClassAndObj obj = new ClassAndObj();
		obj.num1=8;
		obj.num2=20;
		obj.perform();
	}

}
