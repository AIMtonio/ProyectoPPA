package clases;

import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import conexion.ConexionPostgres;
import froms.PanelAlbum;

public class Album {

	int id_album, id_art, id_dis;
	String genero;
	Float duracion;
	String fecha_lanza;
	String nombre_album, nombre_artista, nombre_disquera;
	
	
	public int getId_album() {
		return id_album;
	}
	public void setId_album(int id_album) {
		this.id_album = id_album;
	}
	public int getId_art() {
		return id_art;
	}
	public void setId_art(int id_art) {
		this.id_art = id_art;
	}
	public int getId_dis() {
		return id_dis;
	}
	public void setId_dis(int id_dis) {
		this.id_dis = id_dis;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public Float getDuracion() {
		return duracion;
	}
	public void setDuracion(Float duracion) {
		this.duracion = duracion;
	}
	public String getFecha_lanza() {
		return fecha_lanza;
	}
	public void setFecha_lanza(String fecha_lanza) {
		this.fecha_lanza = fecha_lanza;
	}
	
	public String getNombre_album() {
		return nombre_album;
	}
	public void setNombre_album(String nombre_album) {
		this.nombre_album = nombre_album;
	}
	public String getNombre_artista() {
		return nombre_artista;
	}
	public void setNombre_artista(String nombre_artista) {
		this.nombre_artista = nombre_artista;
	}
	public String getNombre_disquera() {
		return nombre_disquera;
	}
	public void setNombre_disquera(String nombre_disquera) {
		this.nombre_disquera = nombre_disquera;
	}
	
	public Album(int id_art, int id_dis, String genero, Float duracion, String nombre_album) {
		super();
		this.id_art = id_art;
		this.id_dis = id_dis;
		this.genero = genero;
		this.duracion = duracion;
		this.nombre_album = nombre_album;
	}
	public Album(String nombre_artista, String nombre_disquera) {
		super();
		this.nombre_artista = nombre_artista;
		this.nombre_disquera = nombre_disquera;
	}
	
	public Album(String nombre_album) {
		super();
		this.nombre_album = nombre_album;
	}
	
	public void consultarIdArtista() {
		try{
            ConexionPostgres objConexion=new ConexionPostgres();//Crea conexion
            Statement st=objConexion.getCon().createStatement();
			String sql="Select id_artista from artista where nombre_artistico='"+nombre_artista+"'";
			ResultSet rs=st.executeQuery(sql);
			while (rs.next()){
				id_art=rs.getInt(1);
			}
        }catch(Exception e){
            e.printStackTrace();
        }        
	}
	
	public void consultarIdDisquera() {
		try{
            ConexionPostgres objConexion=new ConexionPostgres();//Crea conexion
            Statement st=objConexion.getCon().createStatement();
			String sql="Select id_disquera from disquera where nombre='"+nombre_disquera+"'";
			ResultSet rs=st.executeQuery(sql);
			while (rs.next()){
				id_dis=rs.getInt(1);
			}
        }catch(Exception e){
            e.printStackTrace();
        }        
	}
	
	public void registrarAlbum() {
		try{
            ConexionPostgres objConexion=new ConexionPostgres();
            Statement st=objConexion.getCon().createStatement();
			String sql="insert into album (nombre, artista, disquera, genero, duracion, fecha_lanzamiento)\r\n" + 
					"values ('"+nombre_album+"', "+id_art+", "+id_dis+", '"+genero+"', "+duracion+", CURRENT_DATE);";
			 st.executeUpdate(sql);
			 JOptionPane.showMessageDialog(null, "Registro exitoso");
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error de registro");
        }     
	}
	
	public void consultarIdAlbum() {
		try{
            ConexionPostgres objConexion=new ConexionPostgres();//Crea conexion
            Statement st=objConexion.getCon().createStatement();
			String sql="Select id_album from album where nombre='"+nombre_album+"'";
			ResultSet rs=st.executeQuery(sql);
			while (rs.next()){
				id_album=rs.getInt(1);
			}
        }catch(Exception e){
            e.printStackTrace();
        }        
	}
	
	public void consultarAlbum() {
		try{
            ConexionPostgres objConexion=new ConexionPostgres();//Crea conexion
            Statement st=objConexion.getCon().createStatement();
			String sql="Select * from album where id_album='"+id_album+"'";
			ResultSet rs=st.executeQuery(sql);
			while (rs.next()){
				id_album=rs.getInt(1);
				nombre_album =  rs.getString(2);
				id_art = rs.getInt(3);
				id_dis = rs.getInt(4);
				genero = rs.getString(5);
				duracion = rs.getFloat(6);
				fecha_lanza = rs.getString(7);	
				JOptionPane.showMessageDialog(null, "Mostrando datos");
			}
        }catch(Exception e){
            e.printStackTrace();
        }        
	}
	
	public void consultarNombreArtista(int idart) {
		try{
            ConexionPostgres objConexion=new ConexionPostgres();//Crea conexion
            Statement st=objConexion.getCon().createStatement();
			String sql="Select nombre_artistico from artista where id_artista='"+idart+"'";
			ResultSet rs=st.executeQuery(sql);
			while (rs.next()){
				nombre_artista=rs.getString(1);
			}
        }catch(Exception e){
            e.printStackTrace();
        }        
	}
	
	public void consultarNombreDisquera(int iddi) {
		try{
            ConexionPostgres objConexion=new ConexionPostgres();//Crea conexion
            Statement st=objConexion.getCon().createStatement();
			String sql="Select nombre from disquera where id_disquera='"+iddi+"'";
			ResultSet rs=st.executeQuery(sql);
			while (rs.next()){
				nombre_disquera=rs.getString(1);
			}
        }catch(Exception e){
            e.printStackTrace();
        }        
	}
	
	public void eliminarAlbum() {
		try{
            ConexionPostgres objConexion=new ConexionPostgres();
            Statement st=objConexion.getCon().createStatement();
			String sql="delete from album where id_album = "+id_album+";";
			 st.executeUpdate(sql);
			 JOptionPane.showMessageDialog(null, "Album Eliminado");
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error de acción");
        }     
	}
	
	
}
