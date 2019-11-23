
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EjemploSingleton {

	// Propiedades
	private static Connection conn = null;
	private String driver;
	private String url;
	private String usuario;
	private String password;

	// Constructor
	private EjemploSingleton() {
		
		String password = "123456";
		String usuario = "postgres";
		String url = "jdbc:postgresql://localhost:5432/Musicallife";
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(url, usuario, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	} // Fin constructor

	// Métodos
	public static Connection getConnection() {

		if (conn == null) {
			new EjemploSingleton();
		}

		return conn;
	} // Fin getConnection
}