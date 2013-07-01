package algorithms;

import java.util.ArrayList;

public class MaximumSequence {

	int[] array;

	public MaximumSequence(int[] array) {
		this.array = array;
	}

	public int sequencer() {
		int highestSeq = 0;
		int intermediate = 0;
		if (array.length > 0) {
			highestSeq = intermediate = array[0];
		}
		for (int i = 1; i < array.length; i++) {
			System.out.println("*****************************");
			int curr = array[i];
			int update = intermediate + curr;
			if (curr > update) {
				intermediate = curr;
				System.out.println("MaximumSequence.sequencer() IF");
			} else {
				intermediate = update;
			}

			if (highestSeq < intermediate) {
				highestSeq = intermediate;
			}
			System.out.println("MaximumSequence.sequencer() intermediate = "
					+ intermediate);
			System.out.println("MaximumSequence.sequencer() highestSeq = "
					+ highestSeq);
		}
		return highestSeq;
	}

	public static void main(String[] args) throws Exception {

		class Data {
			public final int[] array;
			public final int result;

			public Data(int[] array, int result) {
				this.array = array;
				this.result = result;
			}

			public int[] getArray() {
				return array;
			}

			public int getResult() {
				return result;
			}
		}
		ArrayList<Data> list = new ArrayList<Data>();

		int[] array1 = { 100, -2, -2, -10, -100, 0, -50 };
		int[] array2 = { 100, -2, 2, 10, 100, 0, 50 };
		int[] array3 = { -21, -1, -12, -13, -14 };
		int[] array4 = { 1, 2, 3, -100, 100 };
		int[] array5 = { 1, 2, 3, 4, 5 };
		int[] array6 = { 100, -100, -200, 200, 1000 };
		int[] array7 = { 0, -0, -0, 0, 1000 };
		list.add(new Data(array1, 100));
		list.add(new Data(array2, 260));
		list.add(new Data(array3, -1));
		list.add(new Data(array4, 100));
		list.add(new Data(array5, 15));
		list.add(new Data(array6, 1200));
		list.add(new Data(array7, 1000));

		for (int i = 0; i < list.size(); i++) {
			System.out
					.println("++++++++++++START TEST+++++++++++++++++++++++++++");
			Data data = list.get(i);
			MaximumSequence maximumSequence = new MaximumSequence(data
					.getArray());
			int x = maximumSequence.sequencer();
			if (x == data.getResult()) {
				System.out.println("TEST" + i + "PASSED!!!!!"
						+ "Highest sequence is = " + x);
			} else {
				throw new Exception("TEST" + i + "FAILED!!!!!");
			}
			System.out
					.println("++++++++++++END TEST+++++++++++++++++++++++++++");

		}
	}

}
