package interfaces;

/**
 * Interfaz que implementa el patron de Observer
 * 
 * @author Liz Jimenez
 */
public interface Observador {

	// observador

	/**
	 * Metodo que actualiza cuando el sujeto lo notifique o realize una accion
	 * 
	 * @param tamanioLista
	 * @param accion
	 * @param fecha
	 */
	public void update(int tamanioLista, String accion, String fecha);

}
