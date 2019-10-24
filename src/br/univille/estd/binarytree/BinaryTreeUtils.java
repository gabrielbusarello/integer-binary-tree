package br.univille.estd.binarytree;


public class BinaryTreeUtils {

	public static <E> String toStringPreOrder(LinkedBinaryTree<E> T, BTPosition<E> v) {
		String preOrder = v.getElement().toString();
			
		if (T.hasLeft(v)) {
			preOrder += ", " + toStringPreOrder(T, v.getLeft());
		}
		
		if (T.hasRight(v)) {
			preOrder += ", " + toStringPreOrder(T, v.getRight());
		}
		
		return preOrder;
	}
	
	public static <E> String toStringPostOrder(LinkedBinaryTree<E> T, BTPosition<E> v) {
		String postOrder = "";

		if (T.hasLeft(v)) {
			postOrder += toStringPostOrder(T, v.getLeft()) + ", ";
		}

		if (T.hasRight(v)) {
			postOrder += toStringPostOrder(T, v.getRight()) + ", ";
		}
		
		postOrder += v.getElement();

		return postOrder;
	}
	
	public static <E> String toStringInOrder(LinkedBinaryTree<E> T, BTPosition<E> v) {
		String inOrder = "";

		if (T.hasLeft(v)) {
			inOrder += toStringInOrder(T, v.getLeft()) + ", ";
		}
		
		inOrder += v.getElement();
		
		if (T.hasRight(v)) {
			inOrder += ", " + toStringInOrder(T, v.getRight());
		}

		return inOrder;
	}
	
}