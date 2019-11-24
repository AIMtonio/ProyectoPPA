package clases;

/**
 * Class Artista, implementa la interface Interfaz 
 * Para la manipulacion del panelArtista
 * 
 * @author Liz Jimenez & Antonio Alonso
 */

//Importaciones 
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import conexion.ConexionPostgres;
<<<<<<< HEAD
<<<<<<< HEAD
=======
import conexion.ConexionPostgresSingleton;
>>>>>>> parent of 7aa23f5... Cambios
=======
import conexion.ConexionPostgresSingleton;
>>>>>>> parent of 7aa23f5... Cambios
import interfaces.Interfaz;

public class Artista implements Interfaz {
	// Variables de clase
	int id_artista;
	String nombre, apellido, n_artistico, nacionalidad;
	String sexo;
	String fecha_nac;

	// Gets
	/**
	 * Para obtener el valor de la variable id_artista
	 * 
	 * @return id_artista
	 */
	public int getId_artista() {
		return id_artista;
	}

	/**
	 * Para obtener el valor de la variable nombre
	 * 
	 * @return nombre
	 */
	public String getNombre() {

		return nombre;
	}

	/**
	 * Para obtener el valor de la variable apellido
	 * 
	 * @return apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * Para obtener el valor de la variable n_artistico
	 * 
	 * @return n_artistico
	 */

	public String getN_artistico() {
		return n_artistico;
	}

	/**
	 * Para obtener el valor de la variable nacionalidad
	 * 
	 * @return nacionalidad
	 */

	public String getNacionalidad() {
		return nacionalidad;
	}

	/**
	 * Para obtener el valor de la variable sexo
	 * 
	 * @return sexo
	 */
	public String getSexo() {
		return sexo;
	}

	/**
	 * Para obtener el valor de la variable fecha_nac
	 * 
	 * @return fecha_nac
	 */

	public String getFecha_nac() {
		return fecha_nac;
	}

	// Sets
	/**
	 * Para la manipulacion de la variable id_artista
	 * 
	 * @param id_artista para asignar un nuevo valor a la variable
	 */
	public void setId_artista(int id_artista) {
		this.id_artista = id_artista;
	}

	/**
	 * Para la manipulacion de la variable nombre
	 * 
	 * @param nombre para asignar un nuevo valor a la variable
	 */

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Para la manipulacion de la variable apellido
	 * 
	 * @param apellido para asignar un nuevo valor a la variable
	 */

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * Para la manipulacion de la variable n_artistico
	 * 
	 * @param n_artisitico para asignar un nuevo valor a la variable
	 */

	public void setN_artistico(String n_artistico) {
		this.n_artistico = n_artistico;
	}

	/**
	 * Para la manipulacion de la variable nacionalidad
	 * 
	 * @param nacionalidad para asignar un nuevo valor a la variable
	 */

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	/**
	 * Para la manipulacion de la variable sexo
	 * 
	 * @param sexo para asignar un nuevo valor a la variable
	 */

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	/**
	 * Para la manipulacion de la variable fecha_nac
	 * 
	 * @param fecha_nac para asignar un nuevo valor a la variable
	 */

	public void setFecha_nac(String fecha_nac) {
		this.fecha_nac = fecha_nac;
	}

	// Constructores

	/**
	 * Constructor que recibe el nombre artistico y lo asigna a la variable local
	 * 
	 * @param n_artistico
	 */

	public Artista(String n_artistico) {
		super();
		this.n_artistico = n_artistico;
	}

	/**
	 * Costructor para incializar todas las variables de clase
	 * 
	 * @param nombre
	 * @param apellido
	 * @param n_artistico
	 * @param nacionalidad
	 * @param sexo
	 * @param fecha_nac
	 */

	public Artista(String nombre, String apellido, String n_artistico, String nacionalidad, String sexo,
			String fecha_nac) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.n_artistico = n_artistico;
		this.nacionalidad = nacionalidad;
		this.sexo = sexo;
		this.fecha_nac = fecha_nac;
	}

	/**
	 * Constructor que inicializa algunas variables de clase
	 * 
	 * @param id_artista
	 * @param nombre
	 * @param apellido
	 * @param n_artistico
	 * @param nacionalidad
	 */
	public Artista(int id_artista, String nombre, String apellido, String n_artistico, String nacionalidad) {
		super();
		this.id_artista = id_artista;
		this.nombre = nombre;
		this.apellido = apellido;
		this.n_artistico = n_artistico;
		this.nacionalidad = nacionalidad;
	}

	/**
	 * Mètodo para registrar artista, implementa una sentencia.
	 */
	public void registro() {
		try {
			ConexionPostgres objConexion = new ConexionPostgres();
			Statement st = objConexion.getCon().createStatement();
			String sql = "insert into artista (nombre, apellido, nombre_artistico, sexo_artista, fecha_nacimiento,"
					+ " nacionalidad) values('" + nombre + "','" + apellido + "','" + n_artistico + "','" + sexo + "','"
					+ fecha_nac + "','" + nacionalidad + "');";
			st.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "Registro exitoso");
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error de registro");
		}
	}

	/**
	 * Mètodo para consultar un artista mediante su ID
	 * 
	 * @param id_art
	 */
	public void consulta(int id_art) {
		try {
			ConexionPostgres objConexion = new ConexionPostgres();// Crea conexion
			Statement st = objConexion.getCon().createStatement();
			String sql = "Select * from artista where id_artista='" + id_art + "'";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				id_artista = rs.getInt(1);
				nombre = rs.getString(2);
				apellido = rs.getString(3);
				n_artistico = rs.getString(4);
				sexo = rs.getString(5);
				fecha_nac = rs.getString(6);
				nacionalidad = rs.getString(7);
				JOptionPane.showMessageDialog(null, "Mostrando datos");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Mètodo para modicicar un artista
	 */
	public void modifica() {
		try {
			ConexionPostgres objConexion = new ConexionPostgres();
			Statement st = objConexion.getCon().createStatement();
			String sql = "update artista set nombre='" + nombre + "', apellido='" + apellido + "',"
					+ " nombre_artistico='" + n_artistico + "', nacionalidad='" + nacionalidad + "' "
					+ "where id_artista = " + id_artista + ";";
			st.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "Actualización exitoso");
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error de acción");
		}
	}

	/**
	 * Mètodo para eliminar un artista
	 */
	public void elimina() {
		try {
			ConexionPostgres objConexion = new ConexionPostgres();
			Statement st = objConexion.getCon().createStatement();
			String sql = "delete from artista where id_artista = " + id_artista + ";";
			st.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "Artista Eliminado");
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error de acción");
		}
	}

	/**
	 * Mètodo que consulta el id del artista de acuerdo a su nombre artistico
	 */

	public void consultarIdArtista() {
		try {
			ConexionPostgres objConexion = new ConexionPostgres();// Crea conexion
			Statement st = objConexion.getCon().createStatement();
			String sql = "Select id_artista from artista where nombre_artistico='" + n_artistico + "'";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				id_artista = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo para validar la existencia de ese nombre artistico, ya que no se podrà
	 * repetir
	 */
	public void validarArtista() {
		try {
			ConexionPostgres objConexion = new ConexionPostgres();// Crea conexion
			Statement st = objConexion.getCon().createStatement();
			String sql = "Select id_artista from artista where nombre_artistico='" + n_artistico + "'";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				id_artista = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
