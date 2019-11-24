import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Signature;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;

public class CipherEjemplo {
	
   public static void main(String args[]) throws Exception{
   
      //Crear un objeto de firma
      Signature sign = Signature.getInstance("SHA256withRSA");
      
      // Definición del tipo de algoritmo a utilizar (AES, DES, RSA)
      KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
      
      //Inicializando el generador de keyPair
      keyPairGen.initialize(2048);
      
      //Generando el par de llaves
      KeyPair pair = keyPairGen.generateKeyPair();      
	
      // Definición del modo de cifrado a utilizar
      Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        
      //Inicializando el objeto Cipher 
      cipher.init(Cipher.ENCRYPT_MODE, pair.getPublic());
	  
      //Agregar dato al cifrado
      byte[] dato = "9ITI2 Java.crypto".getBytes();	  
      cipher.update(dato);
	  
      //Encriptando el dato
      byte[] cipherText = cipher.doFinal();	 
      System.out.println(new String(cipherText, "UTF8"));
   }
}