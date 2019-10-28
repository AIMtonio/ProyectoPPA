package conexion;
import java.sql.ResultSet;
import java.sql.Statement;

public class Registro {

	public void registrarArtista() {
		try{
            ConexionPostgres objConexion=new ConexionPostgres();
            Statement st=objConexion.getCon().createStatement();
			String sql="insert into artista (nombre, apellido, nombre_artistico, fecha_nacimiento, nacionalidad)"
					+ "	values('123','456','789','1998-07-15','000');";
			 st.executeUpdate(sql);
			 System.out.println("Registro exitoso");
        }catch(Exception e){
            e.printStackTrace();
        }     
	}
	
	public static void main(String[] args) {
		Registro a=new Registro();
		a.registrarArtista();

	}
	
}
