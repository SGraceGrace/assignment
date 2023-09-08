package java_practice;

import java.util.Stack;

public class Stack_eg {
    public static void main(String[] args) {
        
        //stack is a class that extends vector class
        // mainly 5 methods [push,pop,isEmpty,search,peek]

        Stack<Integer> s = new Stack<>();

        s.push(1);
        s.push(2);
        s.push(3);      

        System.out.println(s);
        System.out.println("SIZE OF STACK : " + s.size());

        s.pop();

        System.out.println(s);

        System.out.println("TOP OF STACK : " +s.peek());

        System.out.println(s.isEmpty());

        System.out.println("ELEMENT FOUNR AT POSITION : " + (s.search(3)) );
        System.out.println("ELEMENT FOUNR AT POSITION : " + (s.search(2)) );
    }
}
