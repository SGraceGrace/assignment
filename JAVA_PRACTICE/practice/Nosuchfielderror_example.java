package practice;

class MyError extends IncompatibleClassChangeError{
    MyError(String s){
        super(s);
    }
}

class My_error{
    int a;
    int b;
}

public class Nosuchfielderror_example {
    public static void main(String[] args) {
        My_error m = new My_error();

        try{
          m.c =10;
          throw new MyError("error");
        }
        catch (MyError e) {
           System.out.println(e.getMessage());
        }
    }
}
