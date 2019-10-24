package TrabalhoInteiro;

public interface IntegerBinaryTreeI {
	// - Adiciona um novo inteiro. Lan�a exce��o DuplicateValueException se o inteiro j� existir na �rvore.
	public void add(Integer i);

	// - Retorna true se o inteiro existe na �rvore.
	public boolean contains(Integer i);

	// - Remove o inteiro da �rvore
	public void remove(Integer i);

	// - Retorna true se a �rvore estiver vazia
	public boolean isEmpty();

	// - Retorna a quantidade de elementos na �rvore 
	public int size();

	// - Remove todos os elementos da �rvore.
	public void clear();

	// - transforma a �rvore em String utilizando o caminhamento em in-order.
	public String toString();
}
