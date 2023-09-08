package java_practice;

public class Main1 {
    public static void main(String[] args) {
        Return_this r = new Return_this();
        System.out.println(r.return_this());
        System.out.println(r);
        System.out.println(System.identityHashCode(r));
    }
}
