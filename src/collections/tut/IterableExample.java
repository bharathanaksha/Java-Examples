package collections.tut;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * This example shows how to use Iterable interface which allows an EmployeeList object to be the target of the "foreach" statement.
 * 
 * @author bharathkumarr
 * 
 */

public class IterableExample {

	public static void main(String[] args) {
		EmployeeList list = new EmployeeList();

		for (String name : list) {
			System.out.println(name);
		}
	}
}

class EmployeeList implements Iterable<String> {

	List<String> list = new ArrayList<String>();

	public EmployeeList() {
		list.add("John");
		list.add("BOB");
		list.add("JOE");
		list.add("Luke");
		list.add("Mary");
	}

	@Override
	public Iterator<String> iterator() {
		return new EmployeeListIterator();
	}

	@Override
	public String toString() {
		return list.toString();
	}

	class EmployeeListIterator implements Iterator<String> {
		int i = 0;

		@Override
		public boolean hasNext() {
			return i < list.size();
		}

		@Override
		public String next() {
			return "Employee " + list.get(i++);
		}

		@Override
		public void remove() {
		}

	}
}
