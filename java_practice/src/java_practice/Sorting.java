package java_practice;

public class Sorting {
    public static void main(String[] args) {
		int arr[]=new int[] {8,9,7,6,5};
		int l=0;
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length;j++) {
				l++;
				if(arr[i]>arr[j]) {
					int t = arr[i];
					arr[i]=arr[j];
					arr[j]=t;
				}
			}
		}
		System.out.println(l);
		for(int k=0;k<arr.length;k++) {
			System.out.print(arr[k]+" ");
		}
	}
}
