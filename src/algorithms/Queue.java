package algorithms;


public class Queue<E> {
	private int size = 0;

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
		while (node.next != null) {
			node = node.next;
		}
		return node;
	}

	public void insert(E ele) {
		if (head == null) {
			head = new Node<E>(ele, null);
			return;
		}
		Node<E> tail = getTailNode();

		System.out.println("Queue.insert()" + tail);
		tail.next = new Node<E>(ele, null);
	}

	public Node<E> remove() {
		if (head == null) {
			return null;
		}
		Node<E> node = head;
		head = node.next;
		return node;
	}

	public void print() {
		Node<E> node = head;
		while (node != null) {
			System.out.print(node.element + " => ");
			node = node.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Queue<String> queue = new Queue<String>();

		queue.insert("ABC");
		queue.insert("BCD");
		queue.insert("CDE");
		queue.insert("DEF");

		queue.print();

		System.out.println("After REM = " + queue.remove().element);
		System.out.println("After REM = " + queue.remove().element);
		System.out.println("After REM = " + queue.remove().element);
		System.out.println("After REM = " + queue.remove().element);
	}

}
