package algorithms;

public class BinaryTree<E> {

	private BinaryTreeNode<E> rootNode;

	private static final boolean DEBUG = true;

	public BinaryTree(BinaryTreeNode<E> rootNode) {
		this.rootNode = rootNode;
	}

	public boolean isMirror() {
		if (rootNode.isLeaf()) {
			print("MIRROR : (REASON:ROOT NODE IS LEAF)");
			return true;
		} else if (isAnyNodenull(rootNode.left(), rootNode.right())) {
			return false;
		}
		return isMirrorImpl(rootNode.left(), rootNode.right());
	}

	public int getDepth() {
		return getDepthImpl(rootNode);
	}

	private int getDepthImpl(BinaryTreeNode<E> node) {

		if (node == null) {
			return 0;
		}
		int left = getDepthImpl(node.left()) + 1;
		int right = getDepthImpl(node.right()) + 1;
		return Math.max(left, right);
	}

	private boolean isMirrorImpl(BinaryTreeNode<E> left, BinaryTreeNode<E> right) {

		if (!(left.getData().equals(right.getData()))) {
			print("NOT A MIRROR (REASON :NODES ARE NOT MIRROR)");
			return false;
		}
		if (left.isLeaf() && right.isLeaf()) {
			print("MIRROR : (REASON:ALL LEAF NODES REACHED)");
			return true;
		}
		BinaryTreeNode<E> leftLeft = left.left(), rightRight = right.right(), leftRight = left.right(), rightLeft = right.left();

		if (isAnyNodenull(leftLeft, rightRight) || isAnyNodenull(leftRight, rightLeft)) {
			return false;
		}

		if (leftRight == null && rightLeft == null) {
			print("EDGE CASE 1:(leftRight == null && rightLeft == null)");
			return isMirrorImpl(leftLeft, rightRight);
		}

		if (leftLeft == null && rightRight == null) {
			print("EDGE CASE 2:(leftLeft == null && rightRight == null)");
			return isMirrorImpl(leftRight, rightLeft);
		}

		print("leftLeft = " + leftLeft.getData() + " == " + "rightRight = " + rightRight.getData());
		print("leftRight = " + leftRight.getData() + " == " + "rightLeft = " + rightLeft.getData());

		return isMirrorImpl(leftLeft, rightRight) && isMirrorImpl(leftRight, rightLeft);
	}

	private boolean isAnyNodenull(BinaryTreeNode<E> node1, BinaryTreeNode<E> node2) {
		if ((node1 == null && node2 != null) || (node1 != null && node2 == null)) {
			print("NOT A MiRROR : (REASON: node1 or node2 is null)");
			return true;
		}
		return false;
	}

	private void print(String str) {
		if (DEBUG) System.out.println(str);
	}

	public static void main(String[] args) {
		{
			BinaryTreeNode<Integer> node5 = new BinaryTreeNode<Integer>(15);
			BinaryTreeNode<Integer> node6 = new BinaryTreeNode<Integer>(16);
			BinaryTreeNode<Integer> node7 = new BinaryTreeNode<Integer>(17);
			BinaryTreeNode<Integer> node8 = new BinaryTreeNode<Integer>(18);

			BinaryTreeNode<Integer> node3 = new BinaryTreeNode<Integer>(13, node5, node6);
			BinaryTreeNode<Integer> node4 = new BinaryTreeNode<Integer>(14, node7, node8);

			BinaryTreeNode<Integer> node33 = new BinaryTreeNode<Integer>(13, node6, node5);
			BinaryTreeNode<Integer> node44 = new BinaryTreeNode<Integer>(14, node8, node7);

			BinaryTreeNode<Integer> node1 = new BinaryTreeNode<Integer>(12, node3, node4);
			BinaryTreeNode<Integer> node2 = new BinaryTreeNode<Integer>(12, node44, node33);
			BinaryTreeNode<Integer> rootNode = new BinaryTreeNode<Integer>(100, node1, node2);
			BinaryTree<Integer> binaryTree = new BinaryTree<Integer>(rootNode);

			System.out.println("----------TEST-1 -----");
			System.out.println("TEST-1 IS MIRROR = " + binaryTree.isMirror());
		}

		{

			BinaryTreeNode<Integer> node6 = new BinaryTreeNode<Integer>(16);
			BinaryTreeNode<Integer> node7 = new BinaryTreeNode<Integer>(17);
			BinaryTreeNode<Integer> node8 = new BinaryTreeNode<Integer>(18);

			BinaryTreeNode<Integer> node3 = new BinaryTreeNode<Integer>(13, null, node6);
			BinaryTreeNode<Integer> node4 = new BinaryTreeNode<Integer>(14, node7, node8);

			BinaryTreeNode<Integer> node33 = new BinaryTreeNode<Integer>(13, node6, null);
			BinaryTreeNode<Integer> node44 = new BinaryTreeNode<Integer>(14, node8, node7);

			BinaryTreeNode<Integer> node1 = new BinaryTreeNode<Integer>(12, node3, node4);
			BinaryTreeNode<Integer> node2 = new BinaryTreeNode<Integer>(12, node44, node33);
			BinaryTreeNode<Integer> rootNode = new BinaryTreeNode<Integer>(100, node1, node2);
			BinaryTree<Integer> binaryTree = new BinaryTree<Integer>(rootNode);

			System.out.println("----------TEST-2 -----");
			System.out.println("TEST-2 IS MIRROR = " + binaryTree.isMirror());
		}

		{
			BinaryTreeNode<Integer> node5 = new BinaryTreeNode<Integer>(15);
			BinaryTreeNode<Integer> node6 = new BinaryTreeNode<Integer>(16);
			BinaryTreeNode<Integer> node7 = new BinaryTreeNode<Integer>(17);
			BinaryTreeNode<Integer> node8 = new BinaryTreeNode<Integer>(18);

			BinaryTreeNode<Integer> node3 = new BinaryTreeNode<Integer>(13, node5, node6);
			BinaryTreeNode<Integer> node4 = new BinaryTreeNode<Integer>(14, node7, node8);

			BinaryTreeNode<Integer> node33 = new BinaryTreeNode<Integer>(13, node6, null);
			BinaryTreeNode<Integer> node44 = new BinaryTreeNode<Integer>(14, node8, node7);

			BinaryTreeNode<Integer> node1 = new BinaryTreeNode<Integer>(12, node3, node4);
			BinaryTreeNode<Integer> node2 = new BinaryTreeNode<Integer>(12, node44, node33);
			BinaryTreeNode<Integer> rootNode = new BinaryTreeNode<Integer>(100, node1, node2);
			BinaryTree<Integer> binaryTree = new BinaryTree<Integer>(rootNode);

			System.out.println("----------TEST-3 -----");
			System.out.println("TEST-3 IS MIRROR = " + binaryTree.isMirror());
		}

		{
			BinaryTreeNode<Integer> rootNode = new BinaryTreeNode<Integer>(100);
			BinaryTree<Integer> binaryTree = new BinaryTree<Integer>(rootNode);
			System.out.println("----------TEST-4 -----");
			System.out.println("TEST-4 IS MIRROR = " + binaryTree.isMirror());
		}
		{
			BinaryTreeNode<Integer> node1 = new BinaryTreeNode<Integer>(13);
			BinaryTreeNode<Integer> node2 = new BinaryTreeNode<Integer>(12);
			BinaryTreeNode<Integer> rootNode = new BinaryTreeNode<Integer>(100, node1, node2);
			BinaryTree<Integer> binaryTree = new BinaryTree<Integer>(rootNode);

			System.out.println("----------TEST-5 -----");
			System.out.println("TEST-5 IS MIRROR = " + binaryTree.isMirror());
		}
		
		{
			BinaryTreeNode<Integer> node9 = new BinaryTreeNode<Integer>(15);
			BinaryTreeNode<Integer> node10 = new BinaryTreeNode<Integer>(15,node9,null);
			BinaryTreeNode<Integer> node5 = new BinaryTreeNode<Integer>(15,node10,null);
			BinaryTreeNode<Integer> node6 = new BinaryTreeNode<Integer>(16);
			BinaryTreeNode<Integer> node7 = new BinaryTreeNode<Integer>(17);
			BinaryTreeNode<Integer> node8 = new BinaryTreeNode<Integer>(18);

			BinaryTreeNode<Integer> node3 = new BinaryTreeNode<Integer>(13, node5, node6);
			BinaryTreeNode<Integer> node4 = new BinaryTreeNode<Integer>(14, node7, node8);

			BinaryTreeNode<Integer> node33 = new BinaryTreeNode<Integer>(13, node6, node5);
			BinaryTreeNode<Integer> node44 = new BinaryTreeNode<Integer>(14, node8, node7);

			BinaryTreeNode<Integer> node1 = new BinaryTreeNode<Integer>(12, node3, node4);
			BinaryTreeNode<Integer> node2 = new BinaryTreeNode<Integer>(12, node44, node33);
			BinaryTreeNode<Integer> rootNode = new BinaryTreeNode<Integer>(100, node1, node2);
			BinaryTree<Integer> binaryTree = new BinaryTree<Integer>(rootNode);

			System.out.println("----------TEST-1 -----");
			System.out.println("DEPTH = " + binaryTree.getDepth());
		}

		
		
		
	}

}
