
package dsa_package;

import java.util.*;

//import java.util.Scanner;

class Binary_tree_node {
	int data;
	Binary_tree_node lchild;
	Binary_tree_node rchild;
}

public class Binary_search_tree {

	static Binary_tree_node root = null;

	Binary_tree_node insert(Binary_tree_node tree, int val) {

		if (tree == null) {
			Binary_tree_node newnode = new Binary_tree_node();
			newnode.data = val;
			newnode.lchild = null;
			newnode.rchild = null;
			tree = newnode;
		} else if (val > tree.data) {
			tree.rchild = insert(tree.rchild, val);
		} else if (val < tree.data) {
			tree.lchild = insert(tree.lchild, val);
		}
		return tree;
	}

	void inorder(Binary_tree_node tree) {
		if (tree == null) {
			return;
		} else {
			inorder(tree.lchild);
			System.out.print(tree.data + " ");
			inorder(tree.rchild);
		}
	}

	void preorder(Binary_tree_node tree) {
		if (tree == null) {
			return;
		} else {
			System.out.print(tree.data + " ");
			preorder(tree.lchild);
			preorder(tree.rchild);
		}
	}

	void postorder(Binary_tree_node tree) {
		if (tree == null) {
			return;
		} else {
			postorder(tree.lchild);
			postorder(tree.rchild);
			System.out.print(tree.data + " ");
		}
	}

	void level_order(Binary_tree_node tree) {

		if (tree == null) {
			return;
		} else {
			
		Queue<Binary_tree_node> q = new LinkedList<>();

		q.add(tree);

		while (!q.isEmpty()) {

			Binary_tree_node node = q.poll();
			System.out.print(node.data + " ");

			if (node.lchild != null) {
				q.add(node.lchild);
			}
			if (node.rchild != null) {
				q.add(node.rchild);
			}
		}
	}
	}

	void search(Binary_tree_node tree, int val) {
		if (tree == null) {
			System.out.print("\nELEMENT NOT FOUND");
		} else if (tree.data == val) {
			System.out.print("\nELEMENT FOUND");
		} else if (val > tree.data) {
			search(tree.rchild, val);
		} else if (val < tree.data) {
			search(tree.lchild, val);
		}
	}

	Binary_tree_node deletion(Binary_tree_node tree, int val) {

		Binary_tree_node node = null;
		Binary_tree_node prev = tree;
		
		if(tree == null) {
			System.out.println("ELEMENT NOT FOUND TO DELETE");
			return tree;
		}
		
		if (val > tree.data) {
			tree.rchild = deletion(tree.rchild, val);
		} else if (val < tree.data) {
			tree.lchild = deletion(tree.lchild, val);
		}
		
		if (val == tree.data) {

			if (tree.rchild == null && tree.lchild == null){
				return null;
			}else if (tree.lchild == null) {
				return tree.rchild;
			} else if (tree.rchild == null) {
				return tree.lchild;
			} else if (tree.rchild != null && tree.lchild != null){
               
				node = tree.lchild;
				
				while(node.rchild != null) {
					prev = node;
					node = node.rchild;
				}			
				tree.data = node.data;
			}
			
			if(prev == tree) {
				prev.lchild=node.lchild;
			}else {
				prev.rchild=null;
			}
			return tree;
		}
		return tree;
	}
	
	int find_min(Binary_tree_node tree) {
		if(tree == null) {
			return -1;
		}else {
			
			while(tree.lchild !=null) {
				tree = tree.lchild;
			}
		}
		return tree.data;
	}
	
	int find_max(Binary_tree_node tree) {
		if(tree == null) {
			return -1;
		}else {
			
			while(tree.rchild !=null) {
				tree = tree.rchild;
			}
		}
		return tree.data;
	}
	
	int height(Binary_tree_node tree) {
		
		if(tree == null) {
			return 0;
		}
			int rheight = height(tree.rchild);
			int lheight = height(tree.lchild);
		return rheight>lheight ? rheight+1:lheight+1;
	}

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);

		Binary_search_tree b = new Binary_search_tree();

		int choice=0;
		do {
			
			System.out.println("\n1.INSERT \n2.INORDER \n3.PREORDER \n4.POSTORDER "
					+ "\n5.LEVELORDER \n6.SEARCH \n7.DELETION \n8.MINIMUM ELEMENT \n9.MAXIMUM ELEMENT \n10.HEIGHT \n11.EXIT");
			
			choice=sc.nextInt();
			
			switch(choice) {
			
			case 1:
				System.out.print("ENTER ELEMENT TO STORE :");
				int ele = sc.nextInt();
				
				if(root == null) {
					root = b.insert(root, ele);
				}else {
					b.insert(root, ele);
				}
				break;
				
			case 2:
				if (root == null) {
					System.out.println("TREE IS NULL");
				} else {
				System.out.print("INORDER TRAVERSAL : ");
				b.inorder(root);
				}
				break;
				
			case 3:
				if (root == null) {
					System.out.println("TREE IS NULL");
				} else {
				System.out.print("\nPREORDER TRAVERSAL : ");
				b.preorder(root);
				}
				break;
				
			case 4:
				if (root == null) {
					System.out.println("TREE IS NULL");
				} else {
				System.out.print("\nPOSTORDER TRAVERSAL : ");
				b.postorder(root);
				}
				break;
				
			case 5:
				if (root == null) {
					System.out.println("TREE IS NULL");
				} else {
				System.out.print("\nLEVELORDER TRAVERSAL : ");
				b.level_order(root);
				}
				break;
				
			case 6:
				if (root == null) {
					System.out.println("TREE IS NULL");
				} else {
				System.out.print("\nENTER ELEMENT TO SEARCH :");
				int val = sc.nextInt();
				b.search(root, val);
				}
				break;
				
			case 7 :
				
				if (root == null) {
					System.out.println("TREE IS NULL");
				} else {
					
				System.out.print("\nENTER ELEMENT TO DELETE :");
				int val1 = sc.nextInt();
				
				root=b.deletion(root, val1);
				
			}
				break;
				
			case 8:
				if(b.find_min(root)==-1)
				    System.out.println("TREE IS NULL");
				else
					System.out.println("MINIMUM ELEMENT IS :" +(b.find_min(root)));
				break;
				
			case 9:
				if(b.find_max(root)==-1)
				    System.out.println("TREE IS NULL");
				else
					System.out.println("MAXIMUM ELEMENT IS :" +(b.find_max(root)));
				break;
				
			case 10 :
				System.out.println( b.height(root));
				break;
				
			default :
					System.out.println("END....");
			}
		}while(choice <11 && choice>0);
	}

}
