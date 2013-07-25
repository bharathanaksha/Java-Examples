package algorithms;

import java.util.ArrayList;

public class Node<E> {
	E nodeData;
	ArrayList<Node<E>> childrens;
	Node<E> parent;

	public Node(E data,Node<E> parent) {
		this.childrens = new ArrayList<Node<E>>();
		this.nodeData = data;
		this.parent = parent;
	}

	public E getNodeData() {
		return nodeData;
	}

	public Node<E> getChildAt(int childIndex) {
		if (childrens.size() > 0) {
			return childrens.get(childIndex);
		}
		return null;
	}

	public void addChild(Node<E> node) {
		childrens.add(node);
	}

	public int getChildCount() {
		return childrens.size();
	}

	public int getIndex(Node<E> node) {
		if (childrens.size() > 0) {
			return childrens.indexOf(node);
		}
		return -1;
	}

	public Node<E> getParent() {
		return parent;
	}

	public boolean isLeaf() {
		return childrens.size() == 0;
	}

}
