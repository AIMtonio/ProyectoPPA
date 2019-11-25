package observerTony;

import java.util.ArrayList;

public class Acelerador implements SujetoObservable{
	
	//Constructor por defecto que inicializa lista
	public Acelerador() {observadores = new ArrayList<Observador>();}
	
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
			o.update(tam);
		}
	}
	
	//Evento que causa el cambio de estado
	public void pisarAcelerador() {
		//subir potencia
		notificar();
	}

}
