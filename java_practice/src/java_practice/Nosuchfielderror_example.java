package java_practice;

//class MyError extends IncompatibleClassChangeError{
//  MyError(String s){
//      super(s);
//  }
//}

public class Nosuchfielderror_example {
 public static void main(String[] args) {
     try{
      // m.c =10;
       throw new NoSuchFieldError("error");
     }
     catch (Error e) {
        System.out.println("rerror");
     }
 }
}
