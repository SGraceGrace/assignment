import java.util.*;
import java.math.*;

public class Fiboreverse{
ArrayList<String> ls=new ArrayList<>();

public void fibo(BigInteger a,BigInteger b,int n){
if(n>1){
    
    BigInteger c= a.add(b);
    ls.add(c.toString());
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

        Fiborecur fr=new Fiborecur();
        fr.fibo(a,b,n);
        for(int i=fr.ls.size()-1;i>=0;i--){
        System.out.print(fr.ls.get(i)+" ");
    }
        System.out.print(b+" ");
        System.out.print(a+" ");
    }
}