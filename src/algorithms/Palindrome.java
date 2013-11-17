package algorithms;

public class Palindrome {

	public boolean testPalindrome(int num) {
		int tempNum = num, res = 0;
		while (tempNum != 0) {
			int x = tempNum % 10;
			tempNum = tempNum / 10;
			res = (res * 10) + x;
		}
		return num == res;
	}

	public boolean testPalindrome(String testStr) {
		String tempString = new StringBuffer(testStr).reverse().toString();
		return tempString.equals(testStr);
	}

	public static void main(String[] args) {
		Palindrome palindrome = new Palindrome();
		System.out.println("*************Palindrome tests");

		System.out.println("palindrome test for 121 => "
				+ palindrome.testPalindrome(121));

		System.out.println("palindrome test for 125 => "
				+ palindrome.testPalindrome(125));

		System.out.println("palindrome test for 1221 => "
				+ palindrome.testPalindrome(1221));

		System.out.println("palindrome test for 1 => "
				+ palindrome.testPalindrome(1));

		System.out.println("palindrome test for 10 => "
				+ palindrome.testPalindrome(10));

		System.out.println("palindrome test for 11 => "
				+ palindrome.testPalindrome(11));

		System.out.println("palindrome test for 333 => "
				+ palindrome.testPalindrome(333));
		
		System.out.println("palindrome test for aabbaa => "
				+ palindrome.testPalindrome("aabbaa"));
		
		System.out.println("palindrome test for abbaa => "
				+ palindrome.testPalindrome("abbaa"));
	}

}
