package dsa_package;

import java.util.Scanner;

public class Binary_search {
	
	static int search(int arr[] , int val) {
		
		int low = 0;
		int high = arr.length-1;
	
		while(low <= high) {
			
			int mid = (high+low) / 2;
			
			System.out.println("LOW :" +low);
			System.out.println("HIGH :" +high);
			System.out.println("MID :" +mid);
			
			if(arr[mid] == val) {
				return mid;
			}else if(arr[mid] > val) {
				high = mid-1;
			}else if(arr[mid] < val) {
				low = mid+1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("ENTER SIZE OF ARRAY :");
		int n = sc.nextInt();
		
		int arr[]=new int[n]; 
		for(int i=0;i<n;i++) {
			System.out.print("\nENTER ELEMENT " +i+ ":");
			arr[i]=sc.nextInt();
		}
    
		System.out.print("\nENTER ELEMENT TO SEARCH :");
		int val = sc.nextInt();
		
		int ans = search(arr , val);
		
		if(ans ==-1) {
			System.out.println("ELEMENT NOT FOUND");
		}else{
			System.out.println("ELEMENT FOUND AT POSITION :" +ans);
		}
	}
}
