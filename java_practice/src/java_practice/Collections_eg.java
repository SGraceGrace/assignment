package java_practice;

import java.util.ArrayList;
import java.util.TreeSet;

public class Collections_eg {
public static void main(String[] args) {
	ArrayList a = new ArrayList();
	a.add(10);
	a.add("string");
	System.out.println(a.get(0));
	
	TreeSet t = new TreeSet();
	t.add("string");
	t.add(10);
	System.out.println(t);
	}
}
