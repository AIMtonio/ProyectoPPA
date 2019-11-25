package clases;

import interfaces.*;

import java.util.ArrayList;

public class ClienteObservador implements SujetoObservable{
	
	//acelerador
	
	String accion;
	String fecha;
	
	//Constructor por defecto que inicializa lista
	public ClienteObservador(String accion1, String fecha1) {
		observadores = new ArrayList<Observador>();
		this.accion = accion1;
		this.fecha = fecha1;
		}
	
	//creacion de una lista para optimizacion de observadores
	private ArrayList<Observador> observadores;
	int tam;
	
	//Añade a la lista el objeto que observa
	public void enlazarObservador(Observador o) {
		observadores.add(o);
		tam = observadores.size();
		};
	
	//Actualiza el objeto que observa
	public void notificar() {
		for(Observador o:observadores) {
			o.update(tam, accion, fecha);
		}
	}
	
	//Evento que causa el cambio de estado
	public void despertador() {
		notificar();
	}

}
