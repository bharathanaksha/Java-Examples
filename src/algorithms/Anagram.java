package algorithms;

import java.util.Arrays;
import java.util.HashMap;

public class Anagram {

	public static String[] anagram(String[] arr) {

		HashMap<String, String> hashMap = new HashMap<String, String>();
		for (int i = 0; i < arr.length; i++) {
			String str = arr[i];
			char[] crs = str.toCharArray();
			Arrays.sort(crs);
			arr[i] = new String(crs);
		}
		for (int i = 0; i < arr.length; i++) {
			hashMap.put(arr[i], arr[i]);
		}
		return hashMap.keySet().toArray(new String[hashMap.keySet().size()]);
	}

	public static void main(String[] args) {
		String arr[] = { "cat", "tac", "car", "act" };
		String res[] = Anagram.anagram(arr);
		for (int i = 0; i < res.length; i++) {
			System.out.println("Anagram.main()" + res[i]);
		}
	}

}
