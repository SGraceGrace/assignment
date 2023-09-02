import java.util.*;
public class Fiborecur{
    public static BigInteger fibo(BigInteger a){
        if(a.equals(BigInteger(0))){
            return 0;
        }
        else if(a.equals(BigInteger(1)) || a.equals(BigInteger(2))){
            return 1;
        }
        else{
            BigInteger b=fibo(a-1);
            BigInteger c=fibo(a-2);
            return b.add(c);
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            System.out.print(fibo(i)+" ");
        }
    }
}