package Greet;


class Add 
{
	public int add(int i ,int j){
		return i+j;
	}
}

class Sub extends Add
{
	public int sub(int i, int j) {
		return i-j;
	}
}
public class Inheritance {

	public static void main(String[] args) {
		Sub a = new Sub();
		int result1=a.add(8, 9);
		int result2=a.sub(9, 1);
		System.out.println(result1);
		System.out.println(result2);

	}

}
