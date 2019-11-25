package conexion;

/**
 * Clase ConexionPostgresSingleton implementa el patron de diseño Singleton 
 * 
 * @author Liz Jimenez & Antonio Alonso
 */
import java.sql.*;

public class ConexionPostgresSingleton {

	// Propiedades
	private static Connection conn = null;
	private String driver;
	private String url;
	private String usuario;
	private String password;

	/**
	 * Contructor privado para manipulacion de la clase y variables
	 */
	private ConexionPostgresSingleton() {

		try {
			String password = "123456";
			String usuario = "postgres";
			String url = "jdbc:postgresql://localhost:5432/Musicallife";
			String driver = "org.postgresql.Driver";
			Class.forName(driver);
			conn = DriverManager.getConnection(url, usuario, password);
			// return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		// return con;

	} // Fin constructor

	// Métodos
	/**
	 * Instancia de la clase
	 * 
	 * @return conn
	 */
	public static Connection getConnection() {

		if (conn == null) {
			new ConexionPostgresSingleton();
		}

		return conn;
	} // Fin getConnection
}
