package TrabalhoInteiro;

import br.univille.estd.binarytree.BTPosition;
import br.univille.estd.binarytree.LinkedBinaryTree;

public class IntegerBinaryTree implements IntegerBinaryTreeI {
	private LinkedBinaryTree<Integer> tree;
	private Integer i;
	
	public IntegerBinaryTree() {
		 tree = new LinkedBinaryTree<Integer>();
		 i = 0;
	}
	
	@Override
	public void add(Integer i) {
		if (isEmpty()) {
			tree.addRoot(i);
		} else {
			this.i = i;
			this.compare(tree.root());
		}
	}
	
	private void compare(BTPosition<Integer> v) {
		if (i < v.getElement()) {
//			if (tree.hasLeft(v) || ) {
//				
//			}
			tree.insertLeft(v, i);
		} else if (i > v.getElement()) {
			tree.insertRight(v, i);
		} else {
			compare(v);
		}
	}

	@Override
	public boolean contains(Integer i) {
		return false;
	}

	@Override
	public void remove(Integer i) {
		size--;
	}
	
	@Override
	public boolean isEmpty() {
		return (tree.size() == 0);
	}

	@Override
	public int size() {
		return tree.size();
	}

	@Override
	public void clear() {
//		IntegerBinaryTree();
	}

}
