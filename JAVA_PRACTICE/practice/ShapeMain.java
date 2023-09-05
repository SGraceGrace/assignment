package practice;

/**
 * Shape
 */
class Shape {
    double val;

    Shape(){
        System.out.println("I'm parent constructor");
    }
    Shape(double r){
        this.val = r;
        System.out.println("AREA OF CIRCLE : " + 3.14*val);
    }
    public void display(){
        System.out.println("I'm parent");
    }
}
/**
 * Rectangle
 */
class Rectangle extends Shape{
    Rectangle(){
         super();
    }
    public void rec_display(){
        System.out.println("I'm Rectangle");
    }  
    public double rec_area(double l , double b){
          return l*b;
    } 
}
/**
 * Circle
 */
class Circle extends Shape{
    Circle(){
        super(5.4);
    }
    public void cir_display(){
        System.out.println("I'm Circle");
    }  
    public double cir_area(double r){
          return 3.14*r*r;
    } 
}

public class ShapeMain {
    public static void main(String[] args) {
    Rectangle r = new Rectangle();
    Circle c = new Circle();
    
    r.display();
    r.rec_display();
    c.cir_display();
    System.out.println("AREA OF RECTANGLE : " + r.rec_area(3.2, 4.6));
    System.out.println("AREA OF CIRCLE : " + c.cir_area(4.9));
}
}
