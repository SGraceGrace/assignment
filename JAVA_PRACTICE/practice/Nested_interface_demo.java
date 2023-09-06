package practice;

//interface inside interface
interface outer_interface{
    void outer_display();
    interface inner_interface{
        void inner_display();
    }
}

//interface inside class
class Interface_demo_class implements outer_interface{ 
    int a=10;
    public void outer_display(){
        System.out.println("outer interface");
      }
    interface inner_class_interface{
        void inner_class_display();
    }
}

//class inside interface
interface outer1_interface{
  void say();
 class Inner_interface{    //can only be public
    int c,b;
    Inner_interface(int c , int b){
         this.c = c;
         this.b = b;
    }
  }
}

class Interface_example implements outer1_interface{
    public void say(){                    
      System.out.println("hi...");
    }
}

class Interface_example1 implements outer_interface{
      public void outer_display(){
        System.out.println("outer interface");
      }
      public void inner_display(){
        System.out.println("inner interface inside interface");
      }
}

class Interface_example2 implements outer_interface.inner_interface{
      public void inner_display(){
        System.out.println("inner interface");
      }
      public void outer_display(){
        System.out.println("outer interface");
      }
}

class Interface_example3 implements Interface_demo_class.inner_class_interface{
      public void inner_class_display(){
        System.out.println("inner interface inside class");
      }
      // public void inner_display(){
      //   System.out.println("inner interface ");
      // }
      // public void outer_display(){
      //   System.out.println("outer interface ");
      // }
}

public class Nested_interface_demo {
    public static void main(String[] args) {
        outer_interface o = new Interface_example1();  
        outer_interface.inner_interface i = new Interface_example2();
        Interface_demo_class.inner_class_interface class_interface = new Interface_example3();

        o.outer_display();
        i.inner_display();
        class_interface.inner_class_display();

        Interface_example1 i1 = new Interface_example1();
        Interface_example2 i2 = new Interface_example2();
        Interface_example3 i3 = new Interface_example3();
        
        i1.outer_display();
        i1.inner_display();

        i2.inner_display();
        i2.outer_display();

       // i3.inner_display();
       // i3.outer_display();

        Interface_demo_class d = new Interface_demo_class();
        d.outer_display();
        System.out.println(d.a);

        outer1_interface.Inner_interface oi = new outer1_interface.Inner_interface(5,6);
        System.out.println(oi.c);
        System.out.println(oi.b);

        outer1_interface o1=new Interface_example();
        o1.say();
    }
}
