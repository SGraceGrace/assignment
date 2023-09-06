package practice;
import java.util.*;

class ArithmeticException extends Exception{
    
    ArithmeticException(String s){
          super(s);
    }
}

interface Myinterface{
    int divide(int a,int b) throws ArithmeticException;
}

class Get_exception implements Myinterface {
    
    public int divide(int a,int b)  throws ArithmeticException{
            if(a==0 || b==0){
                throw new ArithmeticException("EXCEPTION");
            }
            return a>b ? a/b : b/a;
        }
}
public class Exception_eg {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        Get_exception g = new Get_exception();
        
        try{
             int a = sc.nextInt();
             int b = sc.nextInt();
             System.out.println(g.divide(a,b));
        }
        catch(ArithmeticException e){
           System.out.println( e.getMessage() );
        }
    }
}