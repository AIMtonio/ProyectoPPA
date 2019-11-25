package clases;

/**
 * Class ClienteObservador, implementa la interface SujetoObservable 
 * 
 * @author Liz Jimenez & Antonio Alonso
 */
import interfaces.*;

import java.util.ArrayList;

public class ClienteObservador implements SujetoObservable {

	String accion;
	String fecha;

	/**
	 * Constructor por defecto que inicializa variables
	 * 
	 * @param accion1
	 * @param fecha1
	 */
	public ClienteObservador(String accion1, String fecha1) {
		observadores = new ArrayList<Observador>();
		this.accion = accion1;
		this.fecha = fecha1;
	}

	// creacion de una lista para optimizacion de observadores
	private ArrayList<Observador> observadores;
	int tam;

	/**
	 * Metodo que Añade a la lista el objeto que observa
	 * 
	 * @param o
	 */
	public void enlazarObservador(Observador o) {
		observadores.add(o);
		tam = observadores.size();
	};

	/**
	 * Metodo que Actualiza el objeto que observa
	 */
	public void notificar() {
		for (Observador o : observadores) {
			o.update(tam, accion, fecha);
		}
	}

	/**
	 * Metodo que causa el cambio de estado
	 */
	public void despertador() {
		notificar();
	}

}
