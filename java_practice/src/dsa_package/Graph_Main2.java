package dsa_package;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class Undirected_graph{
	int data;
	ArrayList<Undirected_graph> adjacentNodes;
}

public class Graph_Main2 {
	
	ArrayList<Undirected_graph> nodes = new ArrayList<>();

	void create_node(int data) {
		Undirected_graph newnode = new Undirected_graph();
		newnode.data = data;
		newnode.adjacentNodes =  new ArrayList<>();
		nodes.add(newnode);
	}
	
	void create_edge(int src , int dest) {
		
		Undirected_graph source_node = null;
		Undirected_graph dest_node = null;
		
		for(int i=0;i<nodes.size();i++) {
			
			if(nodes.get(i).data == src) {
				source_node = nodes.get(i);
			}
			if(nodes.get(i).data == dest) {
				dest_node = nodes.get(i);
			}
		}
		
		if(source_node != null && dest_node != null) {
			source_node.adjacentNodes.add(dest_node);
			dest_node.adjacentNodes.add(source_node);
			
		}else {
			System.out.println("NO SUCH NODE FOUND");
		}
	}
	
	void print() {
		for(int i=0;i<nodes.size();i++) {
			
			Undirected_graph node = nodes.get(i);
			
			System.out.print("\nNODE : " +node.data);
			
			if(node.adjacentNodes.size()>0) {
				
			System.out.print("-->(");
				
			int j=0;
			
			for(j=0;j<node.adjacentNodes.size()-1;j++) {			
				System.out.print(node.adjacentNodes.get(j).data +",");
			}
			System.out.print(node.adjacentNodes.get(j).data +")");
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
			
		ArrayList<Undirected_graph> visited = new ArrayList<>();
		
		Queue<Undirected_graph> q = new LinkedList<>();
		
		q.add(nodes.get(index));
		
		while(!q.isEmpty()){
			
			Undirected_graph node = q.poll();
			
			if(!visited.contains(node)) {
				
			if(node.adjacentNodes.size()>0) {
				q.addAll(node.adjacentNodes);
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
			
		ArrayList<Undirected_graph> visited = new ArrayList<>();
		
		Stack<Undirected_graph> s = new Stack<>();
		
		s.add(nodes.get(index));
		
		while(!s.isEmpty()){
			
			Undirected_graph node = s.pop();
			
			if(!visited.contains(node)) {
				
			if(node.adjacentNodes.size()>0) {				
				for(int i=0;i<node.adjacentNodes.size();i++) {
					if(!visited.contains(node.adjacentNodes.get(i))) {
						s.push(node.adjacentNodes.get(i));
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
		
		Graph_Main2 g = new Graph_Main2();
		
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
				g.create_edge(src,dest);
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
//		g.create_node(2);
//		g.create_node(4);
//		g.create_node(6);
//		g.create_node(8);
//		g.create_node(3);
//		g.create_node(1);
//		
//		g.create_edge(2, 4);
//		g.create_edge(2, 8);
//		g.create_edge(2, 3);
//		g.create_edge(3, 1);
//		g.create_edge(3, 8);
//		g.create_edge(4, 6);
//		g.create_edge(4, 3);
//		g.create_edge(1, 4);
//		g.create_edge(6, 1);
//		
//		g.print();
//		
//		System.out.println();
//		System.out.print("BFS : ");
//		g.bfs(6);
//		System.out.println();
//		System.out.print("DFS : ");
//		g.dfs(8);
		}
}
