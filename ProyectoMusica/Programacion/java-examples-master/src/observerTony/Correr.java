package observerTony;

public class Correr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Motor v8 = new Motor();
		
		Acelerador x= new Acelerador();
		
		x.enlazarObservador(v8);
		x.enlazarObservador(v8);
		
		x.pisarAcelerador();
		
		
		
	}

}
