package java_practice;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;

//Time complexity :O(2^n) Space complexity :O(n) 

interface cards{
    int  my_hit(int size);
    int dealer_hit(ArrayList<String> a , int size);
    void my_stay(int total1,int total2, ArrayList<String> a , int size,TreeMap<Integer,String> m);
    void dealer_stay(int total1,int total2 , int size);
    void result(int total1,int total2);
}

class Cards_class implements cards{

    // my_hit method performs when player choose to hit ...this method randomly generate card for player...
    public int my_hit(int size){    //Time complexity :O(1) Space complexity :O(1)              
      int x = new Random().nextInt(0,size);
      return x;
     }

   /*  my_stay method performs when player choose to stay ...after player give stay......it's dealer's turn .....
       checks dealer's total , if <17 dealer will hit ...if dealer's total >21 dealer bust....*/
    
    public void my_stay(int total1,int total2, ArrayList<String> a , int size, TreeMap<Integer,String> m){  //Time complexity :O(2^n) Space complexity :O(1)     
        if(total2<17 && total2<22){
        	
            int f = dealer_hit(a , size);
            total2=total2+Blackjack_game.check(a.get(f),"stay");
            Blackjack_game.remove_val(a, f, m);
            
            System.out.println("Now Dealer's total :" +total2);
            my_stay(total1,total2,a , size,m);     //recursion until dealer's total exceeds 17...
        }
        else{
            dealer_stay(total1,total2,size);     //if dealer's total > 17 ...dealer stay
        }
     }

     // dealer_hit method will randomly generate cards for dealer... 
     public int dealer_hit(ArrayList<String> a , int size){     //Time complexity :O(1) Space complexity :O(1) 
        int x = new Random().nextInt(0,size);
        System.out.println();
        System.out.println("Dealer drew :"+a.get(x));
        return x;
     }

    // dealer_stay method checks dealer's total exceeds 21...if exceeds dealer bust
     public void dealer_stay(int total1,int total2 , int size){  //Time complexity :O(1) Space complexity :O(1) 
            if(total2 >21){
                System.out.println();
                System.out.println("DEALER BUST");
                System.out.println();
                System.out.println("************YOU WON (RS."+Blackjack_game.amount +")************");
            }
            else{
                System.out.println();
                System.out.println("Dealer stay......");
                result(total1,total2);    
            }
     }

     // result method will compare player's total and dealer's total ....the higher will win the match..
     public void result(int total1,int total2){  //Time complexity :O(1) Space complexity :O(1) 
        if(total1>total2){
        System.out.println();
        System.out.println("Your total : "+total1);
        System.out.println("Dealer's total : "+total2);
        System.out.println();
        System.out.println("************YOU WON (RS."+Blackjack_game.amount + ")************");
         }
         else if(total2>total1){
         System.out.println();
         System.out.println("Dealer total : "+total2);
         System.out.println("Your total : "+total1);
         System.out.println();
         System.out.println("************DEALER WON (RS."+Blackjack_game.amount + ")************");
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

public class Blackjack_game {

    static int total1=0;     //player's total
    static int total2=0;     //dealer's total
    static int size=51;
    static int amount=0;

    // remove the drawn card from arraylist
    static void remove_val(ArrayList<String> a , int b, TreeMap<Integer,String> m){
            m.put(b,a.get(b));
            a.remove(b);
            size--;
    }
    
    // check the number in string and seperate the number from string 
   public static int check(String str,String s){
        if(str.contains("KING") || str.contains("QUEEN") || str.contains("JOKER")){
           return 10;
        }
        else if(str.contains("ACE")){
            if(total1+11 < 22 && s.equals("hit"))
             return 11;
             if(total2+11 < 22 && s.equals("stay"))
             return 11;
        }
        else{
        str=str.replaceAll("[a-zA-Z ]","");
        return Integer.parseInt(str);
        }
        return 1;
    }

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        
        TreeMap<Integer,String> m = new TreeMap<>();

        ArrayList<String> a = new ArrayList<>(); //Time complexity :O(1) Space complexity :O(n) 
        
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
        
        cards c = new Cards_class();

        int option=0;
        
        System.out.println();
        System.out.println("************WELCOME************");
        System.out.println();
     do {  
        System.out.print("BID AMOUNT (RS.10,RS.50,RS.100,RS.500) : ");
        amount = sc.nextInt();
        System.out.println();
        

         int x=c.my_hit(size);
         int j=check(a.get(x),"hit");
         System.out.print("You have " +a.get(x)+ " and ");
         remove_val(a,x,m);
         
         int y=c.my_hit(size);
         int k=check(a.get(y),"hit");
         System.out.println(a.get(y));
         remove_val(a,y,m);
         
         total1=j+k;

         System.out.println("Your total is "+total1);
         System.out.println();

         int z = new Random().nextInt(0,size);

         total2=check(a.get(z),"stay");

         System.out.println("Dealer have " +a.get(z)+ " and one hidden card");
         System.out.println("His total is hidden ......");
         System.out.println();

          remove_val(a,z,m);

         String str="";

        do{  //Time complexity :O(n) Space complexity :O(1) 
             System.out.println("hit or stay ?");
             str = sc.next();

             if(str.equals("hit")){
    
                    int n = c.my_hit(size);
                    total1 = total1 + check(a.get(n),"hit");

                    System.out.println();
                    System.out.println("You drew " +a.get(n));
                    System.out.println("Your total is "+total1);
                    System.out.println();

                    remove_val(a, n,m);
                    
                    if(total1 >21){
                        System.out.println("YOU BUST :(");
                        System.out.println();
                        System.out.println("************DEALER WON (RS."+Blackjack_game.amount +")************");
                        break;
                    }
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
             
             remove_val(a, t, m);

             c.my_stay(total1,total2,a,size,m);
            }
           
           System.out.println("\n\n1.PLAY AGAIN \n2.EXIT");
           option=sc.nextInt();
           
           if(option == 2) {
        	   System.out.println("GAME OVER !!!!");
           }else {
           for(Map.Entry<Integer, String> h :  m.entrySet()) {
        	   a.add(h.getKey(),h.getValue());
           }
           m.clear();
           }
           
     }while(option==1);
           
    }
}
