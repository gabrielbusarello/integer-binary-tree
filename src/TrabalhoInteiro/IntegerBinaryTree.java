package TrabalhoInteiro;

import br.univille.estd.binarytree.BTPosition;
import br.univille.estd.binarytree.BinaryTreeUtils;
import br.univille.estd.binarytree.DuplicateValueException;
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
			this.compareAdd(tree.root());
		}
	}
	
	private void compareAdd(BTPosition<Integer> v) throws DuplicateValueException {
		if (i < v.getElement()) {
			if (tree.hasLeft(v)) {
				compareAdd(v.getLeft());
			} else {
				tree.insertLeft(v, i);
			}
		} else if (i > v.getElement()) {
			if (tree.hasRight(v)) {
				compareAdd(v.getRight());
			} else {
				tree.insertRight(v, i);	
			}
		} else {
			throw new DuplicateValueException("Já existe um nó com este valor (" + i + ")");
		}
	}
	
	private BTPosition<Integer> compare(BTPosition<Integer> v) {
		if (i < v.getElement() && tree.hasLeft(v) && v.getLeft().getElement() != i) {
			compare(v.getLeft());
		} else if (i > v.getElement() && tree.hasRight(v) && v.getRight().getElement() != i) {
			compare(v.getRight());
		} else {
			if (tree.hasRight(v) && v.getRight().getElement() == i) {
				return v.getRight();
			} else if (tree.hasLeft(v) && v.getLeft().getElement() == i) {
				return v.getLeft();
			} else {
				return v;
			}
		}
		return null;
	}

	@Override
	public boolean contains(Integer i) {
		this.i = i;
		return compare(tree.root()) != null;
	}

	@Override
	public void remove(Integer i) {
		this.i = i;
		BTPosition<Integer> rV = compare(tree.root());
		if (rV != null) {
			tree.remove(rV);
		}
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
		tree = new LinkedBinaryTree<Integer>();
	}

	@Override
	public String toString() {
		return BinaryTreeUtils.toStringInOrder(tree, tree.root());
	}

}
