package algorithms;


public class SinglyLinkedList<E> {

	private Node<E> head;

	class Node<E> {
		E element;
		Node<E> next;

		public Node(E e, Node<E> next) {
			this.element = e;
			this.next = next;
		}
	}

	private Node<E> getTailNode() {
		Node<E> node = head;
		while (node.next != null)
			node = node.next;
		return node;
	}

	public void addFirst(E ele) {
		if (head == null) {
			head = new Node<E>(ele, null);
		} else {
			Node<E> node = new Node<E>(ele, head);
			head = node;
		}
	}

	public void addLast(E ele) {
		if (head == null) {
			head = new Node<E>(ele, null);
		} else {
			Node<E> tailNode = getTailNode();
			Node<E> node = new Node<E>(ele, null);
			tailNode.next = node;
		}
	}

	public boolean remove(E item) {
		if (head == null) {
			return false;
		}
		Node<E> node = head;
		if (node.element.equals(item)) {
			head = head.next;
			return true;
		}

		while (node.next != null) {
			if (node.next.element.equals(item)) {
				node.next = node.next.next;
				return true;
			}
			node = node.next;
		}
		return false;
	}

	public boolean removeRec(E item) {
		head = remove(head, item);
		return true;
	}

	private Node<E> remove(Node<E> node, E item) {
		if (node == null) {
			return null;
		}
		if (node.element.equals(item)) {
			Node<E> temp = node.next;
			node.next = null;
			node = temp;
		} else {
			node.next = remove(node.next, item);
		}
		return node;
	}

	public void makeCircular() {
		Node<E> tailNode = getTailNode();
		System.out.println("SinglyLinkedList.makeCircular() = "
				+ tailNode.element);
		tailNode.next = head;
		System.out.println("SinglyLinkedList.makeCircular()"
				+ tailNode.next.element);
	}

	/**
	 * finding the middle element in one pass , here the idea is:-
	 * 
	 * maintain 2 pointers :- one pointer for the will update in each iteration.
	 * where as other pointer will update on every 2nd iteration.
	 * 
	 * so at the end of the iteration , the second pointer will point to the
	 * second element.
	 */
	public E findMiddleInOnePass() {
		Node<E> firstPointer = head;
		Node<E> secondPointer = head;
		int length = 0;
		while (firstPointer.next != null) {
			length++;
			if (length % 2 == 0) {
				secondPointer = secondPointer.next;
			}
			firstPointer = firstPointer.next;
		}
		return secondPointer.element;
	}

	/**
	 * 
	 * Finding the element at the certain position from the end.
	 * 
	 * Here the idea is :- Maintain 2 pointers firstPointer and secondPointer
	 * 
	 * update the first pointer up to (pos-1) times initially , then update the
	 * second pointer and first pointer till the first pointer points to the
	 * tail node.
	 * 
	 * @param pos
	 * @return
	 */
	public E findElementAtIndexFromEnd(int pos) {
		Node<E> firstPointer = head;
		Node<E> secondPointer = head;
		int length = 0;
		while (length < (pos - 1)) {
			if (firstPointer.next == null) {
				return null;
			}
			length++;
			firstPointer = firstPointer.next;
		}
		while (firstPointer.next != null) {
			firstPointer = firstPointer.next;
			secondPointer = secondPointer.next;
		}

		return secondPointer.element;
	}

	public boolean isCircular() {
		Node<E> firstPointer = head;
		Node<E> secondPointer = head;
		int length = 0;
		while (firstPointer.next != null) {
			length++;
			if (length % 2 == 0) {
				secondPointer = secondPointer.next;
			}
			firstPointer = firstPointer.next;
			System.out.println("firstPointer = " + firstPointer);
			System.out.println("secondPointer = " + secondPointer);
			if (firstPointer == secondPointer) {
				return true;
			}
		}
		return false;
	}

	public void reverse() {
		if (head == null || head.next == null) {
			return;
		}
		Node<E> curr = head;
		Node<E> next = head.next, loop = null;

		while (next != null) {
			curr.next = loop;
			loop = curr;
			curr = next;
			next = next.next;
		}
		curr.next = loop;
		head = curr;
	}

	public void rotateLeft(int n) {
		if (head == null || head.next == null) {
			return;
		}

		Node<E> headNode = head;
		Node<E> tailNode = getTailNode();
		while (n > 0) {

			head = headNode.next;
			tailNode.next = headNode;
			headNode.next = null;

			tailNode = headNode;
			headNode = head;
			n--;
		}
	}

	private Node<E> getPrevTailNode() {

		Node<E> node = head, prevTailNode = head;
		if (node.next != null) {
			node = node.next;
		}
		while (node.next != null) {
			node = node.next;
			prevTailNode = prevTailNode.next;
		}

		System.out.println("prevTailNode = " + prevTailNode.element);

		return prevTailNode;

	}

	public void rotateRight(int n) {
		if (head == null || head.next == null) {
			return;
		}

		while (n > 0) {
			Node<E> headNode = head;
			Node<E> prevtailNode = getPrevTailNode();

			head = prevtailNode.next;
			prevtailNode.next.next = headNode;
			prevtailNode.next = null;

			n--;
		}
	}

	public void print() {
		if (head == null) {
			System.out.println("NO ELEMENTS");
		} else {
			Node<E> node = head;
			while (node != null) {
				System.out.print("--> " + node.element);
				node = node.next;
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		System.out.println("SinglyLinkedList.main()>>>>>>>>>>>>>");

		SinglyLinkedList<String> linkedList = new SinglyLinkedList<String>();
		linkedList.addFirst("ABC");

		linkedList.addFirst("BCD");

		linkedList.addFirst("CDE");

		linkedList.addLast("XYZ");

		linkedList.addLast("WXY");

		linkedList.print();
		String midEle = linkedList.findMiddleInOnePass();
		System.out.println("Mid ELe = " + midEle);

		linkedList.addLast("VWX");
		linkedList.addLast("UVW");
		linkedList.print();

		linkedList.rotateLeft(3);

		System.out.println("After Rotating");
		linkedList.print();

		linkedList.getPrevTailNode();

		midEle = linkedList.findMiddleInOnePass();
		System.out.println("Mid ELe = " + midEle);

		System.out.println("ELE at 3rd pos from End is = "
				+ linkedList.findElementAtIndexFromEnd(3));
		System.out.println("ELE at 3rd pos from End is = "
				+ linkedList.findElementAtIndexFromEnd(5));

		// linkedList.makeCircular();
		System.out.println("IS CIRCULAR = " + linkedList.isCircular());

		linkedList.reverse();

		linkedList.print();

		linkedList.remove("XYZ");

		linkedList.print();

		linkedList.remove("UVW");

		linkedList.print();

		System.out.println("SinglyLinkedList REMOVE NODE REC = "
				+ linkedList.removeRec("VWX"));
		linkedList.print();

		System.out.println("SinglyLinkedList REMOVE NODE REC = "
				+ linkedList.removeRec("VWX"));
		linkedList.print();

		System.out.println("SinglyLinkedList REMOVE NODE REC = "
				+ linkedList.removeRec("BCD"));
		linkedList.print();
	}

}
