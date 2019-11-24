
public class EncryptacionBasica1 {
	
	public static void main(String[] args) {
	
		String mensaje= "Hola mundo";
		char Array[]=mensaje.toCharArray();
		
		for(int i=0; i<Array.length; i++) {
			Array[i] = (char)(Array[i] + (char)5);
		}
		String encriptado = String.copyValueOf(Array);
		
		for(int i=0; i<Array.length; i++) {
			Array[i] = (char)(Array[i] - (char)5);
		}
		String desencriptado = String.copyValueOf(Array);
		
		System.out.println("Mensaje inicial: " + mensaje);
		System.out.println("Mensaje encryptado: " + encriptado);
		System.out.println("Texto desencriptado: " + desencriptado);
		
	}

}
