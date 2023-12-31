package dsa_package;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class Directed_graph{
	int data;
	ArrayList<Directed_graph> nextNodes;
}


public class Graph_Main1 {

	ArrayList<Directed_graph> nodes = new ArrayList<>();
	
	void create_node(int data) {
		
		Directed_graph newnode = new Directed_graph();
		newnode.data = data;
		newnode.nextNodes = new ArrayList<>();
		
		nodes.add(newnode);
	}
	
	void create_edges(int src , int dest) {
		
		Directed_graph source =null;
		Directed_graph destination =null;
		
		for(int i=0;i<nodes.size();i++) {
			if(nodes.get(i).data == src) {
				source = nodes.get(i);
			}
			if(nodes.get(i).data == dest) {
				destination = nodes.get(i);
			}
		}
		
		if(source != null && destination != null) {
			source.nextNodes.add(destination);
		}else {
			System.out.println("NODE IS NOT PRESENT");
		}
	}
	
	void print() {
		for(int i=0;i<nodes.size();i++) {
			
			Directed_graph node = nodes.get(i);
			
			System.out.print("\nNODE : " +node.data);
			
			if(node.nextNodes.size()>0) {
				
			System.out.print("-->(");
			
			int j=0;
			
			for(j=0;j<node.nextNodes.size()-1;j++) {			
				System.out.print(node.nextNodes.get(j).data +",");
			}
			System.out.print(node.nextNodes.get(j).data +")");
		}
	}
}
	
	void bfs(int start) {
		
		int index =-1;
		
		for(int i=0;i<nodes.size();i++) {
			if(nodes.get(i).data == start) {
				index=i;
				break;
			}
		}
		
		if(index != -1) {
			
		ArrayList<Directed_graph> visited = new ArrayList<>();
		
		Queue<Directed_graph> q = new LinkedList<>();
		
		q.add(nodes.get(index));
		
		while(!q.isEmpty()){
			
			Directed_graph node = q.poll();
			
			if(!visited.contains(node)) {
				
			if(node.nextNodes.size()>0) {
				q.addAll(node.nextNodes);
			}
			System.out.print(node.data+" ");
			visited.add(node);
		  }
		}
	}else {
		System.out.println("NO SUCH NODE PRESENT");
	}
}
	
void dfs(int start) {
		
		int index =-1;
		
		for(int i=0;i<nodes.size();i++) {
			if(nodes.get(i).data == start) {
				index=i;
				break;
			}
		}
		
		if(index != -1) {
			
		ArrayList<Directed_graph> visited = new ArrayList<>();
		
		Stack<Directed_graph> s = new Stack<>();
		
		s.add(nodes.get(index));
		
		while(!s.isEmpty()){
			
			Directed_graph node = s.pop();
			
			if(!visited.contains(node)) {
				
			if(node.nextNodes.size()>0) {				
				for(int i=0;i<node.nextNodes.size();i++) {
					if(!visited.contains(node.nextNodes.get(i))) {
						s.push(node.nextNodes.get(i));
					}
				}
			}
			System.out.print(node.data+" ");
			visited.add(node);
		  }
		}
	}else {
		System.out.println("NO SUCH NODE PRESENT");
	}
}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Graph_Main1 g = new Graph_Main1();
		
		int choice;
		
		do {			
			
			System.out.println("\n1.CREATE NODE \n2.CREATE EDGES \n3.BFS \n4.DFS \n5.PRINT \n6.EXIT");
			choice = sc.nextInt();
			
			switch(choice) {
			
			case 1:
				System.out.print("ENTER NODE VALUE :");
				int ele = sc.nextInt();
				g.create_node(ele);
				break;
				
			case 2:
				System.out.print("ENTER SOURCE NODE:");
				int src = sc.nextInt();
				System.out.print("ENTER DESTINATION NODE:");
				int dest = sc.nextInt();
				g.create_edges(src,dest);
				break;
				
			case 3:
				System.out.print("ENTER START NODE:");
				int start = sc.nextInt();
				System.out.print("\nBFS :");
				g.bfs(start);
				break;
				
			case 4:
				System.out.print("ENTER START NODE:");
				int start1 = sc.nextInt();
				System.out.print("\nDFS :");
				g.dfs(start1);
				break;
				
			case 5 :
				g.print();
				break;
				
			default:
				System.out.println("END......");
				
			}
		}while(choice<6 && choice>0);		
	}
}
