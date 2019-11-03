package clases;

import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import conexion.ConexionPostgres;

public class Disquera {

	int id_disquera;
	String nombre_d, direccion, correo;
	String fecha_creacion;
	long telefono;
	
	public int getId_disquera() {
		return id_disquera;
	}
	public void setId_disquera(int id_disquera) {
		this.id_disquera = id_disquera;
	}
	public String getNombre_d() {
		return nombre_d;
	}
	public void setNombre_d(String nombre_d) {
		this.nombre_d = nombre_d;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getFecha_creacion() {
		return fecha_creacion;
	}
	public void setFecha_creacion(String fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}
	public long getTelefono() {
		return telefono;
	}
	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}
	
	public Disquera() {
		
	}
	
	public Disquera(String nombre_d, String direccion, String correo, String fecha_creacion, long telefono) {
		super();
		this.nombre_d = nombre_d;
		this.direccion = direccion;
		this.correo = correo;
		this.fecha_creacion = fecha_creacion;
		this.telefono = telefono;
	}
	
	public Disquera(String nombre_d) {
		super();
		this.nombre_d = nombre_d;
	}
	public void registrarDisquera() {
		try{
            ConexionPostgres objConexion=new ConexionPostgres();
            Statement st=objConexion.getCon().createStatement();
			String sql="insert into disquera (nombre, direccion, telefono, correo, fecha_creacion)"
					+ " values('"+nombre_d+"','"+direccion+"',"+telefono+",'"+correo+"','"+fecha_creacion+"');";
			 st.executeUpdate(sql);
			 JOptionPane.showMessageDialog(null, "Registro exitoso");
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error de registro");
        }     
	}
	
	public void consultarIdDisquera() {
		try{
            ConexionPostgres objConexion=new ConexionPostgres();//Crea conexion
            Statement st=objConexion.getCon().createStatement();
			String sql="Select id_disquera from disquera where nombre='"+nombre_d+"'";
			ResultSet rs=st.executeQuery(sql);
			while (rs.next()){
				id_disquera=rs.getInt(1);
			}
        }catch(Exception e){
            e.printStackTrace();
        }        
	}

	public void consultarDisquera() {
		try{
            ConexionPostgres objConexion=new ConexionPostgres();//Crea conexion
            Statement st=objConexion.getCon().createStatement();
			String sql="Select * from disquera where id_disquera='"+id_disquera+"'";
			ResultSet rs=st.executeQuery(sql);
			while (rs.next()){
				id_disquera=rs.getInt(1);
				nombre_d =  rs.getString(2);
				direccion = rs.getString(3);
				telefono = rs.getLong(4);
				correo = rs.getString(5);
				fecha_creacion = rs.getString(6);
				JOptionPane.showMessageDialog(null, "Mostrando datos");
			}
        }catch(Exception e){
            e.printStackTrace();
        }        
	}

	
	
	
	
}
