package froms;

import java.awt.EventQueue;

public class Main {

	public static void main(String[] args) {
		  // arranca en un hilo de ejecución... 
		  EventQueue.invokeLater(new Runnable() {
		   public void run() {
		    try {
		     // creando el frame y lo muestra
		     Artista frame = new Artista();
		     frame.setVisible(true);
		    } catch (Exception e) {
		     e.printStackTrace();
		    }
		   }
		  });
		 }
}
