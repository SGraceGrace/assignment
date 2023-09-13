package dsa_package;

import java.util.Scanner;

class Circular_node {
	int data;
	Circular_node next;
}

public class Circular_linked_list {

	Circular_node head = null;
	Circular_node tail = null;
	Circular_node temp = null;

	void insert(int val) {
		Circular_node newnode = new Circular_node();
		newnode.data = val;

		if (head == null) {
			head = newnode;
		} else {
			temp.next = newnode;
		}
		tail=newnode;
		tail.next=head;
		temp = newnode;
	}

	void display() {
		temp = head;
		if(head==null) {
			System.out.println("NO ELEMENTS IN LINKED-LIST");
		}else {
		while (temp.next != head) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.print(temp.data);
		}
		System.out.println();
	}

	void insert_begin(int val) {
		Circular_node newnode = new Circular_node();
		newnode.data = val;
		newnode.next = null;

		if (head == null) {
			head = newnode;
			tail=newnode;
		} else {
			newnode.next=head;
			head = newnode;
		}
		tail.next=head;
	}

	void insert_end(int val) {
		Circular_node newnode = new Circular_node();
		newnode.data = val;
		newnode.next = null;

		if (head == null) {
			head = newnode;
		} else {
			tail.next=newnode;
		}
		tail=newnode;
		tail.next=head;
	}

	void insert_position(int val, int pos) {
		Circular_node newnode = new Circular_node();
		newnode.data = val;
		newnode.next = null;

		int i = 2;

		if (head == null) {
			head = newnode;
			tail=newnode;
			tail.next=head;
		} else if (pos == 1) {
			insert_begin(val);
		} else {
			temp = head;
			while (i < pos) {
				temp = temp.next;
				i++;
			}
			newnode.next = temp.next;
			temp.next = newnode;
		}
	}

	void delete_begin() {
		if(head.equals(tail)) {
			head=null;
			tail=null;
		}
		else if(head != null) {
			temp = head;
			head = temp.next;
			tail.next=head;
		}
		temp = null;
	}

	void delete_last() {
		Circular_node prev;
		if(head.next==head) {
			head=null;
			tail=null;
		}
		else {
			temp = head;
			prev = head;
			while (temp.next != head) {
				prev = temp;
				temp = temp.next;
			}
			tail=prev;
			tail.next = head;
		}
		temp = null;
	}

	void delete_position(int pos) {

		Circular_node prev;
		int i = 1;

		if (pos == 1) {
			delete_begin();
		} else {
			if (head != null) {
				temp = head;
				prev = head;
				while (i < pos) {
					prev = temp;
					temp = temp.next;
					i++;
				}
				if(tail.equals(temp)) {
					tail=prev;
				}
				prev.next = temp.next;
				temp = null;
			}
		}
	}
	
	void reverse() {
		Circular_node pre=null;
		Circular_node cur=head;
		Circular_node nex=null;
		
		while(cur.next!=head) {
			nex=cur.next;
			cur.next=pre;
			pre=cur;
			cur=nex;
		}
		nex=cur.next;
		cur.next=pre;
		pre=cur;
		cur=nex;
		head.next=tail;
		tail=head;
		head=pre;
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

		Circular_linked_list l = new Circular_linked_list();

		System.out.print("Enter the no.of.element :");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.print("\nENTER THE ELEMENT :");
			int val = sc.nextInt();
			l.insert(val);
		}

		int choice = 0;
		do {
			System.out.println("\nOPERATIONS TO BE PERFORMED ON CIRCULAR-LINKED-LIST :\n");
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
				System.out.print("\nELEMENTS IN CIRCULAR LINKED LIST : ");
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

