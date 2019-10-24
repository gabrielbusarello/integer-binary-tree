package TrabalhoInteiro;

public interface IntegerBinaryTreeI {
	// - Adiciona um novo inteiro. Lança exceção DuplicateValueException se o inteiro já existir na árvore.
	public void add(Integer i);

	// - Retorna true se o inteiro existe na árvore.
	public boolean contains(Integer i);

	// - Remove o inteiro da árvore
	public void remove(Integer i);

	// - Retorna true se a árvore estiver vazia
	public boolean isEmpty();

	// - Retorna a quantidade de elementos na árvore 
	public int size();

	// - Remove todos os elementos da árvore.
	public void clear();

	// - transforma a árvore em String utilizando o caminhamento em in-order.
	public String toString();
}
