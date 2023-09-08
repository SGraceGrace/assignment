package java_practice;

import java.util.*;

class Myexception extends Exception{
    Myexception(String s){
        super(s);
    }
}
public class Exception_handle{
    
   static void check_vote(int age) throws Myexception{
        if(age<18){
                throw new Myexception("BELOW 18 NOT ELIGIBLE FOR VOTE");
            }
            else{
                System.out.println("ELIGIBLE FOR VOTE");
            }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        
        int age = sc.nextInt();

        try {
            check_vote(age);
        } 
        catch(Myexception e){
            System.out.println(e.getMessage());
        } 
    }
}



