package algorithms;

public class Tree<E> {

	private Node<E> rootNode;

	public Tree(Node<E> rootNode) {
		this.rootNode = rootNode;
	}

	public Node<E> getChildAt(int childIndex) {
		return rootNode.getChildAt(childIndex);
	}

	public int getChildCount() {
		return rootNode.getChildCount();
	}

	public int getIndex(Node<E> node) {
		return rootNode.getIndex(node);
	}

	public void printTree() {
		System.out.println("R = " + rootNode.getNodeData());
		for (int i = 0; i < rootNode.getChildCount(); i++) {
			printChildrens(rootNode.getChildAt(i));
		}
	}

	private void printChildrens(Node<E> node) {
		if (node.isLeaf()) {
			System.out.println("L = " + node.getNodeData() + "(P = "
					+ node.getParent().getNodeData() + ")");
			return;
		} else {
			System.out.println("B = " + node.getNodeData());
		}
		for (int i = 0; i < rootNode.getChildCount(); i++) {
			printChildrens(node.getChildAt(i));
		}
	}

	public static void main(String[] args) {
		Node<Integer> rootNode = new Node<Integer>(100, null);

		Node<Integer> child1 = new Node<Integer>(10, rootNode);
		Node<Integer> child2 = new Node<Integer>(12, child1);
		Node<Integer> child3 = new Node<Integer>(15, child1);
		child1.addChild(child2);
		child1.addChild(child3);

		Node<Integer> child6 = new Node<Integer>(14, rootNode);
		Node<Integer> child4 = new Node<Integer>(15, child6);
		Node<Integer> child5 = new Node<Integer>(16, child6);
		child6.addChild(child4);
		child6.addChild(child5);

		rootNode.addChild(child1);
		rootNode.addChild(child6);

		Tree<Integer> tree = new Tree<Integer>(rootNode);
		tree.toString();
	}
}
