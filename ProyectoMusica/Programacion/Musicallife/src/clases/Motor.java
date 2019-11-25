package clases;

import interfaces.*;

public class Motor implements Observador{
	
	public Motor() {
		
	}
	
	public void update() {
		System.out.println("Subir potencia y velocidad");
		//accion a realiza despues de que se entera que el acelerador esta on
	}

}
