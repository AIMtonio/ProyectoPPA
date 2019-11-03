package conexion;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class Registro {
	
	String n="hola",ap="hola",na="hola",s="M",f="1998-07-15",nac="hola";
	
	Date fecha="1998-07-15";

	public void registrarArtista() {
		try{
            ConexionPostgres objConexion=new ConexionPostgres();
            Statement st=objConexion.getCon().createStatement();
			String sql="insert into artista (nombre, apellido, nombre_artistico, sexo_artista, fecha_nacimiento, nacionalidad)"
					+ "	values('"+n+"','"+ap+"','"+na+"','"+s+"','"+f+"','"+nac+"');";
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
