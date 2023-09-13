package dsa_package;

import java.util.Scanner;

class Node {
	int data;
	Node next;
}

public class Single_linked_list {

	Node head = null;
	Node temp = null;

	void insert(int val) {
		Node newnode = new Node();
		newnode.data = val;
		newnode.next = null;

		if (head == null) {
			head = newnode;
		} else {
			temp.next = newnode;
		}
		temp = newnode;
	}

	void display() {
		temp = head;
		if(head==null) {
			System.out.println("NO ELEMENTS IN LINKED-LIST");
		}else {
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		}
		System.out.println();
	}

	void insert_begin(int val) {
		Node newnode = new Node();
		newnode.data = val;
		newnode.next = null;

		if (head == null) {
			head = newnode;
		} else {
			newnode.next = head;
			head = newnode;
		}
	}

	void insert_end(int val) {
		Node newnode = new Node();
		newnode.data = val;
		newnode.next = null;

		if (head == null) {
			head = newnode;
		} else {
			temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newnode;
		}
	}

	void insert_position(int val, int pos) {
		Node newnode = new Node();
		newnode.data = val;
		newnode.next = null;

		int i = 2;

		if (head == null) {
			head = newnode;
		} else if (pos == 1) {
			insert_begin(val);
		} else if(pos == (size()+1)){
			insert_end(val);
		}else {
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
		if (head != null) {
			temp = head;
			head = temp.next;
		}
		temp = null;
	}

	void delete_last() {
		Node prev;
		if(head.next==null) {
			head=null;
		}
		else if (head.next!= null) {
			temp = head;
			prev = head;
			while (temp.next != null) {
				prev = temp;
				temp = temp.next;
			}
			prev.next = null;
		}
		temp = null;
	}

	void delete_position(int pos) {

		Node prev;
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
				prev.next = temp.next;
				temp = null;
			}
		}
	}
	
	void reverse() {
		Node pre=null;
		Node cur=head;
		Node nex=null;
		
		while(cur!=null) {
			nex=cur.next;
			cur.next=pre;
			pre=cur;
			cur=nex;
		}
		head=pre;
	}
	
	int size() {
		int count=0;
		temp=head;
		while(temp!=null) {
			count++;
			temp=temp.next;
		}
		return count;
	}
	
	int search(int val) {
		temp=head;
		while(temp!=null) {
			if(temp.data == val) {
				return 1;
			}
			temp=temp.next;
		}
		return -1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Single_linked_list l = new Single_linked_list();

		System.out.print("Enter the no.of.element :");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.print("\nENTER THE ELEMENT :");
			int val = sc.nextInt();
			l.insert(val);
		}

		int choice = 0;
		do {
			System.out.println("\nOPERATIONS TO BE PERFORMED ON LINKED-LIST :\n");
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
				System.out.print("\nELEMENTS IN LINKED LIST : ");
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
