package algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 
 * Q 1) Given a binary tree, check whether it’s a binary search tree or not. A
 * 1) If a tree is a binary search tree, then traversing the tree inorder should
 * lead to sorted order of the values in the tree. So, we can perform an inorder
 * traversal and check whether the node values are sorted or not.
 * 
 * 
 * Q 2)Given a Binary Tree, write code to convert it to Binary Search Tree such
 * that the structure of the tree remains the same. A 2)1. Traverse the tree in
 * inorder and store the values in array. 2. Sort the Array. 3. Traverse the
 * tree again in in-order and copy the values from array in the Nodes. Populate
 * the array arr with the inorder traversal of the tree pointed to by r. pos
 * holds a reference to the current poisition of arr.
 * 
 * 
 * Given a binary tree,create the copy of the tree. <br>
 * Given a binary tree, count the number of nodes in the tree. <br>
 * Given a binary tree, find the maximum depth the number of nodes along the
 * longest path from the root node down to the farthest leaf node. <br>
 * Write a code to find the minimum and maximum value in binary search tree
 * Print the BST in increasing order…to put this in different way, it simply
 * means to print in inorder traversal <br>
 * Print the post order traversal (recursive) <br>
 * Print the paths in binary search tree from root to leaves. <br>
 * Get the mirror of Binary tree <br>
 * BST : Binary search tree with double tree BT: <br>
 * How to check whether 2 trees are same or not? BST: <br>
 * How to check whether 2 trees are BST or NOT <br>
 * BST:Return Nth Node in in-order traversal <br>
 * Construct a tree given its inorder and preorder <br>
 * Given an expression tree, calculate the expression <br>
 * Write a code to write DFS and BFS on tree.
 * 
 * 
 * @author Bharath
 * 
 * @param <E>
 */

class Node<E> {
	public E data;
	public Node<E> left, right;

	public Node(E data, Node<E> left, Node<E> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public boolean isLeaf() {
		return left != null || right != null;
	}
}

public class BinarySearchTree<E extends Comparable<E>> {
	private Node<E> root = null;

	private void addImpl(Node<E> node, E data) {
		if (data.compareTo(node.data) == -1) {
			if (node.left == null) {
				Node<E> n = new Node<E>(data, null, null);
				node.left = n;
			} else {
				addImpl(node.left, data);
			}
		} else if (data.compareTo(node.data) == 1) {
			if (node.right == null) {
				Node<E> n = new Node<E>(data, null, null);
				node.right = n;
			} else {
				addImpl(node.right, data);
			}
		} else {
			System.out.println("Duplicate Item Dont insert");
			return;
		}
	}

	private void inOrderImpl(Node<E> node) {
		if (node != null) {
			inOrderImpl(node.left);
			System.out.println(node.data);
			inOrderImpl(node.right);
		}
	}

	private void preOrderImpl(Node<E> node) {
		if (node != null) {
			System.out.println(node.data);
			preOrderImpl(node.left);
			preOrderImpl(node.right);
		}
	}

	private void postOrderImpl(Node<E> node) {
		if (node != null) {
			postOrderImpl(node.left);
			postOrderImpl(node.right);
			System.out.println(node.data);
		}
	}

	public void printAncestors(E item) {
		printAncestorImpl(root, item);
	}

	public void printDesendents(E item) {
		printDesendentsImpl(root, item);
	}

	public void printDesendentsImpl(Node<E> node, E item) {
		if (node == null) {
			return;
		}
		if (node.data == item) {
			postOrderImpl(node.left);
			postOrderImpl(node.right);
			return;
		}
		printDesendentsImpl(node.left, item);
		printDesendentsImpl(node.right, item);
	}

	public void printAllPaths() {
		if (root == null) {
			return;
		}
		ArrayList<E> list = new ArrayList<E>();
		printAllPathsImpl(root, list, 0);
	}

	private void printAllPathsImpl(Node<E> node, List<E> list, int count) {
		if (node == null) {
			return;
		}
		list.add(count, node.data);
		count++;
		if (node.left == null && node.right == null) {
			System.out.println();
			for (E e : list) {
				System.out.print(" " + e);
			}
		}
		printAllPathsImpl(node.left, list, count);
		printAllPathsImpl(node.right, list, count);
	}

	public int getDepth() {
		return getDepthImpl(root);
	}

	public int getDepthImpl(Node<E> node) {
		if (node == null) {
			return 0;
		}
		int left = getDepthImpl(node.left) + 1;
		int right = getDepthImpl(node.right) + 1;
		return Math.max(left, right);
	}

	public boolean printAncestorImpl(Node<E> node, E item) {
		if (node == null) {
			return false;
		}
		if (node.data == item) {
			return true;
		}

		if (printAncestorImpl(node.left, item)
				|| printAncestorImpl(node.right, item)) {
			System.out.println("A = " + node.data);
			return true;
		}

		return false;

	}

	private void printImpl(Node<E> node) {
		if (node != null) {
			System.out.println(" 	       <-N" + node.data + "-> 	 ");

			// print left
			System.out.print("        ");
			if (node.left != null)
				System.out.print("L" + node.left.data + "");
			else {
				System.out.print("NULL");
			}

			// print right
			System.out.print("             ");
			if (node.right != null)
				System.out.print("R" + node.right.data);
			else {
				System.out.print("NULL");
			}
			System.out.println();
			System.out.println();
			printImpl(node.left);
			printImpl(node.right);
		}
	}

	public void addNode(E data) {
		if (root == null) {
			root = new Node<E>(data, null, null);
			return;
		}
		addImpl(root, data);
	}

	public void print() {
		Node<E> node = root;
		printImpl(node);
	}

	public void preorder() {
		preOrderImpl(root);
	}

	public void postorder() {
		postOrderImpl(root);
	}

	public void inorder() {
		inOrderImpl(root);
	}

	public static void main(String[] args) {
		BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<Integer>();
		binarySearchTree.addNode(10);
		binarySearchTree.addNode(13);
		binarySearchTree.addNode(46);
		binarySearchTree.addNode(6);
		binarySearchTree.addNode(5);
		binarySearchTree.addNode(7);
		binarySearchTree.addNode(9);
		binarySearchTree.addNode(9);
		binarySearchTree.print();
		System.out.println("PREORDER->");
		binarySearchTree.preorder();
		System.out.println("POSTORDER->");
		binarySearchTree.postorder();
		System.out.println("INORDER->");
		binarySearchTree.inorder();
		System.out.println("PRINT ANCESTORS-->");
		binarySearchTree.printAncestors(9);
		System.out.println("PRINT DESCENDENTS-->");
		binarySearchTree.printDesendents(6);
		System.out
				.println("DEPTH OF THE TREE = " + binarySearchTree.getDepth());
		System.out.println("PRINTING ALL THE PATHS");
		binarySearchTree.printAllPaths();
	}

}
