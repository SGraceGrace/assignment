package java_practice;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


interface cards1{
    int  my_hit(int size);
    int dealer_hit(ArrayList<String> a , int size);
    void my_stay(int total1,int total2, ArrayList<String> a,int game_number,int size);
    void dealer_stay(int total1,int total2,int game_number);
    void result(int total1,int total2);
}
class Cards_class1 implements cards1{

    // my_hit method performs when player choose to hit ...this method randomly generate card for player...

    public int my_hit(int size){                  
      int x = new Random().nextInt(0,size);
      return x;
     }

        /*  my_stay method performs when player choose to stay ...after player give stay......it's dealer's turn .....
         checks dealer's total , if <17 dealer will hit ...if dealer's total >game_number dealer bust....*/

     public void my_stay(int total1,int total2, ArrayList<String> a,int game_number,int size){
        
        if(total2<game_number-4 && total2<game_number){

            int f = dealer_hit(a , size);
            total2=total2+Black_jack_game_number.check(a.get(f),"stay");

            System.out.println("Now Dealer's total :" +total2);

            my_stay(total1,total2,a,game_number,size);     //recursion until dealer's total exceeds 17...
        }
        else{
            dealer_stay(total1,total2,game_number);     //if dealer's total > 17 ...dealer stay
        }
     }

     // dealer_hit method will randomly generate cards for dealer... 

     public int dealer_hit(ArrayList<String> a , int size){
       
        int x = new Random().nextInt(0,size);

        System.out.println();
        System.out.println("Dealer drew :"+a.get(x));

        return x;
     }

    // dealer_stay method checks dealer's total exceeds game_number...if exceeds dealer bust

     public void dealer_stay(int total1,int total2,int game_number){
            if(total2 > game_number){
                System.out.println();
                System.out.println("DEALER BUST");
                System.out.println();
                System.out.println("************YOU WON************");
            }
            else{
                System.out.println();
                System.out.println("Dealer stay......");
                result(total1,total2);    
            }
     }

     // result method will compare player's total and dealer's total ....the higher will win the match..

    public void result(int total1,int total2){
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
}

public class Black_jack_game_number {

    static int total1=0;     //player's total
    static int total2=0;     //dealer's total
    static int game_number=0;
     static int size=51;

    static void remove_val(ArrayList<String> a , int b){
            a.remove(b);
            size--;
    }

   public static int check(String str,String s){
        if(str.contains("KING") || str.contains("QUEEN") || str.contains("JOKER")){
           return 10;
        }
        else if(str.contains("ACE")){
            if(total1+11> game_number && s.equals("hit"))
             return 1;
             if(total2+11> game_number && s.equals("stay"))
             return 1;
        }
        else{
        str=str.replaceAll("[a-zA-Z ]","");
        return Integer.parseInt(str);
        }
        return 11;
    }

    public static void main(String[] args) {
    	
        Scanner sc=new Scanner(System.in);

        ArrayList<String> a = new ArrayList<>();
        
        a.add("Spade ACE");
        a.add("Spade 2");
        a.add("Spade 3");
        a.add("Spade 4");
        a.add("Spade 5");
        a.add("Spade 6");
        a.add("Spade 7");
        a.add("Spade 8");
        a.add("Spade 9");
        a.add("Spade 10");
         a.add("Spade KING");
        a.add("Spade QUEEN");
        a.add("Spade JOKER");
        
        a.add("Diamond ACE");
        a.add("Diamond 2");
        a.add("Diamond 3");
        a.add("Diamond 4");
        a.add("Diamond 5");
        a.add("Diamond 6");
        a.add("Diamond 7");
        a.add("Diamond 8");
        a.add("Diamond 9");
        a.add("Diamond 10");
        a.add("Diamond KING");
        a.add("Diamond QUEEN");
        a.add("Diamond JOKER");
        
        a.add("Club ACE");
        a.add("Club 2");
        a.add("Club 3");
        a.add("Club 4");
        a.add("Club 5");
        a.add("Club 6");
        a.add("Club 7");
        a.add("Club 8");
        a.add("Club 9");
        a.add("Club 10");
        a.add("Club KING");
        a.add("Club QUEEN");
        a.add("Club JOKER");
        
        a.add("Heart ACE");
        a.add("Heart 2");
        a.add("Heart 3");
        a.add("Heart 4");
        a.add("Heart 5");
        a.add("Heart 6");
        a.add("Heart 7");
        a.add("Heart 8");
        a.add("Heart 9");
        a.add("Heart 10");
        a.add("Heart KING");
        a.add("Heart QUEEN");
        a.add("Heart JOKER");

        cards1 c = new Cards_class1();

        System.out.println();
        System.out.println("************WELCOME************");
        System.out.println();
        System.out.print("CHOOSE YOUR GAME NUMBER :");

        game_number = sc.nextInt();

         int x=c.my_hit(size);
         int y=c.my_hit(size);

         int j=check(a.get(x),"hit");
         int k=check(a.get(y),"hit");
         
         total1=j+k;

         System.out.println();
         System.out.println("You have " +a.get(x)+ " and " +a.get(y));
         System.out.println("Your total is "+total1);
         System.out.println();

         remove_val(a,x);
         remove_val(a,y);

         if(total1<=game_number){

         int z = new Random().nextInt(0,size);

         total2=check(a.get(z),"stay");

         System.out.println("Dealer have " +a.get(z)+ " and one hidden card");
         System.out.println("His total is hidden ......");
         System.out.println();

         remove_val(a,z);

         String str="";

        do{
             System.out.println("hit or stay ?");
             str = sc.next();

             if(str.equals("hit")){
    
                    int n = c.my_hit(size);
                    total1 = total1 + check(a.get(n),"hit");

                    System.out.println();
                    System.out.println("You drew " +a.get(n));
                    System.out.println("Your total is "+total1);
                    System.out.println();

                    if(total1 >game_number){
                        System.out.println("YOU BUST :(");
                        System.out.println();
                        System.out.println("************DEALER WON************");
                        break;
                    }

                     Black_jack_game_number.remove_val(a, n);
                }

        }while(str.equals("hit"));

      
           if(str.equals("stay")){

             int t=new Random().nextInt(0,size);

             System.out.println();
             System.out.println("You choose to stay....");
             System.out.println("Dealer's turn...");
             System.out.println();
             System.out.println("Dealer hidden card : " + a.get(t));

             total2=total2+(check(a.get(t),"stay"));

             System.out.println("Dealer total : " + total2);

             c.my_stay(total1,total2,a,game_number,size);
            }
        }
        else{
            System.out.println("YOU BUST :(");
                        System.out.println();
                        System.out.println("************DEALER WON************");
        }
    }
}
