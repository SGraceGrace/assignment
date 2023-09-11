package java_practice;

class Test<T>{
	T a;
}
public class Generics_eg {
public static void main(String[] args) {
	Test<Integer> t = new Test<>();
	t.a = 10;
	System.out.println(t.a);
}
}
