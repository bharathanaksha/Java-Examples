package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicateProblem {

	public static String[] findDuplicatesUsingSet(String[] strArray) {
		HashSet<String> hashSet = new HashSet<String>();
		ArrayList<String> arrayList = new ArrayList<String>();
		for (int i = 0; i < strArray.length; i++) {
			if (!hashSet.add(strArray[i])) {
				arrayList.add(strArray[i]);
			}
		}
		return arrayList.toArray(new String[arrayList.size()]);
	}

	public static String[] findDuplicatesUsingHashMap(String[] strArray) {
		HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
		ArrayList<String> arrayList = new ArrayList<String>();
		for (int i = 0; i < strArray.length; i++) {
			Integer value = hashMap.get(strArray[i]);
			if (value != null) {
				arrayList.add(strArray[i]);
			} else {
				hashMap.put(strArray[i], 1);
			}
		}
		return arrayList.toArray(new String[arrayList.size()]);
	}

	public static boolean checkIfcontainsDuplicate(String[] str) {
		List<String> list = Arrays.asList(str);
		Set<String> set = new HashSet<String>(list);
		return (list.size() > set.size());
	}

	public static boolean checkIfcontainsDuplicate2(String[] str) {

		for (int i = 0; i < str.length; i++) {
			for (int j = i + 1; j < str.length; j++) {
				if (str[i].equals(str[j])) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean checkIfcontainsDuplicate3(String[] arr) {
		Arrays.sort(arr);
		for (int i = 1; i < arr.length; i++)
			if (arr[i] == arr[i - 1])
				return true;

		return false;
	}

	private static void print(String[] duplicates) {
		System.out.println("Duplicates");
		for (int i = 0; i < duplicates.length; i++) {
			System.out.print(" ->" + duplicates[i]);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		String[] strings = { "Bharath", "Bharath", "Test", "Test2", "Test",
				"ABC", "XYZ" };
		String[] strings2 = { "Bharath", "Test", "Test2", "ABC", "XYZ" };
		print(DuplicateProblem.findDuplicatesUsingSet(strings));
		print(DuplicateProblem.findDuplicatesUsingHashMap(strings));
		System.out.println("Contains Duplicate = "
				+ checkIfcontainsDuplicate(strings));
		System.out.println("Contains Duplicate = "
				+ checkIfcontainsDuplicate(strings2));

		System.out.println("Contains Duplicate Brute Force = "
				+ checkIfcontainsDuplicate2(strings));
		System.out.println("Contains Duplicate Brute Force = "
				+ checkIfcontainsDuplicate2(strings2));
		
		System.out.println("Contains Duplicate Brute Force Linear= "
				+ checkIfcontainsDuplicate3(strings));
		System.out.println("Contains Duplicate Brute Force Linear= "
				+ checkIfcontainsDuplicate3(strings2));
	}

}
