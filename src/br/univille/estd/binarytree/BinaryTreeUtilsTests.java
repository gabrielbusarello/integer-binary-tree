package br.univille.estd.binarytree;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class BinaryTreeUtilsTests {
	
	/**
	 * Convertendo a �rvore para String utilizando pretorder
	 */
	@Test
	public void arvoreParaStringPreOrder() {
		LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
		
		BTPosition<Integer> root = tree.addRoot(4);
		BTPosition<Integer> left = tree.insertLeft(root,2);
		BTPosition<Integer> right = tree.insertRight(root,6);

		tree.insertLeft(left, 1);
		tree.insertRight(left, 3);

		tree.insertLeft(right, 5);
		tree.insertRight(right, 7);
		
		assertEquals("String da �rvore partindo da raiz",    "4, 2, 1, 3, 6, 5, 7", BinaryTreeUtils.toStringPreOrder(tree, root));
		assertEquals("String da �rvore partindo do filho esquerda", "2, 1, 3", BinaryTreeUtils.toStringPreOrder(tree, left));
		assertEquals("String da �rvore partindo do filho 2", "6, 5, 7", BinaryTreeUtils.toStringPreOrder(tree, right));
	}
	
	/**
	 * Convertendo a �rvore para String utilizando postorder
	 */
	@Test
	public void arvoreParaStringPostOrder() {
		LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
		
		BTPosition<Integer> root = tree.addRoot(4);
		BTPosition<Integer> left = tree.insertLeft(root,2);
		BTPosition<Integer> right = tree.insertRight(root,6);

		tree.insertLeft(left, 1);
		tree.insertRight(left, 3);

		tree.insertLeft(right, 5);
		tree.insertRight(right, 7);
		
		assertEquals("String da �rvore partindo da raiz",    "1, 3, 2, 5, 7, 6, 4", BinaryTreeUtils.toStringPostOrder(tree, root));
		assertEquals("String da �rvore partindo do filho esquerda", "1, 3, 2", BinaryTreeUtils.toStringPostOrder(tree, left));
		assertEquals("String da �rvore partindo do filho 2", "5, 7, 6", BinaryTreeUtils.toStringPostOrder(tree, right));
	
	}

	/**
	 * Convertendo a �rvore para String utilizando inorder
	 */
	@Test
	public void arvoreParaStringInOrder() {	
		LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
		
		BTPosition<Integer> root = tree.addRoot(4);
		BTPosition<Integer> left = tree.insertLeft(root,2);
		BTPosition<Integer> right = tree.insertRight(root,6);

		tree.insertLeft(left, 1);
		tree.insertRight(left, 3);

		tree.insertLeft(right, 5);
		tree.insertRight(right, 7);
		
		assertEquals("String da �rvore partindo da raiz",    "1, 2, 3, 4, 5, 6, 7", BinaryTreeUtils.toStringInOrder(tree, root));
		assertEquals("String da �rvore partindo do filho esquerda", "1, 2, 3", BinaryTreeUtils.toStringInOrder(tree, left));
		assertEquals("String da �rvore partindo do filho 2", "5, 6, 7", BinaryTreeUtils.toStringInOrder(tree, right));
	}
	
}