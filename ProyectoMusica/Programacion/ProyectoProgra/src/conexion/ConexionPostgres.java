package conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionPostgres {
	
	private Connection con;
	
	 public Connection getCon() {
	        try{
	        	String clave="123456";
	    		String usuario="postgres";
	    		String url="jdbc:postgresql://localhost:5432/MusicalLife";
	            Class.forName("org.postgresql.Driver");
	            con=DriverManager.getConnection(url,usuario,clave);
	            return con;
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	        return con;   
	    }

}
