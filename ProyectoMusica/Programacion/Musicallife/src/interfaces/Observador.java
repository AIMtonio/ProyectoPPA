package interfaces;

public interface Observador {
	
	//observador

	//Se actualiza cuando el sujeto lo notifique o realize una accion
	public void update(int tamanioLista, String accion, String fecha);
	
}
