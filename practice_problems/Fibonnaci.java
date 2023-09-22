import java.util.*;
public class Fibonnaci{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a =0;
        int b=1;
        //System.out.print(a+" ");
        System.out.print(b+" ");
        int c=0;
        for(int i=2;i<n;i++){
            c=a+b;
            if(c%2!=0){
            System.out.print(c+" ");
            }
            a=b;
            b=c;
        }
    }
}