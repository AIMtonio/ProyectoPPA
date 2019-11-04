package clases;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import javax.swing.JOptionPane;

import conexion.ConexionPostgres;

public class Artista {
	int id_artista;
	String nombre, apellido, n_artistico, nacionalidad;
	String sexo;
	String fecha_nac;
	
	public void setId_artista(int id_artista) {
		this.id_artista = id_artista;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getN_artistico() {
		return n_artistico;
	}
	public void setN_artistico(String n_artistico) {
		this.n_artistico = n_artistico;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getFecha_nac() {
		return fecha_nac;
	}
	public void setFecha_nac(String fecha_nac) {
		this.fecha_nac = fecha_nac;
	}

	public Artista(String n_artistico) {
		super();
		this.n_artistico = n_artistico;
	}
	
	public int getId_artista() {
		return id_artista;
	}
	
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
	
	public Artista(int id_artista, String nombre, String apellido, String n_artistico, String nacionalidad) {
		super();
		this.id_artista = id_artista;
		this.nombre = nombre;
		this.apellido = apellido;
		this.n_artistico = n_artistico;
		this.nacionalidad = nacionalidad;
	}
	
	public void registrarArtista() {
		try{
            ConexionPostgres objConexion=new ConexionPostgres();
            Statement st=objConexion.getCon().createStatement();
			String sql="insert into artista (nombre, apellido, nombre_artistico, sexo_artista, fecha_nacimiento, nacionalidad)"
					+ "	values('"+nombre+"','"+apellido+"','"+n_artistico+"','"+sexo+"','"+fecha_nac+"','"+nacionalidad+"');";
			 st.executeUpdate(sql);
			 JOptionPane.showMessageDialog(null, "Registro exitoso");
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error de registro");
        }     
	}
	
	public void consultarIdArtista() {
		try{
            ConexionPostgres objConexion=new ConexionPostgres();//Crea conexion
            Statement st=objConexion.getCon().createStatement();
			String sql="Select id_artista from artista where nombre_artistico='"+n_artistico+"'";
			ResultSet rs=st.executeQuery(sql);
			while (rs.next()){
				id_artista=rs.getInt(1);
			}
        }catch(Exception e){
            e.printStackTrace();
        }        
	}
	
	public void consultarArtista(int id_art) {
		try{
            ConexionPostgres objConexion=new ConexionPostgres();//Crea conexion
            Statement st=objConexion.getCon().createStatement();
			String sql="Select * from artista where id_artista='"+id_art+"'";
			ResultSet rs=st.executeQuery(sql);
			while (rs.next()){
				id_artista=rs.getInt(1);
				nombre =  rs.getString(2);
				apellido = rs.getString(3);
				n_artistico = rs.getString(4);
				sexo = rs.getString(5);
				fecha_nac = rs.getString(6);
				nacionalidad = rs.getString(7);	
				JOptionPane.showMessageDialog(null, "Mostrando datos");
			}
        }catch(Exception e){
            e.printStackTrace();
        }        
	}
	
	public void validarArtista() {
		try{
            ConexionPostgres objConexion=new ConexionPostgres();//Crea conexion
            Statement st=objConexion.getCon().createStatement();
			String sql="Select id_artista from artista where nombre_artistico='"+n_artistico+"'";
			ResultSet rs=st.executeQuery(sql);
			while (rs.next()){
				id_artista=rs.getInt(1);
			}
        }catch(Exception e){
            e.printStackTrace();
        }        
	}
	
	public void modificarArtista() {
		try{
            ConexionPostgres objConexion=new ConexionPostgres();
            Statement st=objConexion.getCon().createStatement();
			String sql="update artista set nombre='"+nombre+"', apellido='"+apellido+"',"
					+ " nombre_artistico='"+n_artistico+"', nacionalidad='"+nacionalidad+"' "
					+ "where id_artista = "+id_artista+";";
			 st.executeUpdate(sql);
			 JOptionPane.showMessageDialog(null, "Actualización exitoso");
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error de acción");
        }     
	}
	
	public void eliminarArtista() {
		try{
            ConexionPostgres objConexion=new ConexionPostgres();
            Statement st=objConexion.getCon().createStatement();
			String sql="delete from artista where id_artista = "+id_artista+";";
			 st.executeUpdate(sql);
			 JOptionPane.showMessageDialog(null, "Artista Eliminado");
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error de acción");
        }     
	}
	
	
	
}
