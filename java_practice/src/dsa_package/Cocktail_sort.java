package dsa_package;

import java.util.Scanner;

public class Cocktail_sort {

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
			
			int start = 0;
			int end =arr.length-1;
			
			int ccount=0;
			
			for(int i=0;i<arr.length;i++) {
						
				for(int j=start;j<end;j++) {
					if(arr[j]>arr[j+1]) {
						int temp=arr[j];
						arr[j]=arr[j+1];
						arr[j+1]=temp;
					}
					ccount++;
				}
				
				for(int k=end;k>start;k--) {
					if(arr[k]<arr[k-1]) {
						int temp=arr[k];
						arr[k]=arr[k-1];
						arr[k-1]=temp;
					}
					ccount++;
				}
				
				start=start+1;
				end=end-1;
				
			}
			
			System.out.print("\n\nCOCKTAIL SORTED ARRAY :");
			for(int i=0;i<arr.length;i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.print("\n"+ ccount);
		}
	}