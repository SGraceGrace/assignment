package dsa_package;

import java.util.Arrays;
import java.util.Scanner;

public class Merge_sort {

	static void mergesort(int arr[],int low,int high) {
		
		if(low<high) {
		
		int mid = (low+high)/2;
		
//		System.out.println();
//		for(int i=low;i<=mid;i++) {
//			System.out.print(arr[i]+" ");
//		}
//		System.out.print("| ");
//		for(int i=mid+1;i<=high;i++) {
//			System.out.print(arr[i]+" ");
//		}
		
		mergesort(arr,low,mid);
		mergesort(arr,mid+1,high);
		merge(arr,low,mid,high);
		
//		System.out.print("\nsorted :");
//		for(int k=low;k<=high;k++) {
//			System.out.print(arr[k]+" ");
//		}
		}
	}
	static void merge(int arr[],int low,int mid,int high) {

		int i=low;
		int j=high;
		
		while(i<=high && j> low) {
		if(arr[i]>arr[j]) {
			int temp=arr[i];
			arr[i]=arr[j];
			arr[j]=temp;
		}
		i++;
		if(i==j) {
			i=low;
			j--;
		}
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
		
		mergesort(arr,0,arr.length-1);
		
		System.out.print("\n\nMERGE SORT : ");
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}
}
