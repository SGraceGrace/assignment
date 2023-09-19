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
		
		int f=0;
		
		Queue<N_Node> q = new LinkedList<>();
		
		q.add(root);
		
		N_Node newnode = new N_Node();
		newnode.data = data;
		newnode.children = new ArrayList<>();
		
	   while(!q.isEmpty()) {
			
		N_Node temp = q.poll();
		
		if(temp.data == node) {
			f=1;
			temp.children.add(newnode);
		}else {
			q.addAll(temp.children);
		}
	  }
	   if(f==0) {
		   System.out.println("NO SUCH NODE EXIST");
	   }
	}
	
	void bfs_traversal() {
		
        Queue<N_Node> q = new LinkedList<>();
		
		q.add(root);
		
		while(!q.isEmpty()) {
			
			N_Node temp = q.poll();	
			System.out.print(temp.data+" ");
			q.addAll(temp.children);
			
			}
	}
	
void dfs_traversal() {
		
		LinkedList<N_Node> l = new LinkedList<>();
		
		l.addFirst(root);
		
		while(l.size()>0){
		    
		    N_Node temp = l.pollFirst();
		    
		    System.out.print(temp.data +" ");
		    
		    if(temp.children.size()>0){
		        
		        Stack<N_Node> s = new Stack<>();
		        
		        for(int i=0;i<temp.children.size();i++){
		            s.add(temp.children.get(i));
		        }
		        while(!s.isEmpty()){
		             l.addFirst(s.pop());
		        }
		    }
		}
	}
	
	void find_height() {
		
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
		    
		int choice ;
		
             do {
			
			System.out.println("\n1.INSERT \n2.BFS \n3.DFS \n4.DELETE \n5.HEIGHT \n6.EXIT");
			
			choice=sc.nextInt();
			
			switch(choice) {
			
			case 1:
				System.out.print("ENTER ELEMENT TO INSERT :");
				int ele = sc.nextInt();
				
				if(root == null) {
					N_Node newnode = new N_Node();
		          newnode.data = ele;
		          root = newnode;
		          root.children = new ArrayList<>();
				}else {
                  System.out.print("ENTER NODE :");
		            int node = sc.nextInt();
					n.insert(ele, node);
				}
				break;
				
			case 2:
				if (root == null) {
					System.out.println("TREE IS NULL");
				} else {
				System.out.print("BFS : ");
				n.bfs_traversal();
				}
				break;
				
			case 3:
				if (root == null) {
					System.out.println("TREE IS NULL");
				} else {
				System.out.print("\nDFS : ");
				n.dfs_traversal();
				}
				break;

			case 4 :
				
				if (root == null) {
					System.out.println("TREE IS NULL");
				} else {
					
				System.out.print("\nENTER ELEMENT TO DELETE :");
				int val1 = sc.nextInt();
		
				 if(n.delete(val1)) {
    	         System.out.println("DELETED");
               }	
			}
				break;
			
			case 5 :
				n.find_height();
				break;
				
			default :
					System.out.println("END....");
			}
		}while(choice <6 && choice>0);

	}
}
