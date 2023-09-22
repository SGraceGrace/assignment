import java.util.*;
import java.math.*;

public class Fibonacci_recursion{

public static void fibo(BigInteger a,BigInteger b,int n){
if(n>1){
    
    BigInteger c= a.add(b);
    System.out.print(c+" ");
    BigInteger s= b;
    BigInteger t= c;
    fibo(s,t,--n);
}
}
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        BigInteger a=BigInteger.valueOf(0);
        BigInteger b=BigInteger.valueOf(1);
        System.out.print(a+" ");
        System.out.print(b+" ");
        fibo(a,b,n);
    }
}