public class Collatz_sequence {

	static void sequence_generate() {

		long n = 1000000;
		long max = 0;
		long value = 0;

		while (n > 0) {
			long count = 1;
			long i = n;
			while (i > 1) {
				if (i % 2 == 0) {
					i = i / 2;
				} else {
					i = (3 * i) + 1;
				}
				count++;
			}
			if (count > max) {
				max = count;
				value = n;
			}
			n--;
		}

		System.out.println("MAXIMUM COUNT :" + max);
		System.out.println("NUMBER IS :" + value);
	}

	public static void main(String[] args) {
		sequence_generate();
	}
}
