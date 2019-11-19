package conexion;

/**
 * Conexion con Postgres
 * 
 * @author Liz Jimenez & Antonio Alonso
 * 
 */
import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionPostgres {
	// Variable de clase privada
	private Connection con;

	/**
	 * Constructor que ejecuta la conexion con los parametros establecidos
	 * 
	 * @return con
	 */
	public Connection getCon() {
		try {
			String clave = "123456";
			String usuario = "postgres";
			String url = "jdbc:postgresql://localhost:5432/Musicallife";
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url, usuario, clave);
			return con;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

}
