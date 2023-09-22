package dsa_package;

public class Quick_sort {

	static void quick_sort(int arr[],int low,int high) {
		
		if(low<high) {
			
		int pivot = high; //low(left)
		int i=low;
		int j=high;
		
		while(i<j) {
			
			while(arr[i]<arr[pivot] && i<high) {  
				i++;
			}
			while(arr[j]>arr[pivot] && j>low) {  
				j--;
			}
			if(i<j) {
			int temp=arr[i];
			arr[i]=arr[j];
			arr[j]=temp;
			}
		}

		int temp = arr[j];
		arr[j]=arr[pivot];
		arr[pivot]=temp;
				
		quick_sort(arr,low,j-1);	
		quick_sort(arr,j+1,high);
	}
}
	
	public static void main(String[] args) {
		
	int arr[]=new int[] {4,100,1,10,7,3,9,6,5,8,2};
	
	quick_sort(arr,0,arr.length-1);
	
	for(int i=0;i<arr.length;i++)
	System.out.println(arr[i]);
	}
}
