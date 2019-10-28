package conexion;
import java.sql.ResultSet;
import java.sql.Statement;


public class Prueba {

	public void pedirNombre() {
		try{
            //final String sql= "select * from artista";//Sintaxis
            ConexionPostgres objConexion=new ConexionPostgres();//Crea conexion
            Statement st=objConexion.getCon().createStatement();
			String sql="Select * from artista";
			ResultSet rs=st.executeQuery(sql);
			while (rs.next()){
				System.out.println("ID: " + rs.getString(1));
				System.out.println("Nombre: " + rs.getString(2));
				System.out.println("Apellido: " + rs.getString(3));
				System.out.println("Nombre Artistico: " + rs.getString(4));
				System.out.println("Fecha de nacimiento: " + rs.getString(5));
				System.out.println("Nacionalidad: " + rs.getString(6));	
			}
        }catch(Exception e){
            e.printStackTrace();
        }        	
	}
	
	public static void main(String[] args) {
		Prueba a=new Prueba();
		a.pedirNombre();

	}

}
