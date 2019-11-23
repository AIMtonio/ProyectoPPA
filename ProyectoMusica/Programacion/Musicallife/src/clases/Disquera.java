package clases;
/**
 * Class Disquera, implementa la interface Interfaz 
 * Para la manipulacion del panelDisquera
 * 
 * @author Liz Jimenez & Antonio Alonso
 */

//Importaciones
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import conexion.ConexionPostgres;
import interfaces.Interfaz;

public class Disquera implements Interfaz {
//Variables locales 
	int id_disquera;
	String nombre_d, direccion, correo;
	String fecha_creacion;
	long telefono;

	// Gets

	/**
	 * Para obtener el valor de la variable id_disquera
	 * 
	 * @return id_disquera
	 */
	public int getId_disquera() {
		return id_disquera;
	}

	/**
	 * Para obtener el valor de la variable nombre_d
	 * 
	 * @return nombre_d
	 */
	public String getNombre_d() {
		return nombre_d;
	}

	/**
	 * Para obtener el valor de la variable direccion
	 * 
	 * @return direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Para obtener el valor de la variable correo
	 * 
	 * @return correo
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * Para obtener el valor de la variable fecha_creacion
	 * 
	 * @return fecha_creacion
	 */
	public String getFecha_creacion() {
		return fecha_creacion;
	}

	/**
	 * Para obtener el valor de la variable telefono
	 * 
	 * @return telefono
	 */
	public long getTelefono() {
		return telefono;
	}

	// Sets
	/**
	 * Para la manipulacion de la variable id_disquera
	 * 
	 * @param id_disquera para asignar un nuevo valor a la variable
	 */
	public void setId_disquera(int id_disquera) {
		this.id_disquera = id_disquera;
	}

	/**
	 * Para la manipulacion de la variable nombre_d
	 * 
	 * @param nombre_d para asignar un nuevo valor a la variable
	 */

	public void setNombre_d(String nombre_d) {
		this.nombre_d = nombre_d;
	}

	/**
	 * Para la manipulacion de la variable direccion
	 * 
	 * @param direccion para asignar un nuevo valor a la variable
	 */

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * Para la manipulacion de la variable correo
	 * 
	 * @param correo para asignar un nuevo valor a la variable
	 */

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	/**
	 * Para la manipulacion de la variable fecha_creacion
	 * 
	 * @param fecha_creacion para asignar un nuevo valor a la variable
	 */

	public void setFecha_creacion(String fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	/**
	 * Para la manipulacion de la variable telefono
	 * 
	 * @param telefono para asignar un nuevo valor a la variable
	 */

	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}

	// Constructores

	/**
	 * Constructor para inicializar las varibles de clase
	 * 
	 * @param nombre_d
	 * @param direccion
	 * @param correo
	 * @param fecha_creacion
	 * @param telefono
	 */
	public Disquera(String nombre_d, String direccion, String correo, String fecha_creacion, long telefono) {
		super();
		this.nombre_d = nombre_d;
		this.direccion = direccion;
		this.correo = correo;
		this.fecha_creacion = fecha_creacion;
		this.telefono = telefono;
	}

	/**
	 * Constructor para inicializar algunas variables de clase
	 * 
	 * @param nombre_d
	 * @param direccion
	 * @param correo
	 * @param telefono
	 */
	public Disquera(String nombre_d, String direccion, String correo, long telefono) {
		super();
		this.nombre_d = nombre_d;
		this.direccion = direccion;
		this.correo = correo;
		this.telefono = telefono;
	}

	/**
	 * Constructor para incializar la variable nombre_d
	 * 
	 * @param nombre_d
	 */
	public Disquera(String nombre_d) {
		super();
		this.nombre_d = nombre_d;
	}
	// Mètodos

	/**
	 * Mètodo para registrar una disquera, implementa una sentencia Captura las
	 * excepciones
	 */
	public void registro() {
		try {
			ConexionPostgres objConexion = new ConexionPostgres();
			Statement st = objConexion.getCon().createStatement();
			String sql = "insert into disquera (nombre, direccion, telefono, correo, fecha_creacion)" + " values('"
					+ nombre_d + "','" + direccion + "'," + telefono + ",'" + correo + "','" + fecha_creacion + "');";
			st.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "Registro exitoso");
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error de registro");
		}
	}

	/**
	 * Mètodo para modificar una disquera
	 */
	public void modifica() {
		try {
			ConexionPostgres objConexion = new ConexionPostgres();
			Statement st = objConexion.getCon().createStatement();
			String sql = "update disquera set nombre='" + nombre_d + "'," + " direccion='" + direccion + "', telefono="
					+ telefono + ", correo='" + correo + "';";
			st.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "Actualización exitoso");
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error de acción");
		}
	}

	/**
	 * Mètodo para eliminar una disquera
	 */

	public void elimina() {
		try {
			ConexionPostgres objConexion = new ConexionPostgres();
			Statement st = objConexion.getCon().createStatement();
			String sql = "delete from disquera where id_disquera = " + id_disquera + ";";
			st.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "Disquera Eliminada");
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error de acción");
		}
	}

	/**
	 * Mèdoto para consultar disquera
	 */

	public void consultarDisquera() {
		try {
			ConexionPostgres objConexion = new ConexionPostgres();// Crea conexion
			Statement st = objConexion.getCon().createStatement();
			String sql = "Select * from disquera where id_disquera='" + id_disquera + "'";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				id_disquera = rs.getInt(1);
				nombre_d = rs.getString(2);
				direccion = rs.getString(3);
				telefono = rs.getLong(4);
				correo = rs.getString(5);
				fecha_creacion = rs.getString(6);
				JOptionPane.showMessageDialog(null, "Mostrando datos");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Mètodo para consultar el ID de una disquera
	 */

	public void consultarIdDisquera() {
		try {
			ConexionPostgres objConexion = new ConexionPostgres();// Crea conexion
			Statement st = objConexion.getCon().createStatement();
			String sql = "Select id_disquera from disquera where nombre='" + nombre_d + "'";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				id_disquera = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void consulta(int id) {
		try {
			ConexionPostgres objConexion = new ConexionPostgres();
			Statement st = objConexion.getCon().createStatement();
			String sql = "Select * from disquera where id_disquera='" + id_disquera + "'";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				id_disquera = rs.getInt(1);
				nombre_d = rs.getString(2);
				direccion = rs.getString(3);
				telefono = rs.getLong(4);
				correo = rs.getString(5);
				fecha_creacion = rs.getString(6);
				JOptionPane.showMessageDialog(null, "Mostrando datos");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
