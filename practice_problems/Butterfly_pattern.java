import java.util.*;
public class Butterfly_pattern
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int l=0;
        int j=0;
        for(int i=0;i<n;i++){
            for(l=0;l<=i;l++){
                System.out.print("*");
            }
            for(j=l;j<(2*n)-l;j++){
            System.out.print(" ");
          }
            for(int k=j;k<2*n;k++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=n;i>=0;i--){
            for(l=0;l<i;l++){
                System.out.print("-");
            }
            for(j=l;j<(2*n)-l;j++){
            System.out.print(" ");
            }
            for(int k=j;k<2*n;k++){
                System.out.print("-");
            }
            System.out.println();
        }
    }
}