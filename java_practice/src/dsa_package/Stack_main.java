package dsa_package;

import java.util.Scanner;

class Stack {
	int stack[];
	int size;
	int top = -1;

	Stack(int size) {
		stack = new int[size];
		this.size = size;
	}

	void push(int val) {
		if (top == size - 1) {
			System.out.println("Stack is full");
		} else {
			top = top + 1;
			stack[top] = val;
		}
	}

	int pop() {
		if (top == -1) {
			return -1;
		}
		int x = stack[top];
		top = top - 1;
		return x;
	}

	void is_full() {
		if (top == size - 1) {
			System.out.println("yes,Stack is full");
		} else {
			System.out.println("No,Stack is not full");
		}
	}

	void is_empty() {
		if (top == -1) {
			System.out.println("yes,Stack is empty");
		} else {
			System.out.println("No,Stack is not empty");
		}
	}

	void display() {
		for (int i = 0; i <= top; i++) {
			System.out.print(stack[i] + " ");
		}
	}

	int peek() {
		if (top == -1) {
			return -1;
		}
		return stack[top];
	}
}

public class Stack_main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("ENTER SIZE OF STACK :");
		int n = sc.nextInt();

		Stack s = new Stack(n);
		int choice = 0;

		do {

			System.out.println();
			System.out.println("ENTER THE OPERATION TO PERFORM :");
			System.out.println("1.PUSH 2.POP 3.CHECK FULL 4.CHECK EMPTY 5.DISPLAY 6.PEEK 7.EXIT");
			choice = sc.nextInt();

			switch (choice) {

			case 1:
				System.out.print("ENTER THE ELEMENT TO PUSH :");
				int val = sc.nextInt();
				s.push(val);
				break;

			case 2:
				int val1 = s.pop();
				if (val1 == -1) {
					System.out.println("Stack is empty");
				} else {
					System.out.println("POPED ELEMENT:" + val1);
				}
				break;

			case 3:
				s.is_full();
				break;

			case 4:
				s.is_empty();
				break;

			case 5:
				System.out.print("DISPLAY THE STACK :");
				s.display();
				System.out.println();
				break;

			case 6:
				int y = s.peek();
				if (y == -1) {
					System.out.println("STACK IS EMPTY");
				} else {
					System.out.print("PEEK OF THE STACK :" + y);
				}
				break;

			default:
				System.out.print("END...");
				break;
			}
		} while (choice < 7);
	}
}
