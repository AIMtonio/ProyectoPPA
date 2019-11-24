import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class EncryptacionBasica {
	
	//Metodo de encriptar
	private static String encriptar(String s) throws UnsupportedEncodingException{
        return Base64.getEncoder().encodeToString(s.getBytes("utf-8"));
    }
	
	//Metodo desencriptar
	private static String desencriptar(String s) throws UnsupportedEncodingException{
        byte[] decode = Base64.getDecoder().decode(s.getBytes());
        return new String(decode, "utf-8");
    }
	
	//Main
	public static void main(String[] args) {
        String cadenaDeTexto = "http://antonioalonsoperez.com";
        try {
            System.out.println("Cadena original > "+cadenaDeTexto);
            String cadenaEncriptada = encriptar(cadenaDeTexto);
            System.out.println("Cadena encriptada > "+cadenaEncriptada);
            String cadenaDesencriptada = desencriptar(cadenaEncriptada);
            System.out.println("Cadena desencriptada > "+cadenaDesencriptada);
        } catch (UnsupportedEncodingException uee) {
            System.out.println("Ups!! > "+uee);
        }//Fin excepcion
    }//Fin Main

}//Fin class
