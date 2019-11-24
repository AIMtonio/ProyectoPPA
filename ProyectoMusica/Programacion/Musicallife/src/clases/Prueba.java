package clases;

import java.sql.Connection;
import java.sql.Statement;
import conexion.*;
import javax.swing.JOptionPane;


import conexion.ConexionPostgres1;

public class Prueba {
	
	Connection conn = ConexionPostgresSingleton.getConnection();
	
	public void registro() {
		try {
			//ConexionPostgres objConexion = new ConexionPostgres();
			Statement st = conn.createStatement();
			String sql = "insert into artista (nombre, apellido, nombre_artistico, sexo_artista, fecha_nacimiento,"
					+ " nacionalidad) values('antonio','alonso','aimtonio','M','1998-07-15','mexicano');";
			st.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "Registro exitoso");
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error de registro");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Prueba obj=new Prueba();
		obj.registro();
		
		
	}

}
