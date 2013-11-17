package algorithms;

public class Fibonnaci {

	public static void fibonnaci(int num) {
		int num1 = 0;
		int num2 = 1;
		System.out.println(" " + num1 + " " + num2);
		while (num2 < 100) {
			int num3 = num1 + num2;
			num1 = num2;
			num2 = num3;
			System.out.println(" " + num3);
		}
	}

	public static int fibonnaciRec(int n) {
		if (n == 0 || n == 1)
			return n;
		return fibonnaciRec(n - 1) + fibonnaciRec(n - 2);
	}

	public static void main(String[] args) {
	    Fibonnaci.fibonnaci(100);
		for (int i = 0; i <= 10; i++) {
			System.out.print("\n" + Fibonnaci.fibonnaciRec(i));
		}
		

	}

}
