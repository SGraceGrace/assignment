package dsa_package;

import java.util.Scanner;

public class Array_eg {
     public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.print("ENTER NO.OF.ELEMENT : ");
		int n=sc.nextInt();
		
    	 int arr[]=new int[n];
    	 
    	 for(int i=0;i<n;i++) {
    		 System.out.print("ENTER ELEMENT at " +(i)+ ":");
    		 arr[i]=sc.nextInt();
    		 System.out.println();
    	 }
    	 
    	 System.out.print("ARRAY ELEMENTS : ");
    	 for(int i=0;i<n;i++) {
    		 System.out.print(arr[i]+" ");
    	 } 
    	 
    	 System.out.println();
    	 System.out.print("REVERSE ARRAY ELEMENTS : ");
    	 int l=0;
    	 int h=n-1;
    	 while(l<h) {
    		 int t=arr[l];
    		 arr[l]=arr[h];
    		 arr[h]=t;
    		 l++;
    		 h--;
    	 }
    	 for(int i=0;i<n;i++) {
    		 System.out.print(arr[i]+" ");
    	 }
    	 
    	 System.out.println();
    	 System.out.print("ENTER ELEMENT TO SEARCH : ");
    	 int search=sc.nextInt();
    	 
    	 System.out.println();
    	 for(int i=0;i<n;i++) {
    		 if(arr[i]==search) {
    			 System.out.println("ELEMENT FOUND AT :" +i);
    		 }
    	 }
	}
}
