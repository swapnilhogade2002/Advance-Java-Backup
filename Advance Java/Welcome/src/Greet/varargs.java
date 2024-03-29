package Greet;

public class varargs {
//	 int add(int i,int j) {
//		 return i+j;
//	 }
	int add(int... n) {
		int sum = 0;
		for (int i : n) {
			sum = sum + i;
		}
		return sum;

	}

	public static void main(String[] args) {
		varargs obj = new varargs();
		System.out.println(obj.add(5, 4, 5));

	}

}
