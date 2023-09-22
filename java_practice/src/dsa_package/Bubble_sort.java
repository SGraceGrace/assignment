package dsa_package;


	import java.util.Scanner;
	
	public class Bubble_sort {

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
			
			int bcount=0;
			for(int i=0;i<arr.length;i++) {
				for(int j=0;j<arr.length-1;j++) {
					if(arr[j]>arr[j+1]) {
						int temp=arr[j];
						arr[j]=arr[j+1];
						arr[j+1]=temp;
					}
					bcount++;
				}
			}
			
			System.out.print("\n\nBUBBLE SORTED ARRAY :");
			for(int i=0;i<arr.length;i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.print("\n"+ bcount);
		}
	}
