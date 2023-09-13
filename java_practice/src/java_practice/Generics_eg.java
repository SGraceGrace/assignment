package java_practice;

class Test<T>{
	T a;
	
	void setval(T val) {
		this.a = val;
	}
	T getval() {
		return a;
	}
	
	public  <E> E method_eg(E val){
		return val;
	}
}
public class Generics_eg {
public static void main(String[] args) {
	
	Test<Integer> t = new Test<>();
	t.setval(10);
	
	System.out.println(t.getval());
	System.out.println(t.method_eg("string"));
}
}
