package dsa_package;

import java.util.Arrays;

public class Merge_sort {

	static void mergesort(int arr[],int low,int high) {
		
		if(low<high) {
		
		int mid = (low+high)/2;
		
		mergesort(arr,low,mid);
		mergesort(arr,mid+1,high);
		merge(arr,low,mid,high);
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
		
		int arr[]=new int[] {6,20,4,9,100,1,10,8,50,2,5};
		
		mergesort(arr,0,arr.length-1);
		
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}
}
