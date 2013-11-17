package algorithms;

public class Stack<E> {

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

	public Stack() {
	}

	public void push(E item) {
		if (head == null) {
			head = new Node<E>(item, null);
		} else {
			Node<E> node = new Node<E>(item, head);
			head = node;
		}
		size++;
	}

	public E pop() {
		if (size == 0) {
			System.out.println("Stack.pop() UNDERFLOW");
			return null;
		}

		Node<E> node = head;
		head = node.next;
		size--;
		return node.element;
	}

	public int getSize() {
		return size;
	}

	public void reverse() {
		head = reverse(head);
	}

	private Node<E> reverse(Node<E> node) {
		if (node == null || node.next == null) {
			return node;
		}
		Node<E> curr = node;
		Node<E> next = node.next;
		curr.next = null;
		Node<E> lastNode = reverse(next);
		
		System.out.println("Stack.reverse()>>>>"+curr.element);
		System.out.println("Stack.reverse()>>>> next = "+next.element);
		next.next = curr;
		return lastNode;
		
	}
	
//	private Node reverse(Node node) {
//        if (node.nextNode == null) {
//                return node;
//        }
//        Node current = node;
//        Node next = node.nextNode;
//        current.nextNode = null;
//        Node lastNode = reverse(next);
//        next.nextNode = current;
//        return lastNode;
//}

	public void print() {
		Node<E> node = head;
		while (node != null) {
			System.out.print(node.element + " <= ");
			node = node.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();

		stack.push("ABC");
		stack.push("BCD");
		stack.push("CDE");
		stack.push("DEF");

		stack.print();
		stack.reverse();
		System.out.println("After Reverse>>>>>");
		stack.print();

		stack.pop();
		System.out.println("After POP()");
		stack.print();

		stack.pop();
		System.out.println("After POP()");
		stack.print();

		stack.pop();
		System.out.println("After POP()");
		stack.print();

		stack.pop();
		System.out.println("After POP()");
		stack.print();
	}

}
