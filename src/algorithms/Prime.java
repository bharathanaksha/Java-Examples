package algorithms;

public class Prime {

	public static boolean prime(int num) {
		if (num == 0 || num == 1) {
			return false;
		}

		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void primeSeq(int num) {
		for (int i = 2; i < num; i++) {
			boolean isPrime = true;
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					isPrime = false;
				}
			}
			if (isPrime) {
				System.out.print(" " + i);
			}

		}
	}

	public static void main(String[] args) {
		System.out.println("Prime- is 5 prime number = " + Prime.prime(5));
		System.out.println("Prime- is 2 prime number = " + Prime.prime(2));
		System.out.println("Prime- is 4 prime number = " + Prime.prime(4));
		System.out.println("Prime- is 11 prime number = " + Prime.prime(11));

		System.out.println("Prime numbers between 1-100 is >> ");
		Prime.primeSeq(100);
	}

}
