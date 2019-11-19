package clases;
/**
 * Class Disquera 
 * implementa la interface Interfaz
 * 
 * @author Liz Jimenez & Antonio Alonso
 */

import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import conexion.ConexionPostgres;
import interfaces.Interfaz;

public class Album implements Interfaz {

	// Variables de clase
	int id_album, id_art, id_dis;
	String genero;
	Float duracion;
	String fecha_lanza;
	String nombre_album, nombre_artista, nombre_disquera;

	// Gets
	/**
	 * Para obtener el valor de la variable id_album
	 * 
	 * @return id_album
	 */
	public int getId_album() {
		return id_album;
	}

	/**
	 * Para obtener el valor de la variable id_art
	 * 
	 * @return id_art
	 */
	public int getId_art() {
		return id_art;
	}

	/**
	 * Para obtener el valor de la variable id_dis
	 * 
	 * @return id_dis
	 */

	public int getId_dis() {
		return id_dis;
	}

	/**
	 * Para obtener el valor de la variable genero
	 * 
	 * @return genero
	 */

	public String getGenero() {
		return genero;
	}

	/**
	 * Para obtener el valor de la variable duracion
	 * 
	 * @return duracion
	 */
	public Float getDuracion() {
		return duracion;
	}

	/**
	 * Para obtener el valor de la variable fecha_lanza
	 * 
	 * @return fecha_lanza
	 */
	public String getFecha_lanza() {
		return fecha_lanza;
	}

	/**
	 * Para obtener el valor de la variable nombre_album
	 * 
	 * @return nombre_album
	 */
	public String getNombre_album() {
		return nombre_album;
	}

	/**
	 * Para obtener el valor de la variable nombre_artista
	 * 
	 * @return nombre_artista
	 */
	public String getNombre_artista() {
		return nombre_artista;
	}

	/**
	 * Para obtener el valor de la variable nombre_disquera
	 * 
	 * @return nombre_disquera
	 */
	public String getNombre_disquera() {
		return nombre_disquera;
	}

	// Sets

	/**
	 * Para la manipulacion de la variable id_album
	 *
	 * @param id_album para asignar un nuevo valor a la variable
	 */
	public void setId_album(int id_album) {
		this.id_album = id_album;
	}

	/**
	 * Para la manipulacion de la variable id_art
	 *
	 * @param id_art para asignar un nuevo valor a la variable
	 */

	public void setId_art(int id_art) {
		this.id_art = id_art;
	}

	/**
	 * Para la manipulacion de la variable id_dis
	 *
	 * @param id_dis para asignar un nuevo valor a la variable
	 */

	public void setId_dis(int id_dis) {
		this.id_dis = id_dis;
	}

	/**
	 * Para la manipulacion de la variable genero
	 *
	 * @param genero para asignar un nuevo valor a la variable
	 */

	public void setGenero(String genero) {
		this.genero = genero;
	}

	/**
	 * Para la manipulacion de la variable duracion
	 *
	 * @param duracion para asignar un nuevo valor a la variable
	 */
	public void setDuracion(Float duracion) {
		this.duracion = duracion;
	}

	/**
	 * Para la manipulacion de la variable fecha_lanza
	 *
	 * @param fecha_lanza para asignar un nuevo valor a la variable
	 */
	public void setFecha_lanza(String fecha_lanza) {
		this.fecha_lanza = fecha_lanza;
	}

	/**
	 * Para la manipulacion de la variable nombre_album
	 *
	 * @param nombre_album para asignar un nuevo valor a la variable
	 */
	public void setNombre_album(String nombre_album) {
		this.nombre_album = nombre_album;
	}

	/**
	 * Para la manipulacion de la variable nombre_artista
	 *
	 * @param nombre_artista para asignar un nuevo valor a la variable
	 */
	public void setNombre_artista(String nombre_artista) {
		this.nombre_artista = nombre_artista;
	}

	/**
	 * Para la manipulacion de la variable nombre_disquera
	 *
	 * @param nombre_disquera para asignar un nuevo valor a la variable
	 */
	public void setNombre_disquera(String nombre_disquera) {
		this.nombre_disquera = nombre_disquera;
	}

	// Constructores
	/**
	 * Constructor para inicializar las varibles de clase
	 * 
	 * @param id_art
	 * @param id_dis
	 * @param genero
	 * @param duracion
	 * @param nombre_album
	 */
	public Album(int id_art, int id_dis, String genero, Float duracion, String nombre_album) {
		super();
		this.id_art = id_art;
		this.id_dis = id_dis;
		this.genero = genero;
		this.duracion = duracion;
		this.nombre_album = nombre_album;
	}

	/**
	 * Constructor para inicializar las varibles de clase
	 * 
	 * @param nombre_artista
	 * @param nombre_disquera
	 */
	public Album(String nombre_artista, String nombre_disquera) {
		super();
		this.nombre_artista = nombre_artista;
		this.nombre_disquera = nombre_disquera;
	}

	/**
	 * Constructor para inicializar las varibles de clase
	 * 
	 * @param nombre_album
	 */
	public Album(String nombre_album) {
		super();
		this.nombre_album = nombre_album;
	}

	// Métodos

	/**
	 * Método para registrar un album mediante una sentencia
	 */
	public void registro() {
		try {
			ConexionPostgres objConexion = new ConexionPostgres();
			Statement st = objConexion.getCon().createStatement();
			String sql = "insert into album (nombre, artista, disquera, genero, duracion, fecha_lanzamiento)\r\n"
					+ "values ('" + nombre_album + "', " + id_art + ", " + id_dis + ", '" + genero + "', " + duracion
					+ ", CURRENT_DATE);";
			st.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "Registro exitoso");
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error de registro");
		}
	}

	/**
	 * Método para consultar un album
	 */
	public void consulta(int idart) {
		try {
			ConexionPostgres objConexion = new ConexionPostgres();// Crea conexion
			Statement st = objConexion.getCon().createStatement();
			String sql = "Select nombre_artistico from artista where id_artista='" + idart + "'";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				nombre_artista = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo para eliminar un album
	 */
	public void elimina() {
		try {
			ConexionPostgres objConexion = new ConexionPostgres();
			Statement st = objConexion.getCon().createStatement();
			String sql = "delete from album where id_album = " + id_album + ";";
			st.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "Album Eliminado");
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error de acción");
		}
	}

	/**
	 * Método para consultar ID de artista
	 */
	public void consultarIdArtista() {
		try {
			ConexionPostgres objConexion = new ConexionPostgres();// Crea conexion
			Statement st = objConexion.getCon().createStatement();
			String sql = "Select id_artista from artista where nombre_artistico='" + nombre_artista + "'";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				id_art = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo para consultar disquera
	 */

	public void consultarIdDisquera() {
		try {
			ConexionPostgres objConexion = new ConexionPostgres();// Crea conexion
			Statement st = objConexion.getCon().createStatement();
			String sql = "Select id_disquera from disquera where nombre='" + nombre_disquera + "'";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				id_dis = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Método para consiltar el ID del album
	 */
	public void consultarIdAlbum() {
		try {
			ConexionPostgres objConexion = new ConexionPostgres();// Crea conexion
			Statement st = objConexion.getCon().createStatement();
			String sql = "Select id_album from album where nombre='" + nombre_album + "'";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				id_album = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Método para consultar un album
	 */
	public void consultarAlbum() {
		try {
			ConexionPostgres objConexion = new ConexionPostgres();// Crea conexion
			Statement st = objConexion.getCon().createStatement();
			String sql = "Select * from album where id_album='" + id_album + "'";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				id_album = rs.getInt(1);
				nombre_album = rs.getString(2);
				id_art = rs.getInt(3);
				id_dis = rs.getInt(4);
				genero = rs.getString(5);
				duracion = rs.getFloat(6);
				fecha_lanza = rs.getString(7);
				JOptionPane.showMessageDialog(null, "Mostrando datos");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo para consultar el nombre de la disquera
	 * 
	 * @param iddi
	 */

	public void consultarNombreDisquera(int iddi) {
		try {
			ConexionPostgres objConexion = new ConexionPostgres();// Crea conexion
			Statement st = objConexion.getCon().createStatement();
			String sql = "Select nombre from disquera where id_disquera='" + iddi + "'";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				nombre_disquera = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo que modifica un album
	 */
	public void modifica() {
		// No aplica porque un album no se puede modificar una vez creado
	}

}
