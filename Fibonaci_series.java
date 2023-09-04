import java.util.*;
import java.math.*;
public class Fibonaci_series{
    
    ArrayList<String> ls=new ArrayList<>();
    
    public void fibo(BigInteger a,BigInteger b,int j,int n){

    if(n>2){
    BigInteger c= a.add(b);
    ls.add(c.toString());
    // BigInteger s= b;
    // BigInteger t= c;  
    // if(ls.size()==3 && n>2){
    // fibo(s,t,j,--n);
    // }
   //else if(ls.size()>3 && n>2){
       fibo(new BigInteger(ls.get(ls.size()-2)) ,new BigInteger(ls.get(ls.size()-1)),j,--n);
   }
        
}

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
           
            Fibonaci_series fr=new Fibonaci_series();
            fr.ls.add("0");
            fr.ls.add("0");
            fr.ls.add("1");
            
            int j=0;
            int i=0;
            int test=0;
            
            do{
                System.out.print("ENTER THE NUMBER TO DISPLAY NO.OF.TERMS OF FIBONACCI SERIES:");
                int n=sc.nextInt();
                    // if(fr.ls.size()==3){
                    //     fr.fibo(BigInteger.valueOf(0),BigInteger.valueOf(1),j,j+n);
                    // }
                    // else{
                      fr.fibo(new BigInteger(fr.ls.get(fr.ls.size()-2)) ,new BigInteger(fr.ls.get(fr.ls.size()-1)),j,j+n);
                    // }
                        for(i=j+1;i<j+n+1;i++){
                        System.out.print(fr.ls.get(i)+" ");
                    }
                j=i-1;
                System.out.println();
                System.out.print("CONTINUE?(Y/N):");
                char c= sc.next().charAt(0);
                if(c=='y'){
                    test=1;
                }
                else{
                    test=0;
                }
            }while(test==1);
            System.out.println("************END************");
    }
}