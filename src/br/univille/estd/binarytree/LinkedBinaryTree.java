package br.univille.estd.binarytree;

/**
 * Implementacao de uma árvore binária usando estrutura encadeada
 * @author leandersonandre
 *
 * @param <E>
 */
public class LinkedBinaryTree<E> {
	
	protected BTPosition<E> root; // Referencia para a raiz
	protected int size;           // Numero de nodos
	
	/**
	 * Construtor de uma árvore vazia
	 */
	public LinkedBinaryTree() {
		root = null; // inicia com uma árvore vazia
		size = 0;
	}
	
	/**
	 * Retorna o numero de nodos da árvore
	 * @return
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Retorna se um nodo é interno
	 */
	public boolean isInternal(BTPosition<E> v) throws InvalidPositionException{
		if (v == null) {
			throw new InvalidPositionException("Deu merda");
		}

		return this.hasLeft(v) || this.hasRight(v);
	}
	
	
	/**
	 * Retorna se um nodo é externo
	 */
	public boolean isExternal(BTPosition<E> v) throws InvalidPositionException{
		return !isInternal(v);
	}
	
	/**
	 * Retorna se um nodo é a raiz
	 */
	public boolean isRoot(BTPosition<E> v) throws InvalidPositionException{
		if (v == null) {
			throw new InvalidPositionException("Deu merda");
		}

		return root.equals(v);
	}
	/**
	 * Retorna se um nodo tem o filho da esquerda
	 */ 
	
	public boolean hasLeft(BTPosition<E> v) throws InvalidPositionException{
		if (v == null) {
			throw new InvalidPositionException("Deu merda");
		}

		return v.getLeft() != null;
	}
	
	/**
	 * Retorna se um nodo tem o filho da direita
	 */
	public boolean hasRight(BTPosition<E> v) throws InvalidPositionException{
		if (v == null) {
			throw new InvalidPositionException("Deu merda");
		}

		return v.getRight() != null;
	}
	
	/**
	 * Retorna a raiz da árvore
	 */
	public BTPosition<E> root() throws EmptyTreeException{
		if (size == 0) {
			throw new EmptyTreeException("HEHE");
		}

		return root;
	}
	
	/**
	 * Retorna o filho da esquerda de um nodo
	 * Lança BoundaryViolationException se nao tiver filho da esquerda
	 */
	public BTPosition<E> left(BTPosition<E> v) throws InvalidPositionException, BoundaryViolationException{
		if (v == null) {
			throw new InvalidPositionException("Deu merda");
		}
		if (!hasLeft(v)) {
			throw new BoundaryViolationException("asdad");
		}

		return v.getLeft();
	}
	
	/**
	 * Retorna o filho da direita de um nodo
	 * Lança BoundaryViolationException se nao tiver filho da direita
	 */
	public BTPosition<E> right(BTPosition<E> v) throws InvalidPositionException, BoundaryViolationException{
		if (v == null) {
			throw new InvalidPositionException("Deu merda");
		}
		if (!hasRight(v)) {
			throw new BoundaryViolationException("asdad");
		}

		return v.getRight();
	}
	
	/**
	 * Retorna o pai de um nodo
	 * Lança BoundaryViolationException se nao tiver pai
	 */
	public BTPosition<E> parent(BTPosition<E> v) throws InvalidPositionException, BoundaryViolationException{
		if (v == null) {
			throw new InvalidPositionException("Deu merda");
		}
		
		if (hasRight(v) || hasLeft(v)) {
			throw new BoundaryViolationException("asdad");
		}
		
		return v.getParent();
	}
	
	/**
	 * Substitui o elemento armazenado no nodo
	 * Retorna o elemento substituido
	 */
	public E replace(BTPosition<E> v, E o) throws InvalidPositionException{
		if (v == null) {
			throw new InvalidPositionException("Deu merda");
		}
		
		E valor = v.getElement();

		v.setElement(o);
		
		return valor;
	}
	
	/**
	 * Retorna o irmao de um nodo
	 * Lança BoundaryViolationException se nao tiver um irmao
	 */
	public BTPosition<E> sibling(BTPosition<E> v) throws InvalidPositionException, BoundaryViolationException{
		if (v == null) {
			throw new InvalidPositionException("Deu merda");
		}

		if (hasRight(v) || hasLeft(v) || v.getParent() == null) {
			throw new BoundaryViolationException("asdad");
		}
		
		BTPosition<E> pai = v.getParent();
		
		if (pai.getLeft() != null && pai.getRight() != null) {
			return pai.getLeft().equals(v) ? pai.getRight() : pai.getLeft();
		} else {
			throw new BoundaryViolationException("N�o existe irm�o.");
		}
	}
	
	/**
	 * Insere a raiz em uma arvore vazia
	 */
	public BTPosition<E> addRoot(E e) throws NonEmptyTreeException{
		if (root != null) {
			throw new NonEmptyTreeException("�rvore n�o est� vazia");
		}
		
		root = new BTPosition<E>(e);
		
		size++;
		
		return root;
	}
	
	/**
	 * Insere o filho da esquerda em um nodo
	 */
	public BTPosition<E> insertLeft(BTPosition<E> v, E e) throws InvalidPositionException{
		if (v == null) {
			throw new InvalidPositionException("Deu merda");
		}
		
		BTPosition<E> obj = new BTPosition<E>(e);
		
		obj.setParent(v);
		v.setLeft(obj);
		
		size++;
		
		return obj;
	}
	
	/**
	 * Insere o filho da direita em um nodo
	 */
	public BTPosition<E> insertRight(BTPosition<E> v, E e) throws InvalidPositionException{
		if (v == null) {
			throw new InvalidPositionException("Deu merda");
		}
		
		BTPosition<E> obj = new BTPosition<E>(e);
		
		obj.setParent(v);
		v.setRight(obj);
		
		size++;
		
		return obj;
	}
	
	/**
	 * Remove um nodo com zero ou um filho
	 * Nao pode remover um nodo com dois filhos. Deve lancar InvalidPositionException
	 */
	public E remove(BTPosition<E> v) throws InvalidPositionException{
		if (v == null) {
			throw new InvalidPositionException("Deu merda");
		}
		
		BTPosition<E> leftPos = v.getLeft();
		BTPosition<E> rightPos = v.getRight();
		BTPosition<E> pos;
		
		if (leftPos != null && rightPos != null) {
			throw new InvalidPositionException("Deu merda");
		}
		
		if (leftPos != null) {
			pos = leftPos;
		} else if (rightPos != null) {
			pos = rightPos;
		} else {
			pos = null;
		}
		
		if (v == root) {
			if (pos != null) {
				pos.setParent(null);
			}
			
			root = pos;
		} else {
			BTPosition<E> pos1 = v.getParent();
			
			if (v == pos1.getLeft()) {
				pos1.setLeft(pos);
			} else {
				pos1.setRight(pos);
			}
			
			if (pos != null) {
				pos.setParent(pos1);
			}
		}
		
		size--;
		
		return v.getElement();
	}
	
	/**
	 *  Cria um novo nodo para a arvore binaria
	 */
	protected BTPosition<E> createNode(E element, BTPosition<E> parent, BTPosition<E> left, BTPosition<E> right) {
		size++;
		
		return new BTPosition<E>(element, parent, left, right);
	}
	
	

}
