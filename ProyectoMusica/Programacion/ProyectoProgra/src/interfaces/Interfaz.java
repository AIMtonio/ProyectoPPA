package interfaces;

/**
 * Interface principal, par que todas las clases que la implementen tengan la
 * misma estructura.
 * 
 * @author Liz Jimenez & Antonio Alonso
 */

public interface Interfaz {
	/**
	 * Método para registar dependiendo de la clase el la que se implemente.
	 */
	void registro();

	/**
	 * Método para consultar dependiendo de la clase el la que se implemente.
	 */

	void consulta(int id);

	/**
	 * Método para modificar dependiendo de la clase el la que se implemente.
	 */
	void modifica();

	/**
	 * Método para eliminar dependiendo de la clase el la que se implemente.
	 */
	void elimina();

}
