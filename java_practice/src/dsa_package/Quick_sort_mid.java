package dsa_package;

import java.util.Scanner;

public class Quick_sort_mid {

		static void quick_sort(int arr[],int low,int high) {
			
			if(low<high) {
				
			int pivot = arr[(high+low)/2]; 
			int i=low;
			int j=high;
			
			while(i<j) {
				
				while(arr[i]<pivot && i<high) {  
					i++;
				}
				while(arr[j]>pivot && j>low) {  
					j--;
				}
				if(i<j) {
				int temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
				}
			}
					
			quick_sort(arr,low,j-1);	
			quick_sort(arr,j+1,high);
		}
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
			
			System.out.print("ORIGINAL ARRAY :");
			for(int i=0;i<arr.length;i++) {
				System.out.print(arr[i]+" ");
			}
		
		quick_sort(arr,0,arr.length-1);
		
		System.out.print("\n\nQUICK SORT SORTED ARRAY :");
		for(int i=0;i<arr.length;i++)
		System.out.print(arr[i]+" ");
		}
	}
