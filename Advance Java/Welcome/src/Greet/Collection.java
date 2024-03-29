package Greet;

import java.util.ArrayList;
import java.util.Iterator;

public class Collection {

	public static void main(String[] args) {
		ArrayList<Integer> values = new ArrayList();
		values.add(8);
		values.add(5);
		values.add(8);
		values.add(9);
		
		Iterator it = values.iterator();
		
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
	
	
	}

}
