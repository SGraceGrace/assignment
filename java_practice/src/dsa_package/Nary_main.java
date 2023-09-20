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
	
/*     10
     / |  \  
     2 3   5
    /\ /  /\ \
   1 6 7  8 4 9  
      /
     11            */
	
void dfs_traversal() { 
		
		LinkedList<N_Node> l = new LinkedList<>();		          
		l.addFirst(root);	
		while(l.size()>0){	
			
		    N_Node temp = l.pollFirst();	
		    
		    System.out.print(temp.data +" ");	//10,2,1,6,3,7,5,8,4,9
		    
		    if(temp.children.size()>0) {		        
		        for(int i=temp.children.size()-1;i>=0;i--){
		             l.addFirst(temp.children.get(i));
		        }
		    }
		}
	}
	
/*     10
     / | \  
     2 3   5
    /\ /  /\ \
   1 6 7  8 4 9 
      /
     11             */

 void find_height() { 
    
    int count=0;
	
	Queue<N_Node> q = new LinkedList<>();
	Queue<N_Node> sub = new LinkedList<>();
	
	q.add(root);
	
	while(!q.isEmpty()){
	    
	    N_Node temp = q.poll();
	    
	    if(temp.children.size() >0){
	        sub.addAll(temp.children);
	    }
	    if(q.size() ==0){
	        count++;
	        q.addAll(sub);
	        sub.clear();
	    }
	}
	System.out.print("HEIGHT :"+count);
}
	
int delete(int val){
	
	int flag=0;
    
    if(root.data == val){
    	flag=1;
        
        N_Node target = root;
    
    if(target.children.size() ==0){
        root = null;
    }else if(target.children.size()>0){
        N_Node replace_node = target.children.get(0);
        target.children.remove(0);
        replace_node.children.addAll(target.children);
        root = replace_node;
    }
    }else{
    	
  /*      10
        / | \  
        2 3   5
       /\ /  /\ \
      1 6 7  8 4 9
         / 
        11                */   
    Queue<N_Node> q = new LinkedList<>();   
    q.add(root);
    
    int index=-1;   
     N_Node parent=null;
    
    while(!q.isEmpty()){      
        parent = q.poll();
        
        for(int i=0;i<parent.children.size();i++){
            if(parent.children.get(i).data == val){
                index=i;
                flag=1;
                break;
            }
        }
        if(flag == 1){
            break;
        }else{
            q.addAll(parent.children);
        }
    }
    if(flag == 1) {
    N_Node target = parent.children.get(index);
    
    if(target.children.size() ==0){
        parent.children.remove(index);
    }else if(target.children.size()>0 && parent.children.size()==1){
        parent.children.addAll(target.children);
        parent.children.remove(index);
    }else if(target.children.size()>0 && parent.children.size()>1){
        N_Node replace_node = target.children.get(0);
        target.children.remove(0);
        replace_node.children.addAll(target.children);
        parent.children.set(index , replace_node);
    }
    }
  }
    return flag;
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
		
				 if(n.delete(val1) ==1) {
    	         System.out.println("DELETED");
               }else {
            	   System.out.println("ELEMENT NOT FOUND");
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
