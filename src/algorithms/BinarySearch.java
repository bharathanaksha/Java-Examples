package algorithms;

public class BinarySearch {

	public static int binarySearch(int[] arr, int key) {
		int low = 0, high = arr.length;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] == key) {
				return mid;
			}
			if (key < arr[mid]) {
				high = mid - 1;
			} else if (key > arr[mid]) {
				low = mid + 1;
			}
		}
		return -1;
	}

	public static int binarySearchRec(final int[] arr, final int key) {

		class BS {
			int foundPos = -1;

			int bs(int low, int high) {

				if (low <= high) {
					int mid = (low + high) / 2;
					if (arr[mid] == key) {
						foundPos = mid;
					}
					if (key < arr[mid]) {
						bs(low, mid - 1);
					} else if (key > arr[mid]) {
						bs(mid + 1, high);
					}
				}

				return foundPos;

			}
		}

		return new BS().bs(0, arr.length - 1);
	}

	public static void main(String[] args) {
		int[] arr = { 10, 12, 15, 17, 18, 34, 56, 78 };
		System.out.println("BinarySearch element found at position = "
				+ BinarySearch.binarySearch(arr, 18));
		System.out.println("BinarySearch element found at position = "
				+ BinarySearch.binarySearch(arr, 10));
		System.out.println("BinarySearch element found at position = "
				+ BinarySearch.binarySearch(arr, 78));
		System.out.println("BinarySearch element found at position = "
				+ BinarySearch.binarySearch(arr, 17));

		System.out.println("BinarySearch element found at position = "
				+ BinarySearch.binarySearchRec(arr, 18));
		System.out.println("BinarySearch element found at position = "
				+ BinarySearch.binarySearchRec(arr, 10));
		System.out.println("BinarySearch element found at position = "
				+ BinarySearch.binarySearchRec(arr, 78));
		System.out.println("BinarySearch element found at position = "
				+ BinarySearch.binarySearchRec(arr, 17));
	}

}
