package dsa_package;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class N_Node{
	int data;
	ArrayList<N_Node> children;
}

public class Nary_main {

	static N_Node root =null;
	
	void insert(int data , int node) {
		
		Queue<N_Node> q = new LinkedList<>();
		
		q.add(root);
		
		N_Node newnode = new N_Node();
		newnode.data = data;
		newnode.children = new ArrayList<>();
		
	   while(!q.isEmpty()) {
			
		N_Node temp = q.poll();
		
		if(temp.data == node) {
			temp.children.add(newnode);
		}else {
			q.addAll(temp.children);
		}
	  }
	}
	
	void bfs_traversal(N_Node tree) {
		
        Queue<N_Node> q = new LinkedList<>();
		
		q.add(root);
		
		while(!q.isEmpty()) {
			
			N_Node temp = q.poll();	
			System.out.print(temp.data+" ");
			q.addAll(temp.children);
			
			}
	}
	
	void dfs_traversal() {
		
		Stack<N_Node> s = new Stack<>();
		
		s.push(root);
		
		while(!s.isEmpty()) {
			
			N_Node temp = s.pop();	
			LinkedList<N_Node> l =new LinkedList<>();
			System.out.print(temp.data+" ");
			l.addAll(temp.children);
			Collections.reverse(l);
			s.addAll(l);	
			l.clear();
			}
	}
	
	void find_height(N_Node tree) {
		
		 Queue<N_Node> q = new LinkedList<>();
		 
		 q.add(root);
		 q.add(null);
		 
		 int count=0;
		 		 
		 while(!q.isEmpty()) {
				
				N_Node temp = q.poll();

				if(temp == null) {
					count++;
					if(!q.isEmpty())
					q.add(null);
				}else {
				   q.addAll(temp.children);
				}
			}
		 System.out.println("height :" +count);
	}
	
	boolean delete(int val) {
        if (root.data == val) {
            if (root.children.isEmpty()) {
                root = null;
            } else {
                N_Node temp = root.children.get(0);
                root.children.remove(0);
                if (root.children.isEmpty()) {
                    root = temp;
                    return true;
                }

                temp.children.addAll(root.children);
                root = temp;
            }
            return true;

        } else {
            Queue<N_Node> q = new LinkedList<>();

            q.add(root);

            while (!q.isEmpty()) {
            	N_Node temp = q.poll();
                boolean contain = false;
                int Position = -1;
                for (int i = 0; i < temp.children.size(); i++) {
                    if (temp.children.get(i).data == val) {
                        contain = true;
                        Position = i;
                        break;
                    }
                }

                if (contain && temp.children.get(Position).children.isEmpty()){
                    temp.children.remove(Position);
                    return true;
                }

                if (contain) {
                	N_Node tempNode = temp.children.get(Position);
                    temp.children.add(tempNode.children.get(0));
                    tempNode.children.remove(0);
                    temp.children.get(temp.children.size()-1).children.addAll(tempNode.children);
                    temp.children.remove(Position);
                    return true;
                }

                q.addAll(temp.children);
            }
        }
        return false;
    }
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		Nary_main n = new Nary_main();
		    
		
			N_Node newnode = new N_Node();
			newnode.data = 10;
			root = newnode;
			root.children = new ArrayList<>();

			n.insert(2, 10);
			n.insert(3, 10);
			n.insert(4, 10);
			n.insert(5, 10);
			n.insert(6, 2);
			n.insert(7, 3);
			n.insert(9, 10);
			n.insert(1, 10);
		
		    n.bfs_traversal(root);
		    System.out.println();
		    n.dfs_traversal();
		    
		    n.find_height(root);
		    if(n.delete(2)) {
		    	System.out.println("DELETED");
		    }
		    n.bfs_traversal(root);
	}
}
