package TrabalhoInteiro;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import br.univille.estd.binarytree.BTPosition;
import br.univille.estd.binarytree.DuplicateValueException;
import br.univille.estd.binarytree.InvalidPositionException;

public class IntegerBinaryTreeTests {

	/**
	 * Criar um novo nodo para uma arvore binaria
	 */
	@Test
	public void addNode() {
		IntegerBinaryTree tree = new IntegerBinaryTree();
		
		tree.add(4);
		tree.add(3);
		tree.add(2);
		tree.add(1);
		tree.add(5);
		tree.add(6);
		tree.add(7);

		assertEquals("Verifica se contém o nodo com valor 2 para árvore binária.", "1, 2, 3, 4, 5, 6, 7", tree.toString());
		assertEquals("Quantidade de Nodos para árvore binária.", tree.size(), 7);
		try {
			tree.add(7);
			fail("Nodo invalido");
		}catch(DuplicateValueException e) { }
	}
	
	@Test
	public void containsNode() {
		IntegerBinaryTree tree = new IntegerBinaryTree();
		
		tree.add(4);
		tree.add(3);
		tree.add(2);
		tree.add(1);
		tree.add(5);
		tree.add(6);
		tree.add(7);

		assertEquals("Verifica se contém o nodo com valor 4 para árvore binária.", true, tree.contains(4));
		assertEquals("Verifica se contém o nodo com valor 4 para árvore binária.", true, tree.contains(3));
	}
}
