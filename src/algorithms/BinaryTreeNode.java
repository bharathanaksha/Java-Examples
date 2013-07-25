package algorithms;

public class BinaryTreeNode<E> {
	private BinaryTreeNode<E> left, right;
	private E data;

	public BinaryTreeNode(E data, BinaryTreeNode<E> left,
			BinaryTreeNode<E> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public BinaryTreeNode(E data) {
		this(data, null, null);
	}

	public E getData() {
		return data;
	}

	public BinaryTreeNode<E> left() {
		return left;
	}

	public BinaryTreeNode<E> right() {
		return right;
	}

	public boolean isLeaf() {
		return (left == null && right == null);
	}

}
