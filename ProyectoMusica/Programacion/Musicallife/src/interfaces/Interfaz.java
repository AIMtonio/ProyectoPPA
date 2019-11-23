package interfaces;

/**
 * Interface principal, par que todas las clases que la implementen tengan la
 * misma estructura.
 * 
 * @author Liz Jimenez & Antonio Alonso
 */

public interface Interfaz {
	/**
	 * M�todo para registar dependiendo de la clase el la que se implemente.
	 */
	void registro();

	/**
	 * M�todo para consultar dependiendo de la clase el la que se implemente.
	 */

	void consulta(int id);

	/**
	 * M�todo para modificar dependiendo de la clase el la que se implemente.
	 */
	void modifica();

	/**
	 * M�todo para eliminar dependiendo de la clase el la que se implemente.
	 */
	void elimina();

}
