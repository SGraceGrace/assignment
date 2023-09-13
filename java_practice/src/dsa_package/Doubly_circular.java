package dsa_package;

import java.util.Scanner;

class Doubly_node {
	int data;
	Doubly_node next;
	Doubly_node prev;
}

public class Doubly_circular {

	Doubly_node head = null;
	Doubly_node tail = null;
	Doubly_node temp = null;

	void insert(int val) {
		Doubly_node newnode = new Doubly_node();
		newnode.data = val;

		if (head == null) {
			head = newnode;
		} else {
			newnode.prev = temp;
			temp.next = newnode;
		}
		tail=newnode;
		tail.next=head;
		head.prev=tail;
		temp = newnode;
	}

	void display() {
		temp = head;
		if (head == null) {
			System.out.println("NO ELEMENTS IN LINKED-LIST");
		} else {
			while (temp.next != head) {
				System.out.print(temp.data + " ");
				temp = temp.next;
			}
			System.out.print(temp.data);
		}
		System.out.println();
	}

	void insert_begin(int val) {
		Doubly_node newnode = new Doubly_node();
		newnode.data = val;

		if (head == null) {
			head = newnode;
			tail=newnode;
		} else {
			newnode.next = head;
			head.prev = newnode;
			head = newnode;
		}
		head.prev=tail;
		tail.next=head;
	}

	void insert_end(int val) {
		Doubly_node newnode = new Doubly_node();
		newnode.data = val;

		if (head == null) {
			head = newnode;
			tail=newnode;
		} else {
			newnode.prev=tail;
			tail.next=newnode;
			tail=newnode;
		}
		tail.next = head;
		head.prev = tail;
	}

	void insert_position(int val, int pos) {
		Doubly_node newnode = new Doubly_node();
		newnode.data = val;

		int i = 2;

		if (head == null) {
			head = newnode;
			tail=newnode;
		} else if (pos == 1) {
			insert_begin(val);
		} else {
			temp = head;
			while (i < pos) {
				temp = temp.next;
				i++;
			}
			newnode.prev = temp;
			newnode.next = temp.next;
			temp.next = newnode;
			newnode.next.prev=newnode;
		}
	}

	void delete_begin() {
		temp = head;
		if (head.equals(tail)) {
			head = null;
			tail = null;
		}
		else {
			head=temp.next;
			head.prev=tail;
			tail.next=head;
		}
		temp = null;
	}

	void delete_last() {
		Doubly_node pre;
		if (head.equals(tail)) {
			head = null;
			tail=null;
		} else {
			temp = tail;
			tail=temp.prev;
			tail.next=head;
			head.prev=tail;
		}
		temp = null;
	}

	void delete_position(int pos) {

		Doubly_node pre;
		int i = 1;

		if (pos == 1) {
			delete_begin();
		} else {
				temp = head;
				pre = head;
				while (i < pos) {
					pre = temp;
					temp = temp.next;
					i++;
				}
				if (temp.equals(tail)) {
					delete_last();
				} else {
					temp.next.prev = pre;
					pre.next = temp.next;
					temp = null;
				}
		}
	}
	
	void reverse() {
		temp=head;
		while(temp.next!=head) {
			Doubly_node d = temp.prev;
			temp.prev=temp.next;
			temp.next=d;
			temp=temp.prev;
		}
		Doubly_node d = temp.prev;
		temp.prev=temp.next;
		temp.next=d;
		tail=head;
		head=temp;
	}
	
	int size() {
		int count=0;
		temp=head;
		while(temp.next != head) {
			count++;
			temp=temp.next;
		}
		return count+1;
	}
	
	int search(int val) {
		temp=head;
		while(temp.next!=head) {
			if(temp.data == val) {
				return 1;
			}
			temp=temp.next;
		}
		if(temp.data==val) {
			return 1;
		}
		return -1;
	}


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Doubly_circular l = new Doubly_circular();

		System.out.print("Enter the no.of.element :");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.print("\nENTER THE ELEMENT :");
			int val = sc.nextInt();
			l.insert(val);
		}

		int choice = 0;
		do {
			System.out.println("\nOPERATIONS TO BE PERFORMED ON DOUBLY-CIRCULAR-LINKED-LIST :\n");
			System.out.println(
					"1.INSERT AT BEGIN \n2.INSERT AT END " 
			+ "\n3.INSERT AT SPECIFIC POSITION \n4.DELETE AT BEGIN "
			+ "\n5.DELETE AT END \n6.DELETE AT SPECIFIC POSITION \n7.TRAVERSE \n8.REVERSE \n9.SEARCH" 
			+ " \n10.EXIT");

			System.out.print("\nENTER YOUR CHOICE :");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.print("\nENTER ELEMENT TO INSERT :");
				int val = sc.nextInt();
				l.insert_begin(val);
				break;
			case 2:
				System.out.print("\nENTER ELEMENT TO INSERT :");
				int val1 = sc.nextInt();
				l.insert_end(val1);
				break;
			case 3:
				System.out.print("\nENTER ELEMENT TO INSERT :");
				int val2 = sc.nextInt();
				System.out.print("\nENTER POSITION :");
				int pos = sc.nextInt();
				l.insert_position(val2, pos);
				break;
			case 4:
				l.delete_begin();
				break;
			case 5:
				l.delete_last();
				break;
			case 6:
				System.out.print("\nENTER POSITION :");
				int pos1 = sc.nextInt();
				l.delete_position(pos1);
				break;
			case 7:
				System.out.print("\nELEMENTS IN DOUBLY CIRCULAR LINKED LIST : ");
				l.display();
				break;
			case 8:
				l.reverse();
				break;
			case 9:
				System.out.print("\nENTER ELEMENT TO SEARCH :");
				int val3 = sc.nextInt();
				int x=l.search(val3);
				if(x==1) {
					System.out.println("ELEMENT FOUND...");
				}
				else {
					System.out.println("ELEMENT NOT FOUND...");
				}
				break;
			case 10:
				System.out.println("END...");
				break;
			}
		} while (choice < 10);
	}
}

