package practice;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


interface cards{
    int  my_hit(ArrayList<Integer> a);
    int dealer_hit(ArrayList<Integer> a);
    void my_stay(ArrayList<Integer> a,int total1,int total2);
    void dealer_stay(int total1,int total2);
}
class Cards_class implements cards{

    public int my_hit(ArrayList<Integer> a){
      int x = a.get(new Random().nextInt(a.size()));
      return x;
     }

     public void my_stay(ArrayList<Integer> a,int total1,int total2){
        
        if(total2<17 && total2<22){

            int f = dealer_hit(a);
            total2=total2+f;

            System.out.println("Now Dealer's total :" +total2);

            my_stay(a,total1,total2);
        }
        else{
            dealer_stay(total1,total2);
        }
     }

     public int dealer_hit(ArrayList<Integer> a){
       
        int x = a.get(new Random().nextInt(a.size()));

        System.out.println();
        System.out.println("Dealer drew :"+x);

        return x;
     }

     public void dealer_stay(int total1,int total2){
            if(total2 >21){
                System.out.println();
                System.out.println("DEALER BUST");
                System.out.println();
                System.out.println("************YOU WON************");
            }
            else{
                System.out.println();
                System.out.println("Dealer stay......");
                Blackjack_game.result(total1,total2);
            }
     }
}

public class Blackjack_game {

    static int total1=0;
    static int total2=0;   

    // static void remove_val(ArrayList<Integer> a , int b){
    //     if(a.get(b)){
    //         a.remove(b);
    //     }
    // }

    public static void result(int total1,int total2){
           if(total1>total2){
           System.out.println();
           System.out.println("Your total : "+total1);
           System.out.println("Dealer's total : "+total2);
           System.out.println();
           System.out.println("************YOU WON************");
            }
            else if(total2>total1){
            System.out.println();
            System.out.println("Dealer total : "+total2);
            System.out.println("Your total : "+total1);
            System.out.println();
            System.out.println("************DEALER WON************");
        }
         else{
            System.out.println();
           System.out.println("Your total : "+total1);
           System.out.println("Dealer's total : "+total2);
           System.out.println();
           System.out.println("************DRAW!!!************");
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        a.add(6);
        a.add(7);
        a.add(8);
        a.add(9);
        a.add(10);
        a.add(10);
        a.add(10);
        a.add(10);
        
        Cards_class c = new Cards_class();

        System.out.println();
        System.out.println("************WELCOME************");
        System.out.println();
       
        //  @Override
        // public int nextInt(int bound) {
        //     return this.generator.nextInt(bound);
        // }

         int x=a.get(new Random().nextInt(a.size()));
         int y=a.get(new Random().nextInt(a.size()));

         total1=x+y;

         System.out.println("You have " +x+ " and " +y);
         System.out.println("Your total is "+total1);
         System.out.println();

         int z = a.get(new Random().nextInt(a.size()));

         total2=z;

         System.out.println("Dealer have " +z+ " and one hidden card");
         System.out.println("His total is hidden ......");
         System.out.println();

         String str="";

        do{
             System.out.println("hit or stay ?");
             str = sc.next();

             if(str.equals("hit")){
    
                    int n = c.my_hit(a);
                    total1 = total1 + n;

                    System.out.println();
                    System.out.println("You drew " +n);
                    System.out.println("Your total is "+total1);
                    System.out.println();

                    if(total1 >21){
                        System.out.println("YOU BUST :(");
                        System.out.println();
                        System.out.println("************DEALER WON************");
                        break;
                    }

                     //remove_val(a, n);
                }

        }while(str.equals("hit"));

      
           if(str.equals("stay")){

             int t=a.get(new Random().nextInt(a.size()));

             System.out.println();
             System.out.println("You choose to stay....");
             System.out.println("Dealer's turn...");
             System.out.println();
             System.out.println("Dealer hidden card : " + t);

             total2=total2+t;

             System.out.println("Dealer total : " + total2);

             c.my_stay(a,total1,total2);
            }
    }
}
