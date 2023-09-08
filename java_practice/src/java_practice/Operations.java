package java_practice;

import java.util.*;

interface calculator {
    double add(double a , double b);
    double subtract(double a , double b);
    double multiply(double a , double b);
    double division(double a , double b);
}

class Math_operation implements calculator{
    public double add(double a , double b){
         return a+b;
    }
    public double subtract(double a , double b){
        return a>b?a-b : b-a;
    }
    public double multiply(double a , double b){
       return a*b;
    }
    public double division(double a , double b){
      return a>b?a/b : b/a;
    }
}

public class Operations{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        calculator c = new Math_operation();
        
        System.out.println("1.ADDITION 2.SUBTRACTION 3.MULTIPLICATION 4.DIVISION");
        System.out.println("ENTER CHOICE : ");
        int choice = sc.nextInt();

        switch(choice){

            case 1 : 
                    System.out.println("ENTER TWO NUMBERS FOR ADDITION :");
                    double a = sc.nextDouble();
                    double b = sc.nextDouble();
                    System.out.println( c.add(a,b));
                    break;
            case 2 :
                    System.out.println("ENTER TWO NUMBERS FOR SUBTRACTION :");
                    double i = sc.nextDouble();
                    double d = sc.nextDouble();
                    System.out.println(c.subtract(i,d));
                    break;
            case 3 :
                    System.out.println("ENTER TWO NUMBERS FOR MULTIPLICATION :");
                    double e = sc.nextDouble();
                    double f = sc.nextDouble();
                    System.out.println( c.multiply(e,f));
                    break;
            case 4 :
                    System.out.println("ENTER TWO NUMBERS FOR DIVISION :");
                    double g = sc.nextDouble();
                    double h = sc.nextDouble();
                    System.out.println( c.division(g,h));
                    break;
            default : System.out.println("INVALID");       
        }
    }
}
