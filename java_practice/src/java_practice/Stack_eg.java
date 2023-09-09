package java_practice;

import java.util.Iterator;
import java.util.Stack;

public class Stack_eg {
    public static void main(String[] args) {
        
        //stack is a class that extends vector class
        // mainly 5 methods [push,pop,isEmpty,search,peek]

        Stack<Integer> s = new Stack<>();

        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(6);
        s.push(7);
        s.push(8);
        s.push(9);
        s.push(10);
        s.push(21);
        s.push(38);
        s.push(13);
        s.push(24);
        s.push(32);

        System.out.println("STACK : " + s);
        System.out.println("SIZE OF STACK : " + s.size());

        //throws EmptyStackException if the stack is empty.
        System.out.println("POPED ELEMENT : "+ s.pop()); 

        System.out.println("STACK AFTER POP OPERATION : " + s);
        
        //peek returns top element ..if stack empty throws EmptyStackException
        System.out.println("TOP OF STACK : " +s.peek());

        System.out.println(s.isEmpty());

        //returns -1 if not found
        System.out.println("ELEMENT 3 FOUND AT POSITION : " + (s.search(3)) );
        System.out.println("ELEMENT 2 FOUND AT POSITION : " + (s.search(2)) );
        
        //traverse stack 
        
        //iterator() method
        System.out.print("iterator method : ");
        
        Iterator i =  s.iterator();
        while(i.hasNext()) {
        	System.out.print(i.next()+" ");
        }
        
        System.out.println();
        
        //for loop
        System.out.print("for-loop : ");
        
        for(int j=0;j<s.size();j++) {
        	System.out.print(s.get(j)+" ");   // get(index)
        }
        
        System.out.println();
        
        //other methods
        
        System.out.println("CONTAINS 3 ? :" +s.contains(3));
        System.out.println("INDEX OF 3 : " +s.indexOf(3));
        System.out.println("REMOVED ELEMENT AT INDEX 2 :" + s.remove(2)); //remove(index)      
        System.out.println("STACK TO STRING : " +s.toString());
        s.set(0, 100);
        System.out.println(s);
        
    }
}
