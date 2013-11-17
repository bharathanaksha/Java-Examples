package algorithms;

public class Sequence {

	public static int sequence(int[] arr) {
		int maxSum, tempSum;
		tempSum = arr[0];
		maxSum = tempSum;
		for (int i = 1; i < arr.length; i++) {
			int curr = arr[i];
			tempSum = tempSum + curr;
			tempSum = tempSum > curr ? tempSum : curr;
			if (maxSum < tempSum) {
				maxSum = tempSum;
			}
		}
		return maxSum;
	}

	public static void main(String[] args) {
		int[] arr1 = { 10, 21, -100, 15, -12, 21, 31 };
		int[] arr2 = { -10, -21, -100, -15, -12, -21, -31 };
		int res = Sequence.sequence(arr1);
		System.out.println("Test 1 Result = " + res);
		int res2 = Sequence.sequence(arr2);
		System.out.println("Test 1 Result = " + res2);
	}

}
