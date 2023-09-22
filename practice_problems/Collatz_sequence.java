import java.math.BigInteger;
import java.util.Scanner;

public class Collatz_sequence {

	static void sequence_generate(BigInteger n) {
		
		System.out.print(n);
		
		if(!n.equals(BigInteger.valueOf(1))) {
			
			if(n.mod(BigInteger.valueOf(2)).equals(BigInteger.valueOf(0))) {
				n=n.divide(BigInteger.valueOf(2));
			}else {
				n=(BigInteger.valueOf(3).multiply(n)).add(BigInteger.valueOf(1));
			}
			System.out.print("-->");
		    sequence_generate(n);
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.print("ENTER THE NUMBER : ");
		String s=sc.next();
		
		BigInteger n = new BigInteger(s);
		
		sequence_generate(n);
	}
}
