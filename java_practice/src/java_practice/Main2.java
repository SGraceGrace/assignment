package java_practice;

class Constructor_example {
     
     //constructor overloading
     //no-arg constructor

     Constructor_example(){
        this("parameterised");                        //calling another constructor 
        System.out.println("I'm no-arg constructor");
     }

     //parameterised constructor

     Constructor_example(String a){
       this(3,5);                                  //calling another constructor 
       System.out.println("I'm " + a + " constructor");
     }
     Constructor_example(int a , int b){
       System.out.println("Number :" + a + " Number :" + b);
     }
}

class Constructor_example2{
   
  String s;
  String t;

  Constructor_example2(String s , String t){
        this(s,t,"hi");                   //calling another constructor 
        this.s = s;
        this.t = t;
        System.out.println(s+" "+t);
  }
  Constructor_example2(){
        this.s = "nil";
        this.t = "nil";
         System.out.println(s+" "+t);
  }
  Constructor_example2(String s , String t , String r){
        System.out.println(s+" "+t+" "+r);
  }
}

public class Main2{
    public static void main(String[] args) {

        //default constructor
        Constructor_example c = new Constructor_example();
        Constructor_example2 c1 = new Constructor_example2();
        Constructor_example2 c2 = new Constructor_example2("constructor","example");
        System.out.println("c1 s : " +c1.s);
        System.out.println("c1 t : " +c1.t);
        System.out.println("c2 s : " +c2.s);
        System.out.println("c2 t : " +c2.t);
        Practice_method p = new Practice_method();
        p.write();
    }
}
