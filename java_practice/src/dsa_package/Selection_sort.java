package dsa_package;

import java.util.Scanner;

public class Selection_sort {

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
		
		for(int i=0;i<arr.length-1;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]>arr[j]) {
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		
		System.out.print("\n\nSORTED ARRAY :");
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}
}
