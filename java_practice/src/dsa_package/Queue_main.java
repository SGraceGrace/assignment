package dsa_package;

import java.util.Scanner;

class Queue {
	int size;
	int queue[];
	int front = -1;
	int rear = -1;

	Queue(int size) {
		queue = new int[size];
		this.size = size;
	}

	int enque(int val) {
		if (rear == size - 1) {
			return -1;
		} else if (front == -1 && rear == -1) {
			front = 0;
		}
		rear = rear + 1;
		queue[rear] = val;
		return 0;
	}

	int deque() {
		if (front == -1 && rear == -1) {
			return -1;
		}
		int x = queue[front];
		front = front + 1;
		return x;
	}

	void is_full() {
		if (rear == size - 1) {
			System.out.println("yes,Queue is full");
		} else {
			System.out.println("No,Queue is not full");
		}
	}

	void is_empty() {
		if (front == -1) {
			System.out.println("yes,Queue is empty");
		} else {
			System.out.println("No,Queue is not empty");
		}
	}

	int search(int val) {
		int f = 0;
		for (int i = front; i <= rear; i++) {
			if (queue[i] == val) {
				f = 1;
				System.out.println("ELEMENT FOUND AT :" + i);
			}
		}
		if (f == 1) {
			return 0;
		}
		return -1;
	}

	int peek() {
		if (front == -1) {
			return -1;
		}
		return queue[front];
	}

	void traverse() {
		for (int i = front; i <= rear; i++) {
			System.out.print(queue[i] + " ");
		}
	}
}

public class Queue_main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("ENTER SIZE OF QUEUE :");
		int n = sc.nextInt();

		Queue q = new Queue(n);
		int choice = 0;

		do {

			System.out.println();
			System.out.println("ENTER THE OPERATION TO PERFORM :");
			System.out.println("1.ENQUEUE 2.DEQUEUE 3.CHECK FULL 4.CHECK EMPTY 5.SEARCH 6.TRAVERSE 7.PEEK 8.EXIT");
			choice = sc.nextInt();

			switch (choice) {

			case 1:
				System.out.print("ENTER THE ELEMENT TO ENQUEUE :");
				int val = sc.nextInt();
				int z = q.enque(val);
				if (z == -1) {
					System.out.println("Queue is full");
				}
				break;

			case 2:
				int val1 = q.deque();
				if (val1 == -1) {
					System.out.println("QUEUE is empty");
				} else {
					System.out.println("DEQUED ELEMENT:" + val1);
				}
				break;

			case 3:
				q.is_full();
				break;

			case 4:
				q.is_empty();
				break;

			case 5:
				System.out.print("ENTER ELEMENT TO SEARCH :");
				int val2 = sc.nextInt();
				int x = q.search(val2);
				if (x == -1) {
					System.out.println("ELEMENT NOT FOUND");
				}
				break;

			case 6:
				System.out.print("TRAVERSE THE QUEUE :");
				q.traverse();
				System.out.println();
				break;

			case 7:
				int y = q.peek();
				if (y == -1) {
					System.out.println("QUEUE IS EMPTY");
				} else {
					System.out.print("PEEK OF THE QUEUE :" + y);
				}
				break;

			default:
				System.out.print("END....");
				break;
			}
		} while (choice < 8);
	}
}
