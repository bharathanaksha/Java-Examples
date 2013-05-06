package collections.tut;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * This Examples shows the difference between ArrayList and LinkedList and CopyOnWriteArrayList in inserting the elements at the beginning and at the end of the list.
 * 
 * @author bharathkumarr
 * 
 */
public class ListExample {

	public static void main(String[] args) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<Integer>();
		ListExample.doOperation1("ArrayList", arrayList);
		ListExample.doOperation1("LinkedList", linkedList);
		ListExample.doOperation1("CopyOnWriteArrayList", copyOnWriteArrayList);

		ListExample.doOperation2("ArrayList", arrayList);
		ListExample.doOperation2("LinkedList", linkedList);
		ListExample.doOperation2("CopyOnWriteArrayList", copyOnWriteArrayList);
	}
    
	/**
	 * Array List performance is better considered to Linked List to insert the element at the end.
	 * and CopyOnWriteArrayList is too costly since it is a thread safe variant and all the mutative operations operate on a fresh copy of the list..
	 * @param type
	 * @param list
	 */
	public static void doOperation1(String type, List<Integer> list) {
		long startMillis = System.currentTimeMillis();
		for (int i = 0; i < 1E5; i++) {
			list.add(new Integer(i));
		}
		long endMillies = System.currentTimeMillis();
		System.out.println("Total time taken add elements at the end is  " + (endMillies - startMillis) + "  millisec for " + type);

		startMillis = endMillies = 0;

		list.clear();
	}
	/**
	 * Linked List performance is good considered to Array List to insert the element at the beginning.
	 * and CopyOnWriteArrayList is too costly since it is a thread safe variant and all the mutative operations operate on a fresh copy of the list..
	 * @param type
	 * @param list
	 */
	public static void doOperation2(String type, List<Integer> list) {
		long startMillis = System.currentTimeMillis();
		for (int i = 0; i < 1E5; i++) {
			list.add(0, new Integer(i));
		}
		long endMillies = System.currentTimeMillis();
		System.out.println("Total time taken add elements at the begining is  " + (endMillies - startMillis) + "  millisec for " + type);

		startMillis = endMillies = 0;

		list.clear();
	}

}
