package algorithms;

public class Sorting {

	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(" " + arr[i]);
		}
	}

	public static void bubbleSort(int[] arr) {
		System.out.println("Sorting.bubbleSort() Before sorting ");
		Sorting.print(arr);
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
		System.out.println("Sorting.bubbleSort() After sorting ");
		Sorting.print(arr);
	}

	public static void quickSort(final int[] arr) {

		class QS {
			private void quickSrt(int low, int high) {
				int i = low, j = high;
				System.out.println("i = " + i + " j = " + j);

				if (i <= j) {
					int mid = low + ((high - low) / 2);
					int pivot = arr[mid];
					while (arr[i] < pivot) {
						i++;
					}
					while (arr[j] > pivot) {
						j--;
					}

					if (i <= j) {
						int temp = arr[j];
						arr[j] = arr[i];
						arr[i] = temp;
						i++;
						j--;
					}

					if (low < j) {
						quickSrt(low, j);
					}
					if (i < high) {
						quickSrt(i, high);
					}
				}
			}
		}

		System.out.println("Sorting.quickSort() before sorting ");
		print(arr);

		QS qs = new QS();
		qs.quickSrt(0, arr.length - 1);

		System.out.println("Sorting.quickSort() after sorting ");
		print(arr);
	}

	public static void main(String[] args) {
		int[] arr = { 13, 46, 32, 12, 3, 5, 16, 6, 6 };
		Sorting.bubbleSort(arr);
		int[] arr2 = { 13, 46, 32, 12, 3, 5, 16, 6, 6 };
		Sorting.quickSort(arr2);
	}

}
